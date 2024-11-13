
//public class Main {
//    public static void main(String[] args) {
//        try {
//            // Criando um autor
//            Autor autor = new Autor("pedringo22", "2121", "jorge", "kjafbjka");
//
//            // Criando instâncias de diferentes artes
//            Livro livro = new Livro("Dom Quixote", autor, 1605, 500, "Romance");
//            Musica musica = new Musica("Imagine", autor, 1971, 100, "Rock", "mp3");
//            Pintura pintura = new Pintura("Noite Estrelada", autor, 1889, 2000000, "Impressionismo");
//
//            // Adicionando notas a cada arte
//            livro.adicionarNotaArte(8);
//            livro.adicionarNotaArte(9);
//            System.out.println("Média das notas para o livro '" + livro.getNomeArte() + "': " + livro.calcularMediaNotasArte());
//
//            musica.adicionarNotaArte(10);
//            musica.adicionarNotaArte(9);
//            System.out.println("Média das notas para a música '" + musica.getNomeArte() + "': " + musica.calcularMediaNotasArte());
//
//            pintura.adicionarNotaArte(7);
//            pintura.adicionarNotaArte(8);
//            System.out.println("Média das notas para a pintura '" + pintura.getNomeArte() + "': " + pintura.calcularMediaNotasArte());
//
//            // Exibindo detalhes e listando todas as artes criadas
//            System.out.println("\n--- Detalhes das Artes ---");
//            System.out.println(livro);
//            System.out.println(musica);
//            System.out.println(pintura);
//
//            // Listando todas as artes (utilizando os métodos listarArtes de cada subclasse)
//            System.out.println("\n--- Listagem de Livros ---");
//            System.out.println(livro.listarArtes());
//
//            System.out.println("\n--- Listagem de Músicas ---");
//            System.out.println(musica.listarArtes());
//
//            System.out.println("\n--- Listagem de Pinturas ---");
//            System.out.println(pintura.listarArtes());
//
//        } catch (ExtensaoException e) {
//            System.out.println("Erro: Extensão inválida para a música.");
//        }
//    }
//}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;

public class Main extends JFrame {
    private JButton entrarButton;
    private JPanel panel;
    private JButton cadastrarButton;

    public Main() {
        setContentPane(panel);
        setTitle("ArtDoc");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
                Main.this.dispose();
            }
        });

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Cadastrar();
                Main.this.dispose();
            }
        });
    }
    public static void main(String[] args) {

        new Main();

        Scanner scanner = new Scanner(System.in);

        try {
            // Criando um autor, comprador, e critico
            Autor autor = new Autor("autor01", "senha123", "Pablo Picasso", "Masculino");
            Comprador comprador = new Comprador("comprador01", "senha123", "Vincent van Gogh", "Masculino", 1500.0);
            Critico critico = new Critico("critico01", "senha123", "Leonardo da Vinci", "Masculino", 12345);

            // Adicionando novas artes ao autor
            System.out.println("Adicionando novas obras para o autor...");
            Arte livro = autor.adicionarNovaArte("livro", "Dom Quixote", 1605, 300.0, "Romance", null);
            Arte musica = autor.adicionarNovaArte("musica", "Bohemian Rhapsody", 1975, 150.0, "Rock", "mp3");
            Arte pintura = autor.adicionarNovaArte("pintura", "Guernica", 1937, 1000.0, "Cubismo", null);

            // Listando as obras do autor
            System.out.println("\n--- Obras do Autor ---");
            autor.listarMinhasArtes();

        SwingUtilities.invokeLater( () -> {
            InterfaceGrafica frame = new InterfaceGrafica();
            frame.setVisible(true);
        });

        Livro livro1 = new Livro("Harry Potter", "JK", "mlk q quase morreu", 1997, "Ficção", 300, "Sinopse A", 39.90);
        Livro livro2 = new Livro("IT", "Stephen King", "molecada ferrada com um et", 2014, "Terror", 250, "Sinopse B", 29.90);

        livro1.listarObras();

        Critico c = new Critico("Jorge", "30/09", "M" , "123", "Confia");

        c.avaliarArte(5, livro1);
        c.avaliarArte(0, livro1);
        System.out.println(livro1.mediaNota());

        try {
            Musica musica1 = new Musica("Risk", "Deftones", "Musica Top", 2006, "NuMetal", 3, 40, "mp4");
        }
        catch (ExtensaoException e) {
            System.out.println(e.getMessage());
        }

    }
}
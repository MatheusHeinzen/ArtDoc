
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

            // Comprador adiciona saldo e tenta comprar uma arte
            System.out.println("\n--- Comprador ---");
            System.out.println(comprador.adicionarSaldo(500.0));
            System.out.println("Saldo atual do comprador: R$ " + comprador.getSaldo());
            System.out.println(comprador.comprarArte(livro)); // Compra com sucesso
            System.out.println(comprador.comprarArte(pintura)); // Falta de saldo

            // Comprador adiciona a pintura na lista de desejos e vê a lista
            comprador.adicionarNaMinhaListaDeDesejos(pintura);
            System.out.println("\n--- Lista de Desejos do Comprador ---");
            comprador.verMinhaListaDeDesejos();

            // Critico avalia a arte e o autor
            System.out.println("\n--- Crítico Avaliando Arte e Autor ---");
            System.out.print("Digite uma nota para a arte (Guernica): ");
            int notaArte = scanner.nextInt();
            System.out.println(critico.avaliarArte(notaArte, pintura));

            System.out.print("Digite uma nota para o autor (Pablo Picasso): ");
            int notaAutor = scanner.nextInt();
            System.out.println(critico.avaliarAutor(notaAutor, autor));

            // Crítico ouve uma música e adiciona à sua playlist
            System.out.println("\n--- Crítico Ouve Música ---");
            System.out.println(critico.ouvirMusica((Musica) musica));
            System.out.println(critico.adicionarNaPlaylist((Musica) musica));
            System.out.println("\n--- Playlist do Crítico ---");
            System.out.println(critico.visualizarPlaylist());

            // Calculando médias de notas do autor e das suas obras
            System.out.println("\n--- Médias de Notas ---");
            System.out.println("Média das notas do autor: " + autor.calcularMediaMinhasNotas());
            System.out.println("Média das notas das obras do autor: " + autor.calcularMediaNotasMinhasArtes());

        } catch (ExtensaoException e) {
            System.out.println("Erro: Extensão de música inválida.");
        } catch (NotaNegativaException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
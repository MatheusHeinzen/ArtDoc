import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class MainInterface extends JFrame {
    private JButton entrarButton;
    private JPanel panel;

    public MainInterface() {
        setContentPane(panel);
        setTitle("ArtDoc");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        // Configuração dos botões
        entrarButton.addActionListener(e -> {
            new Login();
            MainInterface.this.dispose();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainInterface::new);
        executarOperacoes();
    }

    private static void executarOperacoes() {
        Scanner scanner = new Scanner(System.in);

        try {
            // Inicializando autor, comprador e crítico
            Autor autor = criarAutor();
            Comprador comprador = criarComprador();
            Critico critico = criarCritico();

            // Criação e listagem das artes
            criarEListarObras(autor);

            // Exibindo operações de compra e avaliação
            realizarCompra(comprador, autor);
            realizarAvaliacao(critico, autor, scanner);

            // Exibindo playlist do crítico
            gerenciarPlaylistCritico(critico, (Musica) autor.getMinhasArtes().get(1));

            // Exibindo médias de notas
            exibirMediasNotas(autor);

        } catch (ExtensaoException e) {
            JOptionPane.showMessageDialog(null, "Erro: Extensão de música inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static Autor criarAutor() {
        return new Autor("autor01", "senha123", "Pablo Picasso", "Masculino");
    }

    private static Comprador criarComprador() {
        return new Comprador("comprador01", "senha123", "Vincent van Gogh", "Masculino", 1500.0);
    }

    private static Critico criarCritico() {
        return new Critico("critico01", "senha123", "Leonardo da Vinci", "Masculino", 12345);
    }

    private static void criarEListarObras(Autor autor) throws ExtensaoException {
        System.out.println("\n--- Adicionando e Listando Obras ---");
        Arte livro = autor.adicionarNovaArte("livro", "Dom Quixote", 1605, 300.0, "Romance", null);
        Arte musica = autor.adicionarNovaArte("musica", "Bohemian Rhapsody", 1975, 150.0, "Rock", "mp3");
        Arte pintura = autor.adicionarNovaArte("pintura", "Guernica", 1937, 1000.0, "Cubismo", null);

        autor.listarMinhasArtes();
    }

    private static void realizarCompra(Comprador comprador, Autor autor) {
        System.out.println("\n--- Operações de Compra ---");
        System.out.println(comprador.adicionarSaldo(500.0));
        System.out.println("Saldo atual do comprador: R$ " + comprador.getSaldo());

        for (Arte arte : autor.getMinhasArtes()) {
            System.out.println(comprador.comprarArte(arte));
        }

        Arte pintura = autor.getMinhasArtes().get(2);  // Exemplo de pintura
        comprador.adicionarNaMinhaListaDeDesejos(pintura);
        System.out.println("\n--- Lista de Desejos do Comprador ---");
        comprador.verMinhaListaDeDesejos();
    }

    private static void realizarAvaliacao(Critico critico, Autor autor, Scanner scanner) throws NotaNegativaException {
        Arte pintura = autor.getMinhasArtes().get(2);  // Exemplo de pintura

        System.out.println("\n--- Crítico Avaliando Arte e Autor ---");
        System.out.print("Digite uma nota para a arte (Guernica): ");
        int notaArte = scanner.nextInt();
        System.out.println(critico.avaliarArte(notaArte, pintura));

        System.out.print("Digite uma nota para o autor (Pablo Picasso): ");
        int notaAutor = scanner.nextInt();
//        System.out.println(critico.avaliarAutor(notaAutor, autor));
    }

    private static void gerenciarPlaylistCritico(Critico critico, Musica musica) {
        System.out.println("\n--- Crítico Ouve Música e Adiciona na Playlist ---");
        System.out.println(critico.ouvirMusica(musica));
        System.out.println(critico.adicionarNaPlaylist(musica));

        System.out.println("\n--- Playlist do Crítico ---");
//        critico.visualizarPlaylist().forEach(System.out::println);
    }

    private static void exibirMediasNotas(Autor autor) {
        System.out.println("\n--- Médias de Notas ---");
        System.out.println("Média das notas do autor: " + autor.calcularMediaMinhasNotas());
        System.out.println("Média das notas das obras do autor: " + autor.calcularMediaNotasMinhasArtes());
    }
}
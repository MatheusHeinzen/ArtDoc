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

        } catch (ExtensaoException e) {
            JOptionPane.showMessageDialog(null, "Erro: Extensão de música inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static Autor criarAutor() {
        return new Autor("autor01", "Pablo Picasso", "Pablo Picasso", "Masculino");
    }

    private static Comprador criarComprador() {
        return new Comprador("comprador01", "Vincent van Gogh", "Vincent van Gogh", "Masculino", 1500.0);
    }

    private static Critico criarCritico() {
        return new Critico("critico01", "Leonardo da Vinc", "Leonardo da Vinci", "Masculino", 12345);
    }

    private static void criarEListarObras(Autor autor) throws ExtensaoException {
        System.out.println("\n--- Adicionando e Listando Obras ---");
        Arte livro = autor.adicionarNovaArte("livro", "Dom Quixote", 1605, 300.0, "Romance", null);
        Arte musica = autor.adicionarNovaArte("musica", "Bohemian Rhapsody", 1975, 150.0, "Rock", "mp3");
        Arte pintura = autor.adicionarNovaArte("pintura", "Guernica", 1937, 1000.0, "Cubismo", null);

        autor.listarMinhasArtes();
    }
}
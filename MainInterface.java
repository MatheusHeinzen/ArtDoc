import javax.swing.*;
import java.util.ArrayList;

public class MainInterface extends JFrame {
    private JButton entrarButton;
    private JPanel panel;
    private static ArrayList<Pessoa> listaPessoas;

    public MainInterface() {
        setContentPane(panel);
        setTitle("ArtDoc");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        // Configuração do botão entrar
        entrarButton.addActionListener(e -> {
            new Login();  // Abre a janela de login
            MainInterface.this.dispose();  // Fecha a janela principal
        });
    }

    public static void main(String[] args) {
        // Carregar dados de pessoas do arquivo CSV uma única vez
        listaPessoas = carregarDadosDoCSV();
        System.out.println("Pessoas carregadas: " + listaPessoas.size());
        for (Pessoa pessoa : listaPessoas) {
            System.out.println("Tipo: " + (pessoa instanceof Autor ? "Autor" : pessoa instanceof Critico ? "Critico" : "Comprador"));
            System.out.println("Nome: " + pessoa.getUsuario());
            System.out.println("Senha: " + pessoa.getSenha());
        }
        SwingUtilities.invokeLater(MainInterface::new);
    }

    private static ArrayList<Pessoa> carregarDadosDoCSV() {
        FileManager fileManager = new FileManager("./database/pessoas.csv");
        return fileManager.lerArquivoPessoa();
    }

    public static Pessoa autenticarUsuario(String usuario, String senha) {
        for (Pessoa pessoa : listaPessoas) {
            if (pessoa.getUsuario().equals(usuario) && pessoa.getSenha().equals(senha)) {
                return pessoa; // Retorna a pessoa autenticada
            }
        }
        return null; // Retorna null se o usuário não for encontrado
    }

    public static void criarEListarObras(Autor autor) throws ExtensaoException {
        System.out.println("\n--- Adicionando e Listando Obras ---");
        Arte livro = autor.adicionarNovaArte("livro", "Dom Quixote", 1605, 300.0, "Romance", null);
        Arte musica = autor.adicionarNovaArte("musica", "Bohemian Rhapsody", 1975, 150.0, "Rock", "mp3");
        Arte pintura = autor.adicionarNovaArte("pintura", "Guernica", 1937, 1000.0, "Cubismo", null);
        autor.listarMinhasArtes();
    }
}

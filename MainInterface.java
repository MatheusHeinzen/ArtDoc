import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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

    public static Autor criarAutor() {
        return new Autor("autor01", "Pablo Picasso", "Pablo Picasso", "Masculino");
    }

    public static Comprador criarComprador() {
        return new Comprador("comprador01", "Vincent van Gogh", "Vincent van Gogh", "Masculino", 1500.0);
    }

    public static Critico criarCritico() {
        return new Critico("critico01", "Leonardo da Vinc", "Leonardo da Vinci", "Masculino", 12345);
    }

    public static void criarEListarObras(Autor autor) throws ExtensaoException {
        System.out.println("\n--- Adicionando e Listando Obras ---");
        Arte livro = autor.adicionarNovaArte("livro", "Dom Quixote", 1605, 300.0, "Romance", null);
        Arte musica = autor.adicionarNovaArte("musica", "Bohemian Rhapsody", 1975, 150.0, "Rock", "mp3");
        Arte pintura = autor.adicionarNovaArte("pintura", "Guernica", 1937, 1000.0, "Cubismo", null);

        autor.listarMinhasArtes();
    }



    public class Main {
        public static Pessoa usuarioLogado;

        private static ArrayList<Autor> listaAutores;
        private static ArrayList<Arte> listaArtes;

        public static List<Pessoa> listaPessoas = new ArrayList<>();



        public static void main(String[] args) {
            // Carrega os dados do arquivo
            FileManager fileManagerPessoas = new FileManager("./database/pessoas.csv");
            FileManager fileManagerArtes = new FileManager("./database/artes.csv");
            fileManagerPessoas.lerArquivoPessoa();

            // Inicializa a lista de autores a partir das pessoas carregadas
            listaAutores = new ArrayList<>();
            for (Pessoa pessoa : listaPessoas) {
                if (pessoa instanceof Autor) {
                    listaAutores.add((Autor) pessoa);
                }
            }

            fileManagerArtes.lerArquivoArte(listaAutores);

            // Inicia a interface gráfica
            SwingUtilities.invokeLater(() -> new MainInterface());

            // Salva os dados ao fechar a aplicação
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                fileManagerPessoas.salvarArquivoPessoa((ArrayList<Pessoa>) listaPessoas);
                fileManagerArtes.salvarArquivoArte(listaArtes);
                System.out.println("Dados salvos ao encerrar.");
            }));
        }

        public static void setUsuarioLogado(Pessoa usuario) {
            usuarioLogado = usuario;
        }
        public static Pessoa getUsuarioLogado() {
            return usuarioLogado;
        }

        public static boolean autenticarUsuario(String usuario, String senha) {
            for (Pessoa pessoa : listaPessoas) {
                if (pessoa.getNomeUsuario().equals(usuario) && pessoa.getSenha().equals(senha)) {
                    usuarioLogado = pessoa;
                    return true;
                }
            }
            return false;
        }
    }
}
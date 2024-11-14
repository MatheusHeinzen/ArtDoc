import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JPanel panel2;
    private JButton loginButton;
    private JTextField usuarioLogin;
    private JPasswordField senhaLogin;
    private JButton voltarButton;

    public Login() {
        setContentPane(panel2);
        setTitle("ArtDoc");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        loginButton.addActionListener(e -> {
            String usuario = usuarioLogin.getText();
            String senha = new String(senhaLogin.getPassword());

            Pessoa pessoaAutenticada = MainInterface.autenticarUsuario(usuario, senha);
            if (pessoaAutenticada != null) {
                JOptionPane.showMessageDialog(this, "Login realizado com sucesso!", "Bem-vindo", JOptionPane.INFORMATION_MESSAGE);
                Main.setUsuarioLogado(pessoaAutenticada);

                // Redirecionamento com base no tipo de pessoa
                if (pessoaAutenticada instanceof Autor) {
                    Autor autor = (Autor) pessoaAutenticada;
                    try {
                        MainInterface.criarEListarObras(autor);
                    } catch (ExtensaoException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao criar arte: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    Autor autor = new Autor("Marina", "123", "Marina", "F");
                    Arte livro = new Livro("Dom Quixote", autor, 1605, 300.0, "Romance");
                    try {
                        Arte musica = new Musica("Bohemian Rhapsody",autor,1975, 150.0, "Rock", "mp3");
                    } catch (ExtensaoException ex) {
                        throw new RuntimeException(ex);
                    }
                    Arte pintura = new Pintura("Guernica", autor,  1937, 1000.0, "Cubismo");
                }
                new Menu();
                dispose(); // Fecha a janela de login
            } else {
                JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        voltarButton.addActionListener(e -> {
            new MainInterface(); // Volta para a tela principal
            dispose();
        });
    }
}

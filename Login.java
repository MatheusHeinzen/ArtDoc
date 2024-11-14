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

            // Chama o método de autenticação centralizado em MainInterface
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

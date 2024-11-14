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

            if (Main.autenticarUsuario(usuario, senha)) {
                Main.setUsuarioLogado(Main.getUsuarioLogado());
                new Menu();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos!");
            }
        });

        voltarButton.addActionListener(e -> {
            new Main();
            dispose();
        });
    }
}

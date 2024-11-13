import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JPanel panel2;
    private JButton loginButton;
    private JTextField usuarioLogin;
    private JPasswordField senhaLogin;
    private JButton voltarButton;

    public Login(){
        setContentPane(panel2);
        setTitle("ArtDoc");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu();
                Login.this.dispose();
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main();
                Login.this.dispose();
            }
        });
    }
}

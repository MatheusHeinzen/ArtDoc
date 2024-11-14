import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
<<<<<<< Updated upstream

    private JPanel panel2;
    private JButton loginButton;
=======
>>>>>>> Stashed changes
    private JTextField usuarioLogin;
    private JPasswordField senhaLogin;
    private JButton loginButton;
    private JButton voltarButton;
    private JPanel panel2;

    public Login(){
        setContentPane(panel2);
        setTitle("Login - ArtDoc");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
<<<<<<< Updated upstream
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu();
                Login.this.dispose();
=======

        // Configuração do botão login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioLogin.getText();
                String senha = new String(senhaLogin.getPassword());

                Pessoa pessoaAutenticada = MainInterface.autenticarUsuario(usuario, senha);

                if (pessoaAutenticada != null) {
                    JOptionPane.showMessageDialog(Login.this, "Login realizado com sucesso!", "Bem-vindo", JOptionPane.INFORMATION_MESSAGE);
                    Main.setUsuarioLogado(pessoaAutenticada);

                    // Exemplo de redirecionamento com base no tipo de pessoa
                    if (pessoaAutenticada instanceof Autor) {
                        Autor autor = (Autor) pessoaAutenticada;
                        try {
                            MainInterface.criarEListarObras(autor);
                        } catch (ExtensaoException ex) {
                            JOptionPane.showMessageDialog(null, "Erro ao criar arte: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                    dispose(); // Fecha a janela de login
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Usuário ou senha inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
>>>>>>> Stashed changes
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
<<<<<<< Updated upstream
                new Main();
=======
                new MainInterface();
>>>>>>> Stashed changes
                Login.this.dispose();
            }
        });
    }
}

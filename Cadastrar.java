import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cadastrar extends JFrame{


    private JPanel panel4;
    private JTextField criarUsuario;
    private JTextField criarNome;
    private JPasswordField criarSenha;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton cadastrarButton;

    public Cadastrar(){
        setContentPane(panel4);
        setTitle("ArtDoc");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu();
                Cadastrar.this.dispose();
            }
        });
    }
}

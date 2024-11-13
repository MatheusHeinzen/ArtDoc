import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    private JPanel panel3;
    private JButton musicasButton;
    private JButton livrosButton;
    private JButton pinturasButton;
    private JButton minhasObrasButton;
    private JList list1;
    private JButton coringa;


    public Menu(){
        setContentPane(panel3);
        setTitle("ArtDoc");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        musicasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Musicas();
                Menu.this.dispose();
            }
        });

        livrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VisualizarUmaArte(new Livro("IT - A Coisa", "Stephen King", "molecada ferrada com um et", 2014, "Terror", 250, "Sinopse B", 29.90));
            }
        });

        pinturasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Pinturas();
                Menu.this.dispose();
            }
        });
    }

}
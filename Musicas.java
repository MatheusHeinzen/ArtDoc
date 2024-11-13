import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Musicas extends JFrame{
    private JPanel panel8;
    private JButton livrosButton;
    private JButton pinturasButton;
    private JButton minhasObrasButton;
    private JButton musicasButton;
    private JButton coringa;
    private JList list1;

    public Musicas() {
        setContentPane(panel8);
        setTitle("ArtDoc");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        musicasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Musicas();
                Musicas.this.dispose();
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
                Musicas.this.dispose();
            }
        });
    }
}

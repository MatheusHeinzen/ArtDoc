import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pinturas extends JFrame{
    private JPanel panel7;
    private JButton livrosButton;
    private JButton pinturasButton;
    private JButton minhasObrasButton;
    private JButton musicasButton;
    private JButton coringa;
    private JList list1;

    public Pinturas() {
        setContentPane(panel7);
        setTitle("ArtDoc");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        musicasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Musicas();
                Pinturas.this.dispose();
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
                Pinturas.this.dispose();
            }
        });
    }}

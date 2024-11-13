import javax.swing.*;

public class Livros extends JFrame {
    private JPanel panel6;
    private JButton livrosButton;
    private JButton pinturasButton;
    private JButton minhasObrasButton;
    private JButton musicasButton;
    private JButton coringa;
    private JList list1;

    public Livros() {
        setContentPane(panel6);
        setTitle("ArtDoc");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

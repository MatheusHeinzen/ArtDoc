import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{

    private JButton entrarButton;
    private JPanel panel;
    private JButton cadastrarButton;

    public Main(){
        setContentPane(panel);
        setTitle("ArtDoc");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
                Main.this.dispose();
            }
        });

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Cadastrar();
                Main.this.dispose();
            }
        });


    }

    public static void main(String[] args) {
//        SwingUtilities.invokeLater( () -> {
//            InterfaceGrafica frame = new InterfaceGrafica();
//            frame.setVisible(true);
//        });
//
//        Livro livro1 = new Livro("Harry Potter", "JK", "mlk q quase morreu", 1997, "Ficção", 300, "Sinopse A", 39.90);
//        Livro livro2 = new Livro("IT", "Stephen King", "molecada ferrada com um et", 2014, "Terror", 250, "Sinopse B", 29.90);
//
//        livro1.listarObras();
//
//        Critico c = new Critico("Jorge", "30/09" , "123");
//
//        c.avaliarArte(5, livro1);
//        c.avaliarArte(0, livro1);
//        System.out.println(livro1.mediaNota());
//
//        try {
//            Musica musica1 = new Musica("Risk", "Deftones", "Musica Top", 2006, "NuMetal", 3, 40, "mp4");
//        }
//        catch (ExtensaoException e) {
//            System.out.println(e.getMessage());
//        }
        new Main();

    }
}
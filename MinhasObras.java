import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinhasObras extends JFrame{
    private JPanel panel8;
    private JButton livrosButton;
    private JButton pinturasButton;
    private JButton minhasObrasButton;
    private JButton musicasButton;
    private JButton coringa;
    private JList list1;

    public MinhasObras() {
        setContentPane(panel8);
        setTitle("ArtDoc");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        musicasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Musicas();
                MinhasObras.this.dispose();
            }
        });

        livrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Pinturas();
                MinhasObras.this.dispose();
            }
        });

        pinturasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Pinturas();
                MinhasObras.this.dispose();
            }
        });

        Pessoa usuarioLogado = Main.getUsuarioLogado();

        if (usuarioLogado instanceof Comprador) {
            coringa.setText("Saldo do Comprador");
            coringa.addActionListener(e -> {
                JOptionPane.showMessageDialog(this, "Saldo disponível: " + ((Comprador) usuarioLogado).getSaldo());
            });
        } else if (usuarioLogado instanceof Autor) {
            coringa.setText("Colocar Livro");
            coringa.addActionListener(e -> {
                new Cadastrar();
            });
        } else if (usuarioLogado instanceof Critico) {
            coringa.setText("Avaliar um Autor");
            coringa.addActionListener(e -> {
                JOptionPane.showMessageDialog(this, "Função para avaliar um autor será aqui.");
            });
        }
    }
}

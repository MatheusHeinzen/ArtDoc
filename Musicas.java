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
    private JList listArtes;

    public Musicas() {
        setContentPane(panel8);
        setTitle("ArtDoc");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        DefaultListModel<Arte> model = new DefaultListModel<>();
        model.addAll(Musica.getColetanea());
        listArtes.setModel(model);

        listArtes.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Arte arteSelecionada = (Arte) listArtes.getSelectedValue();
                if (arteSelecionada != null) {
                    new VisualizarUmaArte(arteSelecionada);
                }
            }
        });

        musicasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Musicas();
                Musicas.this.dispose();
            }
        });

        livrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new Livros();
                Musicas.this.dispose();
            }
        });

        pinturasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Pinturas();
                Musicas.this.dispose();
            }
        });

        minhasObrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MinhasObras();
                Musicas.this.dispose();
            }
        });

        Pessoa usuarioLogado = Main.getUsuarioLogado();

        if (usuarioLogado instanceof Comprador) {
            coringa.setText("Saldo do Comprador");
            coringa.addActionListener(e -> {
                JOptionPane.showMessageDialog(this, "Saldo disponível: " + ((Comprador) usuarioLogado).getSaldo());
            });
        } else if (usuarioLogado instanceof Autor) {
            coringa.setText("Avaliações do Autor");
            coringa.addActionListener(e -> {
                JOptionPane.showMessageDialog(this, "Sua média de avaliações é: " + ((Autor) usuarioLogado).getMediaMinhasNotas());
            });
        } else if (usuarioLogado instanceof Critico) {
            coringa.setText("Avaliar um Autor");
            coringa.addActionListener(e -> {
                JOptionPane.showMessageDialog(this, "Função para avaliar um autor será aqui.");
            });
        }
    }
}

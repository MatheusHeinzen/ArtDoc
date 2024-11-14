import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JPanel panel3;
    private JButton musicasButton;
    private JButton livrosButton;
    private JButton pinturasButton;
    private JButton minhasObrasButton;
    private JButton coringa;
    private JList<Arte> listArtes;

    public Menu() {
        setContentPane(panel3);
        setTitle("ArtDoc");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        // Configuração da lista de artes com todas as obras
        DefaultListModel<Arte> model = new DefaultListModel<>();
        model.addAll(Livro.getBiblioteca());
        model.addAll(Musica.getColetanea());
        model.addAll(Pintura.getColecao());
        listArtes.setModel(model);

        listArtes.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                Arte arteSelecionada = listArtes.getSelectedValue();
                if (arteSelecionada != null) {
                    new VisualizarUmaArte(arteSelecionada);
                }
            }
        });

        musicasButton.addActionListener(e -> new Musicas());
        livrosButton.addActionListener(e -> new Livros());
        pinturasButton.addActionListener(e -> new Pinturas());
        minhasObrasButton.addActionListener(e -> new MinhasObras());

        // Configuração do botão coringa baseado no tipo de usuário logado
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
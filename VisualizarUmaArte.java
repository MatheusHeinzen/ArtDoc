import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualizarUmaArte extends JFrame {

    private JPanel panel5;
    private JTextArea nomeDaArte;
    private JButton avaliarButton;
    private JButton comprarButton;
    private JTextArea nomeDoAutor;
    private JTextArea anoLancamento;
    private JLabel imagem;
    private Arte arte;

    public VisualizarUmaArte(Arte arte) {
        this.arte = arte;
        setContentPane(panel5);
        setTitle("ArtDoc");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        mostrarNome();
        mostrarAno();
        mostrarAutor();

        // Adiciona a ação ao botão avaliar
        avaliarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirDialogoAvaliacao();
            }
        });
    }

    public void mostrarNome() {
        nomeDaArte.setText(arte.getNomeArte());
    }

    public void mostrarAno() {
        anoLancamento.setText(String.valueOf(arte.getAnoPublicacao()));
    }

    public void mostrarAutor() {
        nomeDoAutor.setText(arte.getAutor().getNomePessoa());
    }

    private void abrirDialogoAvaliacao() {
        AvaliacaoDialog dialog = new AvaliacaoDialog(this, arte);
        dialog.setVisible(true);
    }

    private static class AvaliacaoDialog extends JDialog {
        private JComboBox<Integer> avaliacaoCombo;
        private JButton confirmarButton;

        public AvaliacaoDialog(JFrame parent, Arte arte) {
            super(parent, "Avaliar Arte", true);
            Pessoa usuarioLogado = Main.getUsuarioLogado();
            if (usuarioLogado instanceof Critico) {
                setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
                setSize(200, 150);
                setLocationRelativeTo(parent);


                add(new JLabel("Escolha uma nota de 1 a 5:"));

                // Combobox para escolher a avaliação de 1 a 5
                avaliacaoCombo = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
                add(avaliacaoCombo);

                confirmarButton = new JButton("Confirmar");
                confirmarButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int avaliacao = (int) avaliacaoCombo.getSelectedItem();
                        arte.adicionarNotaArte(avaliacao);

                        dispose();
                    }
                });
                add(confirmarButton);
            }else {
                JOptionPane.showMessageDialog(parent, "Você não é um crítico.");
            }
        }
    }
}
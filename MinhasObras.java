import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MinhasObras extends JFrame {
    private JPanel panel8;
    private JButton livrosButton;
    private JButton pinturasButton;
    private JButton minhasObrasButton;
    private JButton musicasButton;
    private JButton coringa;
    private JList<Arte> listArtes;

    public MinhasObras() {
        setContentPane(panel8);
        setTitle("ArtDoc");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        // Carregar a lista de obras com base no tipo de usuário
        carregarObras();

        musicasButton.addActionListener(e -> {
            new Musicas();
            dispose();
        });

        livrosButton.addActionListener(e -> {
            new Livros();
            dispose();
        });

        pinturasButton.addActionListener(e -> {
            new Pinturas();
            dispose();
        });

        // Configuração do botão coringa baseado no tipo de usuário logado
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
                dispose();
            });
        } else if (usuarioLogado instanceof Critico) {
            coringa.setText("Avaliar um Autor");
            coringa.addActionListener(e -> {
                JOptionPane.showMessageDialog(this, "Função para avaliar um autor será aqui.");
            });
        }
    }

    private void carregarObras() {
        Pessoa usuarioLogado = Main.getUsuarioLogado();
        DefaultListModel<Arte> model = new DefaultListModel<>();

        if (usuarioLogado instanceof Autor) {
            // Exibir apenas as obras criadas pelo autor
            List<Arte> obrasDoAutor = ((Autor) usuarioLogado).getMinhasArtes();
            obrasDoAutor.forEach(model::addElement);
        } else if (usuarioLogado instanceof Comprador) {
            // Exibir apenas as obras compradas pelo comprador
            List<Arte> obrasCompradas = ((Comprador) usuarioLogado).getMinhasArtesCompradas();
            obrasCompradas.forEach(model::addElement);
        } else if (usuarioLogado instanceof Critico) {
            // Exibir apenas as obras avaliadas pelo crítico
            List<Arte> obrasAvaliadas = ((Critico) usuarioLogado).getArtesAvaliadas();
            obrasAvaliadas.forEach(model::addElement);
        }

        listArtes.setModel(model);
    }
}
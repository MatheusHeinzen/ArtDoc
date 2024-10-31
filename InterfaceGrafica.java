import javax.swing.*;
import java.awt.*;

public class InterfaceGrafica extends JFrame {
    //Telas
    private JPanel telaInicial;
    private JPanel telaCadastro;
    private JPanel telaLogin;

    //Construtor
    public InterfaceGrafica() {
        setTitle("ArtDoc");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        telaInicial = criarTelaInicial();
        telaCadastro = criarTelaCadastro();
        telaLogin = criarTelaLogin();

        add(telaInicial);
    }

    //Tela Inicial
    private JPanel criarTelaInicial() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel mensagem = new JLabel("Bem-vindo! Você já possui cadastro?");
        mensagem.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(mensagem);

        //Botões
        JPanel botoesPanel = new JPanel();
        JButton botaoSim = new JButton("Sim");
        JButton botaoNao = new JButton("Não");

        botaoSim.addActionListener(e -> {
            remove(telaInicial);
            add(telaLogin);
            revalidate();
            repaint();
        });

        botaoNao.addActionListener(e -> {
            remove(telaInicial);
            add(telaCadastro);
            revalidate();
            repaint();
        });

        botoesPanel.add(botaoSim);
        botoesPanel.add(botaoNao);

        panel.add(Box.createVerticalStrut(20));
        panel.add(botoesPanel);

        return panel;
    }

    // Tela de Cadastro
    private JPanel criarTelaCadastro() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //Campos
        JLabel labelNome = new JLabel("Nome:");
        JTextField campoNome = new JTextField(15);
        JLabel labelDataNasc = new JLabel("Data de Nascimento:");
        JTextField campoDataNasc = new JTextField(10);
        JLabel labelGenero = new JLabel("Gênero:");
        JTextField campoGenero = new JTextField(10);
        JLabel labelSenha = new JLabel("Senha:");
        JPasswordField campoSenha = new JPasswordField(15);
        JLabel labelTipo = new JLabel("Tipo:");

        //DropList
        String[] tipos = {"Autor", "Crítico", "Comprador"};
        JComboBox<String> tipoDropDown = new JComboBox<>(tipos);

        JButton botaoCadastrar = new JButton("Cadastrar");

        panel.add(labelNome);
        panel.add(campoNome);
        panel.add(labelDataNasc);
        panel.add(campoDataNasc);
        panel.add(labelGenero);
        panel.add(campoGenero);
        panel.add(labelSenha);
        panel.add(campoSenha);
        panel.add(labelTipo);
        panel.add(tipoDropDown);
        panel.add(Box.createVerticalStrut(20));
        panel.add(botaoCadastrar);

        for (Component comp : panel.getComponents()) {
            ((JComponent) comp).setAlignmentX(Component.CENTER_ALIGNMENT);
        }

        return panel;
    }

    //Tela de Login
    private JPanel criarTelaLogin() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel labelNome = new JLabel("Nome:");
        JTextField campoNome = new JTextField(15);
        JLabel labelSenha = new JLabel("Senha:");
        JPasswordField campoSenha = new JPasswordField(15);

        JButton botaoLogin = new JButton("Entrar");

        panel.add(labelNome);
        panel.add(campoNome);
        panel.add(labelSenha);
        panel.add(campoSenha);
        panel.add(Box.createVerticalStrut(20));
        panel.add(botaoLogin);


        for (Component comp : panel.getComponents()) {
            ((JComponent) comp).setAlignmentX(Component.CENTER_ALIGNMENT);
        }

        return panel;
    }
}

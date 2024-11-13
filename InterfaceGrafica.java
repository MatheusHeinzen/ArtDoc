import javax.swing.*;
import java.awt.*;

public class InterfaceGrafica extends JFrame {
    // Telas
    private JPanel telaLogo;
    private JPanel telaInicial;
    private JPanel telaCadastro;
    private JPanel telaLogin;
    private JPanel telaMenu;
    private JPanel telaAdicionarFundos;
    public Pessoa novoUsuario;

    // Construtor
    public InterfaceGrafica() {
        setTitle("ArtDoc");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        telaLogo = criarTelaLogo();
        telaInicial = criarTelaInicial();
        telaCadastro = criarTelaCadastro();
        telaLogin = criarTelaLogin();
        telaMenu = criarTelaMenu();
        telaAdicionarFundos = criarTelaAdicionarFundos();

        add(telaLogo);
    }

    private JPanel criarTelaLogo() {
        JPanel panel = new JPanel();
        JPanel panelLogo = new JPanel();
        JPanel panelBotao = new JPanel();

        panelLogo.setLayout(new BoxLayout(panelLogo, BoxLayout.Y_AXIS));
        Icon logo = new ImageIcon("ARTDOC.png");
        JLabel labelLogo = new JLabel("", logo, SwingConstants.CENTER);
        panelLogo.add(labelLogo);

        JButton botaoContinuar = new JButton("Entrar");
        botaoContinuar.addActionListener(e -> {
            remove(telaLogo);
            add(telaInicial);
            revalidate();
            repaint();
        });

        panelBotao.add(botaoContinuar);

        panel.add(panelLogo);
        panel.add(panelBotao);

        FlowLayout layout = new FlowLayout();
        panel.setLayout(layout);

        return panel;
    }

    // Tela Inicial
    private JPanel criarTelaInicial() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel mensagem = new JLabel("Bem-vindo! Você já possui cadastro?");
        mensagem.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(mensagem);

        // Botões
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

        // Campos
        JLabel labelNome = new JLabel("Nome:");
        JTextField campoNome = new JTextField(15);
        JLabel labelDataNasc = new JLabel("Data de Nascimento:");
        JTextField campoDataNasc = new JTextField(10);
        JLabel labelSenha = new JLabel("Senha:");
        JPasswordField campoSenha = new JPasswordField(15);
        JLabel labelTipo = new JLabel("Tipo:");

        // DropList
        String[] tipos = {"Autor", "Crítico", "Comprador"};
        JComboBox<String> tipoDropDown = new JComboBox<>(tipos);

        JButton botaoCadastrar = new JButton("Cadastrar");

        botaoCadastrar.addActionListener(e -> {
            if (tipoDropDown.getSelectedItem().equals("Autor")) {
                novoUsuario = new Autor(campoNome.getText(), campoDataNasc.getText(), new String(campoSenha.getPassword()));
                remove(telaCadastro);
                add(telaMenu);
            } else if (tipoDropDown.getSelectedItem().equals("Crítico")) {
                novoUsuario = new Critico(campoNome.getText(), campoDataNasc.getText(), new String(campoSenha.getPassword()));
                remove(telaCadastro);
                add(telaMenu);
            } else if (tipoDropDown.getSelectedItem().equals("Comprador")) {
                novoUsuario = new Comprador(campoNome.getText(), campoDataNasc.getText(), new String(campoSenha.getPassword()));
                remove(telaCadastro);
                add(telaAdicionarFundos);
            }
            revalidate();
            repaint();
        });

        panel.add(labelNome);
        panel.add(campoNome);
        panel.add(labelDataNasc);
        panel.add(campoDataNasc);
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

    // Tela de Login
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

    private JPanel criarTelaMenu() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel labelTeste = new JLabel(String.valueOf(novoUsuario.getCarteira()));

        return panel;
    }

    private JPanel criarTelaAdicionarFundos() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel labelCarteira = new JLabel("Quanto quer adicionar?");
        JTextField campoCarteira = new JTextField(15);
        JButton botaoConfirmar = new JButton("Confirmar");

        botaoConfirmar.addActionListener(e -> {
            try {
                int carteira = Integer.parseInt(campoCarteira.getText());
                if (novoUsuario != null) {
                    novoUsuario.setCarteira(carteira);
                } else {
                    System.out.println("Usuário não encontrado.");
                }
                remove(telaAdicionarFundos);
                add(telaMenu);
                revalidate();
                repaint();
            } catch (NumberFormatException ex) {
                System.out.println("Valor não é um número inteiro.");
            }
        });

        panel.add(labelCarteira);
        panel.add(campoCarteira);
        panel.add(Box.createVerticalStrut(20));
        panel.add(botaoConfirmar);

        for (Component comp : panel.getComponents()) {
            ((JComponent) comp).setAlignmentX(Component.CENTER_ALIGNMENT);
        }

        return panel;
    }
}

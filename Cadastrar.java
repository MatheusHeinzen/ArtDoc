import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cadastrar extends JFrame {
    private JPanel panel4;
    private JTextField nomeLivro;
    private JTextField anoPublicacao;
    private JTextField valor;
    private JTextField genero;
    private JButton cadastrarButton;

    public Cadastrar() {
        setContentPane(panel4);
        setTitle("ArtDoc");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Coletar dados dos campos de texto
                String nome = nomeLivro.getText().trim();
                String generoLivro = genero.getText().trim();
                int ano = 0;
                double valorLivro = 0.0;

                // Verificar se os campos obrigatórios foram preenchidos
                if (nome.isEmpty() || generoLivro.isEmpty() || anoPublicacao.getText().trim().isEmpty() || valor.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(Cadastrar.this, "Por favor, preencha todos os campos.");
                    return;
                }

                try {
                    // Tentar converter ano de publicação e valor para tipos numéricos
                    ano = Integer.parseInt(anoPublicacao.getText().trim());
                    valorLivro = Double.parseDouble(valor.getText().trim());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Cadastrar.this, "Ano e Valor devem ser numéricos.");
                    return;
                }


                // Adicionar o livro ao autor ou à lista de livros (substitua com sua lógica)
                Autor autorLogado = (Autor) Main.getUsuarioLogado(); // Substitua com a forma como você obtém o autor logado
                try {
                    autorLogado.adicionarNovaArte("livro", nome, ano, valorLivro, generoLivro, null);
                } catch (ExtensaoException ex) {
                    throw new RuntimeException(ex);
                }

                // Confirmar o cadastro para o usuário
                JOptionPane.showMessageDialog(Cadastrar.this, "Livro cadastrado com sucesso!");

                // Voltar ao menu e fechar a janela de cadastro
                new Menu();
                Cadastrar.this.dispose();
            }
        });
    }
}

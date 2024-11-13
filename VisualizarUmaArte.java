import javax.swing.*;

public class VisualizarUmaArte extends JFrame {

    private JPanel panel5;
    private JTextArea nomeDaArte;
    private JButton avaliarButton;
    private JButton comprarButton;
    private JTextArea nomeDoAutor;
    private JTextArea anoLancamento;
    private JLabel imagem;
    private Arte arte;


    public VisualizarUmaArte(Arte arte){
        this.arte = arte;
        setContentPane(panel5);
        setTitle("ArtDoc");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        mostrarNome();
        mostrarAno();
        mostrarAutor();
    }

    public void mostrarNome(){
        nomeDaArte.setText(arte.getNomeArte());
    }

    public void mostrarAno(){
        anoLancamento.setText(String.valueOf(arte.getAnoPublicacao()));
    }

    public void mostrarAutor(){
        nomeDoAutor.setText(arte.getAutor());
    }
}

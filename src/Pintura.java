package src;

public class Pintura extends Arte{
    private String traco;
    private String dimensao;
    private double valorVenda;

    public Pintura(String nome, String autor, String descricao, int anoPublicacao, String dimensao, double valorVenda) {
        super(nome, autor, descricao, anoPublicacao);
        this.traco = traco;
        this.dimensao = dimensao;
        this.valorVenda = valorVenda;
    }

    public void listarObras(){

    }
    public void visualizarArte(){

    }
}

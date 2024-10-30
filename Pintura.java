public class Pintura extends Arte {
    private String traco;
    private String dimensao;

    public Pintura(String nome, String autor, String descricao, int anoPublicacao, String dimensao, double valorArte) {
        super(nome, autor, descricao, anoPublicacao, valorArte);
        this.traco = traco;
        this.dimensao = dimensao;
    }

    public void listarObras(){

    }
    public void visualizarArte(){

    }
}

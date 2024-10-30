public class Pintura extends Arte {
    //Atributos
    private String traco;
    private String dimensao;

    //Construtor
    public Pintura(String nome, String autor, String descricao, int anoPublicacao, String dimensao, double valorArte) {
        super(nome, autor, descricao, anoPublicacao, valorArte);
        this.traco = traco;
        this.dimensao = dimensao;
    }

    //Métodos
    public void listarObras(){

    }
    public void visualizarArte(){

    }
}

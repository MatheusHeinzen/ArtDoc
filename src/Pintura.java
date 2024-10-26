package src;

public class Pintura extends Arte{
    private String traco;

    public Pintura(String nome, String autor, String descricao, int anoPublicacao, String traco) {
        super(nome, autor, descricao, anoPublicacao);
        this.traco = traco;
    }
}

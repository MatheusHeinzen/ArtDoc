package src;

public class Musica extends Arte {
    private String estilo;

    public Musica(String nome, String autor, String descricao, int anoPublicacao, String estilo) {
        super(nome, autor, descricao, anoPublicacao);
        this.estilo = estilo;
    }
}

package src;

public class Musica extends Arte {
    private String estilo;
    private double duracao;

    public Musica(String nome, String autor, String descricao, int anoPublicacao, String estilo, double duracao) {
        super(nome, autor, descricao, anoPublicacao);
        this.estilo = estilo;
        this.duracao = duracao;
    }


    public void listarObras(){

    }
    public void ouvirMusica(){

    }

}

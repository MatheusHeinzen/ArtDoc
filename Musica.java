public class Musica extends Arte {
    private String estilo;
    private double duracao;

    public Musica(String nome, String autor, String descricao, int anoPublicacao, String estilo, double duracao, double valorArte) {
        super(nome, autor, descricao, anoPublicacao, valorArte);
        this.estilo = estilo;
        this.duracao = duracao;
    }


    public void listarObras(){

    }
    public void ouvirMusica(){
        System.out.println("🎶🎵🎶🎵");
    }

}

import java.util.ArrayList;

public class Critico extends Pessoa{
    //Atributos
    private ArrayList<Arte> minhasAvaliacoes = new ArrayList<Arte>();

    //Construtor
    public Critico(String nomePessoa, String dataNascimento, String senha) {
        super(nomePessoa, dataNascimento, senha);
    }

    //Métodos
    public String avaliarArte(int avaliacao, Arte arte){
        arte.adicionarNota(avaliacao);
        return "Arte avaliada.";
    }
    public String avaliarAutor(int avaliacao, Autor autor){
        autor.adicionarNota(avaliacao);
        return "Autor avaliado.";
    }

    @Override
    public void ouvirMusica(Musica musica){
        System.out.println("🎶🎵🎶🎵");
        minhasAvaliacoes.add(musica);
    }

    @Override
    public void setCarteira(int carteira) {

    }

    @Override
    public int getCarteira() {
        return 0;
    }
}

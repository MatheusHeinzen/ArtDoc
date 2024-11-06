import java.util.ArrayList;

public class Critico extends Pessoa{
    //Atributos
    private String certificado;
    private ArrayList<Arte> minhasAvaliacoes = new ArrayList<Arte>();

    //Construtor
    public Critico(String nomePessoa, String dataNascimento, String genero, String senha, String certificado) {
        super(nomePessoa, dataNascimento, genero, senha);
        this.certificado = certificado;
    }

    //Métodos
    public String avaliarArte(int avaliacao, Arte arte)  throws NotaNegativaException {
        arte.adicionarNota(avaliacao);
        if (avaliacao < 0) {
            throw new NotaNegativaException("Não é possível atribuir uma nota negativa para um Autor/Arte.");
        }
        return "Arte avaliada.";

    }
    public String avaliarAutor(int avaliacao, Autor autor) throws NotaNegativaException{
        autor.adicionarNota(avaliacao);
        if (avaliacao < 0) {
            throw new NotaNegativaException("Não é possível atribuir uma nota negativa para um Autor/Arte.");
        }
        return "Autor avaliado.";
    }

    @Override
    public void ouvirMusica(Musica musica){
        System.out.println("🎶🎵🎶🎵");
        minhasAvaliacoes.add(musica);
    }
}

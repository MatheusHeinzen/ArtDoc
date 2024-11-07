import java.util.ArrayList;
import java.util.Scanner;

public class Critico extends Pessoa{
    //Atributos
    private String certificado;
    private ArrayList<Arte> artesAvaliadas = new ArrayList<Arte>();
    private ArrayList<Autor> autoresAvaliados = new ArrayList<Autor>();

    //Construtor
    public Critico(String usuario, String nomePessoa, String senha, String genero, String certificado) {
        super(usuario, senha, nomePessoa, genero);
        this.certificado = certificado;
    }

    //Métodos
    public String avaliarArte(int avaliacao, Arte arte)  throws NotaNegativaException {
        arte.adicionarNota(avaliacao);
        if (avaliacao < 0) {
            throw new NotaNegativaException("Não é possível atribuir uma nota negativa para uma Arte.");
        }
        artesAvaliadas.add(arte);
        return "Arte avaliada.";
    }
    public String avaliarAutor(int avaliacao, Autor autor) throws NotaNegativaException{
        autor.adicionarNota(avaliacao);
        if (avaliacao < 0) {
            throw new NotaNegativaException("Não é possível atribuir uma nota negativa para um Autor.");
        }
        autoresAvaliados.add(autor);
        return "Autor avaliado.";
    }

    @Override
    public void ouvirMusica(Musica musica) {
        System.out.println("Cê tá ouvindo!!! 🎶🎵🎶🎵 \n Mas musica também é arte, então avalia ela aí pra nx.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual a nota para essa música?");
        int avaliacao = sc.nextInt();
        try {
            avaliarArte(avaliacao, musica);
            artesAvaliadas.add(musica);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

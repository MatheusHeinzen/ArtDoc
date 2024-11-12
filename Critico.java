import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Critico extends Pessoa{
    //Atributos
    private int numCertificado;
    private ArrayList<Arte> artesAvaliadas = new ArrayList<Arte>();
    private ArrayList<Autor> autoresAvaliados = new ArrayList<Autor>();

    //Construtor
    public Critico(String usuario, String senha, String nomePessoa, String genero, int numCertificado) {
        super(usuario, senha, nomePessoa, genero);
        this.numCertificado = numCertificado;
    }

    //Métodos para ouvir musica e avaliar depois -- Metodo Sobrescrito.
    @Override
    public String ouvirMusica(Musica musica) {
        try {
            JOptionPane.showMessageDialog(null, "Cê tá ouvindo uma música daora!!!🎶🎵🎶🎵 \nMas musica também é arte, então avalia ela aí pra nx. \nQual a nota para essa música?" , "Ouvindo Musica", JOptionPane.INFORMATION_MESSAGE);
            Scanner sc = new Scanner(System.in);
            int avaliacao = sc.nextInt();
            sc.close();
            return  avaliarArte(avaliacao, musica);
            }
        catch (Exception e){
            e.printStackTrace();
            return "Não foi possível avaliar a Musica";
        }
    }

    //Métodos para avaliar Artes e Autores
    public String avaliarArte(int avaliacao, Arte arte)  throws NotaNegativaException {
        arte.adicionarNotaArte(avaliacao);
        if (avaliacao < 0) {
            throw new NotaNegativaException("Não é possível atribuir uma nota negativa para uma Arte.");
        }
        artesAvaliadas.add(arte);
        return "Arte avaliada.";
    }
    public String avaliarAutor(int avaliacao, Autor autor) throws NotaNegativaException{
        if (avaliacao < 0) {
            throw new NotaNegativaException("Não é possível atribuir uma nota negativa para um Autor.");
        }
        autor.adicionarNotaAutor(avaliacao);
        autoresAvaliados.add(autor);
        return "Autor avaliado.";
    }
}

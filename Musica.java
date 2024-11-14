import java.util.ArrayList;

public class Musica extends Arte {
    private String generoMusical;
    private String extensao;
    private static ArrayList<Musica> coletanea = new ArrayList<>();

    public Musica(String nome, Autor autor, int anoPublicacao, double valorArte, String generoMusical, String extensao) throws ExtensaoException {
        super(nome, autor, anoPublicacao, valorArte);
        this.generoMusical = generoMusical;
        this.extensao = extensao;
        if (!"mp3".equals(extensao)) {
            throw new ExtensaoException();
        }
        coletanea.add(this);
    }

    public static ArrayList<Musica> getColetanea() {
        return coletanea;
    }

    //To String
    public String toString() {
        return super.toString() +
                "\nGênero Musical: " + generoMusical +
                "\nValor da Musica: " + getValorArte();
    }

    //Metodo Abstrato Implementado
    public String listarArtes() {
        StringBuilder resultado = new StringBuilder("Lista de Todos as Musicas:\n");
        for (Musica musica : coletanea) {
            resultado.append("===========================\n");
            resultado.append(musica.toString()).append("\n");
            resultado.append("===========================\n");
        }
        return resultado.toString();
    }
}
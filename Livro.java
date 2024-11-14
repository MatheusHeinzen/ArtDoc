import java.util.ArrayList;

public class Livro extends Arte {
    //Atributos
    private String generoLiterario;
    private static ArrayList<Livro> biblioteca = new ArrayList<>();

    //Construtor
    public Livro(String nome, Autor autor, int anoPublicacao, double valorArte, String generoLiterario) {
        super(nome, autor, anoPublicacao, valorArte);
        this.generoLiterario = generoLiterario;
        biblioteca.add(this);
    }

    public static ArrayList<Livro> getBiblioteca() {
        return biblioteca;
    }

    //To String
    public String toString() {
        return super.toString() +
                "\nGênero Literário: " + generoLiterario +
                "\nValor do Livro: " + getValorArte();
    }

    //Metodo Abstrato Implementado
    public String listarArtes() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Lista de Todos os Livros:\n");
        for (Livro livro : biblioteca) {
            resultado.append(livro.toString()).append("\n");
            resultado.append("---------------------------\n");
        }
        return resultado.toString();
    }
}

import java.util.ArrayList;

public class Livro extends Arte {
    //Atributos
    private String generoLiterario;
    private int numeroPaginas;
    private double valorArte;
    private static ArrayList<Livro> listaLivros = new ArrayList<>();

    //Construtor
    public Livro(String nome, Autor autor, int anoPublicacao, String generoLiterario, int numeroPaginas, double valorArte) {
        super(nome, autor, anoPublicacao);
        this.generoLiterario = generoLiterario;
        this.numeroPaginas = numeroPaginas;
        this.valorArte = valorArte;
        listaLivros.add(this);
    }

    public String toString() {
        return super.toString() +
                "\nGênero Literário: " + generoLiterario +
                "\nNúmero de Páginas: " + numeroPaginas +
                "\nValor do Livro: " + getValorArte();
    }

    public double getValorArte() {
        return valorArte;
    }

    //Metodos
    public void listarObras() {
        System.out.println("Lista de Livros:");
        for (Livro livro : listaLivros) {
            System.out.println(livro.toString());
            System.out.println("---------------------------");
        }
    }
}

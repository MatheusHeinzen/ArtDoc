import java.util.ArrayList;


public class Livro extends Arte {
    private String generoLiterario;
    private int numeroPaginas;
    private String sinopse;
    private double valorLivro;

    private static ArrayList<Livro> listaLivros = new ArrayList<>();

    public Livro(String nome, String autor, String descricao, int anoPublicacao, String generoLiterario, int numeroPaginas, String sinopse, double valorLivro) {
        super(nome, autor, descricao, anoPublicacao);
        this.generoLiterario = generoLiterario;
        this.numeroPaginas = numeroPaginas;
        this.sinopse = sinopse;
        this.valorLivro = valorLivro;
        listaLivros.add(this);
    }

    public String toString() {
        return super.toString() +
                "\nGênero Literário: " + generoLiterario +
                "\nNúmero de Páginas: " + numeroPaginas +
                "\nSinopse: " + sinopse +
                "\nValor do Livro: " + valorLivro;
    }



    public void listarObras(){
        System.out.println("Lista de Livros:");
        for (Livro livro : listaLivros) {
            System.out.println(livro.toString());
            System.out.println("---------------------------");
    }
    //    void lerSinopse() {
     //       System.out.println("Sinopse: " + sinopse);
    //    }
    }

}

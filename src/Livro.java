package src;

public class Livro extends Arte{
    private String generoLiterario;
    private int numeroPaginas;
    private String sinopse;
    private double valorLivro;

    public Livro(String nome, String autor, String descricao, int anoPublicacao, String generoLiterario, int numeroPaginas, String sinopse, double valorLivro) {
        super(nome, autor, descricao, anoPublicacao);
        this.generoLiterario = generoLiterario;
        this.numeroPaginas = numeroPaginas;
        this.sinopse = sinopse;
        this.valorLivro = valorLivro;
    }


    public void listarObras(){

    }
    public void lerSinopse(){

    }
}

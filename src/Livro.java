package src;

public class Livro extends Arte{
    private String generoLiterario;
    private int numeroPaginas;

    public Livro(String nome, String autor, String descricao, int anoPublicacao, String generoLiterario, int numeroPaginas) {
        super(nome, autor, descricao, anoPublicacao);
        this.generoLiterario = generoLiterario;
        this.numeroPaginas = numeroPaginas;
    }
}
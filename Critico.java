public class Critico extends Pessoa{
    //Atributos
    private String certificado;

    //Construtor
    public Critico(String nomePessoa, String dataNascimento, String genero, String certificado) {
        super(nomePessoa, dataNascimento, genero);
        this.certificado = certificado;

    }

    //Métodos
    public void avaliarArte(int avaliacao, Arte arte){
        arte.adicionarNota(avaliacao);
    }
    public void avaliarAutor(int avaliacao, Autor autor){
        autor.adicionarNota(avaliacao);
    }
}

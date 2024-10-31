public class Critico extends Pessoa{
    //Atributos
    private String certificado;

    //Construtor
    public Critico(String nomePessoa, String dataNascimento, String genero, String senha, String certificado) {
        super(nomePessoa, dataNascimento, genero, senha);
        this.certificado = certificado;

    }

    //Métodos
    public String avaliarArte(int avaliacao, Arte arte){
        arte.adicionarNota(avaliacao);
        return "Arte avaliada.";
    }
    public String avaliarAutor(int avaliacao, Autor autor){
        autor.adicionarNota(avaliacao);
        return "Autor avaliado.";
    }
}

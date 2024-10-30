public class Critico extends Pessoa{
    private String certificado;

    public Critico(String nomePessoa, String dataNascimento, String genero, String certificado) {
        super(nomePessoa, dataNascimento, genero);
        this.certificado = certificado;

    }

    public void avaliarArte(int nota, Arte arte){
        arte.adicionarNota(nota);
    }
    public void avaliarAutor(){

    }
}

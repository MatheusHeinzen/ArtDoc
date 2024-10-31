public abstract class Pessoa {
    //Atributos
    private String nomePessoa;
    private String dataNascimento;
    private String genero;
    private String senha;

    //Construtor
    public Pessoa(String nomePessoa, String dataNascimento, String genero, String senha){
        this.nomePessoa = nomePessoa;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.senha = senha;

    }

}

public abstract class Pessoa {
    //Atributos
    private String nomePessoa;
    private String dataNascimento;
    private String senha;

    //Construtor
    public Pessoa(String nomePessoa, String dataNascimento, String senha){
        this.nomePessoa = nomePessoa;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }

    public void ouvirMusica(Musica musica){
        System.out.println("🎶🎵🎶🎵");
    }

    public abstract void setCarteira(int carteira);

    public abstract int getCarteira();
}

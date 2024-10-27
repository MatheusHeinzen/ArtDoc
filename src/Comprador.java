package src;

public class Comprador extends Pessoa{
    private double carteira;
    private String minhasObras;

    public Comprador(String nomePessoa, String dataNascimento, String genero, double carteira, String minhasObras) {
        super(nomePessoa, dataNascimento, genero);
        this.carteira = carteira;
        this.minhasObras = minhasObras;

    }
    public void comprarArte(){

    }

    public void fazerProposta(){

    }
}

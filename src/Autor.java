package src;

public class Autor extends Pessoa {
    private String minhasObras;
    private double mediaNotas;
    private double maxDesconto;

    public Autor(String nomePessoa, String dataNascimento, String genero, String minhasObras, double mediaNotas, double maxDesconto) {
        super(nomePessoa, dataNascimento, genero);
        this.minhasObras = minhasObras;
        this.mediaNotas = mediaNotas;
        this.maxDesconto = maxDesconto;


    }
}

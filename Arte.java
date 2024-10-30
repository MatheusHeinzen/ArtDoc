import java.util.ArrayList;

public abstract class Arte {
    //Atributos
    private String nomeArte;
    private String autor;
    private String descricao;
    private ArrayList<Integer> nota = new ArrayList<Integer>();
    private int anoPublicacao;
    private double valorArte;

    //Construtor
    public Arte(String nome, String autor, String descricao, int anoPublicacao, double valorArte){
        this.nomeArte = nome;
        this.autor = autor;
        this.descricao = descricao;
        this.anoPublicacao  = anoPublicacao;
        this.valorArte = valorArte;
    }

    //To String
    public String toString() {
        return "Nome: " + nomeArte +
                "\nAutor: " + autor +
                "\nDescrição: " + descricao +
                "\nAno de Publicação: " + anoPublicacao;
    }

    //Metodo Abstrato
    public abstract void listarObras();

    //Getters e Setters
    public String getNomeArte() {
        return nomeArte;
    }

    public double getValorArte() {
        return valorArte;
    }

    //Métodos
    public void adicionarNota(int avaliacao){
        nota.add(avaliacao);
    }

    public double mediaNota() {
        double somaNota = 0.0;
        for (int i : nota){
            somaNota += i;
        }
        return somaNota/nota.size();
    }
}

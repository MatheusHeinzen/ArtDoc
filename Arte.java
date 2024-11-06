import java.util.ArrayList;

public abstract class Arte {
    //Atributos
    private String nomeArte;
    private Autor autor;
    private int anoPublicacao;
    private ArrayList<Integer> nota = new ArrayList<Integer>();


    //Construtor
    public Arte(String nome, Autor autor, int anoPublicacao){
        this.nomeArte = nome;
        this.autor = autor;
        this.anoPublicacao  = anoPublicacao;
    }

    //To String
    public String toString() {
        return "Nome: " + nomeArte +
                "\nAutor: " + autor +
                "\nAno de Publicação: " + anoPublicacao;
    }

    //Metodo Abstrato
    public abstract void listarObras();

    //Getters e Setters
    public String getNomeArte() {
        return nomeArte;
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

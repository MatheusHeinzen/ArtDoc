import java.util.ArrayList;

public abstract class Arte {
    //Atributos
    private String nomeArte;
    private Autor autor;
    private int anoPublicacao;
    private double valorArte;
    private ArrayList<Integer> notasArte = new ArrayList<Integer>();
    private double mediaNotasArte;

    //Construtor
    public Arte(String nome, Autor autor, int anoPublicacao, double valorArte){
        this.nomeArte = nome;
        this.autor = autor;
        this.anoPublicacao  = anoPublicacao;
        this.valorArte = valorArte;
    }

    //To String
    public String toString() {
        return "Nome: " + nomeArte +
                "\nAutor: " + autor.getNomePessoa() +
                "\nAno de Publicação: " + anoPublicacao;
    }

    //Metodo Abstrato
    public abstract String listarArtes();

    //Getters e Setters
    public String getNomeArte() {
        return nomeArte;
    }
    public double getValorArte() {
        return valorArte;
    }
    public void setMediaNotasArte(double mediaNotasArte) {
        this.mediaNotasArte = mediaNotasArte;
    }

    //Métodos adicionando notas na Arte e calculando a Media das Notas.
    public void adicionarNotaArte(int avaliacao){
        notasArte.add(avaliacao);
    }
    public double calcularMediaNotasArte() {
        double somaNotas = 0.0;
        for (int i : notasArte){
            somaNotas += i;
        }
        double resultado = somaNotas/notasArte.size();
        setMediaNotasArte(resultado);
        return mediaNotasArte;
    }
}

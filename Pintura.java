public class Pintura extends Arte {
    //Atributos
    private String estilo;
    private double valorArte;

    //Construtor
    public Pintura(String nome, Autor autor, int anoPublicacao, String estilo, double valorArte) {
        super(nome, autor, anoPublicacao);
        this.estilo = estilo;
        this.valorArte = valorArte;
    }

    public double getValorArte() {
        return valorArte;
    }

    //Métodos   <> DESENVOLVER
    public void listarObras(){
    }
    public void visualizarArte(){
    }
}

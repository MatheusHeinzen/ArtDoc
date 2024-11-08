public class Pintura extends Arte {
    //Atributos
    private String estilo;

    //Construtor
    public Pintura(String nome, Autor autor, int anoPublicacao, String estilo, double valorArte) {
        super(nome, autor, anoPublicacao);
        this.estilo = estilo;
    }


    //Métodos   <> DESENVOLVER
    public void listarObras(){
    }
    public void visualizarArte(){
    }
}

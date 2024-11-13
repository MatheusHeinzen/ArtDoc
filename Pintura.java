import java.util.ArrayList;

public class Pintura extends Arte {
    //Atributos
    private String estilo;
    private static ArrayList<Pintura> colecao = new ArrayList<>();

    //Construtor
    public Pintura(String nome, Autor autor, int anoPublicacao, double valorArte, String estilo) {
        super(nome, autor, anoPublicacao, valorArte);
        this.estilo = estilo;
        colecao.add(this);
    }

    //To String
    public String toString() {
        return super.toString() +
                "\nEstilo de Pintura: " + estilo +
                "\nValor da Musica: " + getValorArte();
    }

    //Metodo Abstrato Implementado
    public String listarArtes() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Lista de Todos as Pinturas:\n");
        for (Pintura pintura : colecao) {
            resultado.append(pintura.toString()).append("\n");
            resultado.append("---------------------------\n");
        }
        return resultado.toString();
    }
}

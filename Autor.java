import java.util.ArrayList;

public class Autor extends Pessoa {
    //Atributos
    private ArrayList<Arte> minhasObras = new ArrayList<Arte>();
    private ArrayList<Integer> notas = new ArrayList<Integer>();
    private double mediaNotas;

    //Construtor
    public Autor(String usuario, String nomePessoa, String senha, String genero) {
        super(usuario, senha, nomePessoa, genero);
    }

    //Getters e Setters
    public void setMediaNotas(double mediaNotas) {
        this.mediaNotas = mediaNotas;
    }

    //Metodos
    public void adicionarObra(Arte novaObra){
        minhasObras.add(novaObra);
        System.out.println("Obra adicionada.");
    }

    public void mostrarMinhasObras(){
        for (Arte obra : minhasObras){
            System.out.println(obra.getNomeArte());
        }
    }

    public void adicionarNota(int avaliacao) {
        notas.add(avaliacao);
    }

    public double calcularMediaNotas(){
        double somaNota = 0;
        for (Arte obra : minhasObras){
            somaNota += obra.mediaNota();
        }
        double resultado = somaNota/minhasObras.size();
        setMediaNotas(resultado);
        return mediaNotas;
    }


}

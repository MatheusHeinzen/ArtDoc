import java.util.ArrayList;

public class Autor extends Pessoa {
    private ArrayList<Arte> minhasObras = new ArrayList<Arte>();
    private double mediaNotas;
    private double maxDesconto;

    public Autor(String nomePessoa, String dataNascimento, String genero, double mediaNotas, double maxDesconto) {
        super(nomePessoa, dataNascimento, genero);
        this.mediaNotas = mediaNotas;
        this.maxDesconto = maxDesconto;

    }

    public void adicionarObra(Arte novaObra){
        minhasObras.add(novaObra);
        System.out.println("Obra adicionada.");
    }

    public void mostrarMinhasObras(){
        for (Arte obra : minhasObras){
            System.out.println(obra.getNomeArte());
        }
    }


}

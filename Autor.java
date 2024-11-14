import java.util.ArrayList;

public class Autor extends Pessoa {
    //Atributos
    private ArrayList<Integer> minhasNotas = new ArrayList<Integer>();
    private double mediaMinhasNotas;
    private ArrayList<Arte> minhasArtes = new ArrayList<Arte>();
    private double mediaNotasMinhasArtes;
    private ArrayList<Autor> listaAutores = new ArrayList<Autor>();

    //Construtor
    public Autor(String usuario, String senha, String nomePessoa, String genero) {
        super(usuario, senha, nomePessoa, genero);
        listaAutores.add(this);
    }

    //Getters e Setters
    public void listarMinhasArtes(){
        for (Arte arte : minhasArtes){
            System.out.println(arte.getNomeArte());
        }
    }
    public void setMediaMinhasNotas(double mediaMinhasNotas) {
        this.mediaMinhasNotas = mediaMinhasNotas;
    }
    public void setMediaNotasMinhasArtes(double mediaNotasArtes) {
        this.mediaNotasMinhasArtes = mediaNotasArtes;
    }

    public double getMediaMinhasNotas() {
        return mediaMinhasNotas;
    }

    public ArrayList<Autor> getListaAutores() {
        return listaAutores;
    }

    //Metodos para adicionar e listar Obras
    public Arte adicionarNovaArte(String tipo, String nome, int anoPublicacao, double valorArte, String generoOuEstilo, String extensao) throws ExtensaoException {
        Arte novaArte;
        switch (tipo.toLowerCase()) {
            case "livro":
                novaArte = new Livro(nome, this, anoPublicacao, valorArte, generoOuEstilo);
                break;
            case "musica":
                novaArte = new Musica(nome, this, anoPublicacao, valorArte, generoOuEstilo, extensao);
                break;
            case "pintura":
                novaArte = new Pintura(nome, this, anoPublicacao, valorArte, generoOuEstilo);
                break;
            default:
                throw new IllegalArgumentException("Tipo de arte desconhecido: " + tipo);
        }
        minhasArtes.add(novaArte);
        System.out.println("Arte adicionada.");
        return novaArte;
    }

    //Métodos adicionando notas no Autor e calculando a Media das Notas.
    public void adicionarNotaAutor(int avaliacao) {
        minhasNotas.add(avaliacao);
    }
    public double calcularMediaMinhasNotas() {
        double somaNotas = 0.0;
        for (int i : minhasNotas){
            somaNotas += i;
        }
        double resultado = somaNotas/minhasNotas.size();
        setMediaMinhasNotas(resultado);
        return mediaMinhasNotas;
    }

    //Métodos adicionando notas nas obras do Autor e calculando a Media das Notas.
    public double calcularMediaNotasMinhasArtes(){
        double somaNotas = 0;
        for (Arte obra : minhasArtes){
            somaNotas += obra.calcularMediaNotasArte();
        }
        double resultado = somaNotas/minhasArtes.size();
        setMediaNotasMinhasArtes(resultado);
        return mediaNotasMinhasArtes;
    }

    public <T> ArrayList<Arte> getMinhasArtes() {
        return minhasArtes;
    }
}
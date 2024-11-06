import java.util.ArrayList;

public abstract class Pessoa {
    //Atributos
    private String usuario;
    private String senha;
    private String nomePessoa;
    private String genero;
    ArrayList<Arte> playlist = new ArrayList<>();

    //Construtor
    public Pessoa(String usuario, String nomePessoa, String senha, String genero){
        this.usuario = usuario;
        this.senha = senha;
        this.nomePessoa = nomePessoa;
        this.genero = genero;
    }

    //Metodos
    public void ouvirMusica(Musica musica) {
        System.out.println("Cê tá ouvindo!!! 🎶🎵🎶🎵");
    }

    public void adicionarNaPlaylist(Musica musica) {
            playlist.add(musica);
        }

    public void retirarDaPlaylist(Musica musica) {
        playlist.remove(musica);
    }
}

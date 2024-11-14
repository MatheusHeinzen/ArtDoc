import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa implements Serializable {
    //Atributos
    private String usuario;
    private String senha;
    private String nomePessoa;
    private String genero;
    private ArrayList<Musica> playlist = new ArrayList<>();

    //Construtor
    public Pessoa(String usuario, String nomePessoa, String senha, String genero){
        this.usuario = usuario;
        this.senha = senha;
        this.nomePessoa = nomePessoa;
        this.genero = genero;
    }

    //Getters e Setters
    public String getNomePessoa() {
        return nomePessoa;
    }
    public ArrayList<Musica> getPlaylist() {
        return new ArrayList<>(playlist);
    }

    //Metodos utilizando Musicas
    public String ouvirMusica(Musica musica) {
        return "Cê tá ouvindo uma música daora!!! 🎶🎵🎶🎵";
    }
    public String adicionarNaPlaylist(Musica musica) {
        if (!playlist.contains(musica)) {
            playlist.add(musica);
            return "Música adicionada na Playlist";
        }
        return "A música já está na playlist.";
    }
    public void retirarDaPlaylist(Musica musica) {
        playlist.remove(musica);
    }
    public String visualizarPlaylist() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Lista de Musicas da Playlist:\n");
        for (Musica musica : playlist) {
            resultado.append(musica.toString()).append("\n");
            resultado.append("---------------------------\n");
        }
        return resultado.toString();
    }

    //Metodos utilizando Pinturas
    public String admirarPintura() {
        return "Nooossa! Que bela de uma pintura daora!!! 🤩🤩🤩";
    }
}
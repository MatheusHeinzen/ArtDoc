import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa implements Serializable {
    //Atributos
    private String usuario;
    private String senha;
    private String nomePessoa;
    private String genero;
    ArrayList<Musica> playlist = new ArrayList<>();

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

    //Metodos utilizando Musicas
    public String ouvirMusica(Musica musica) {
        return "Cê tá ouvindo uma música daora!!! 🎶🎵🎶🎵";
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
    public String adicionarNaPlaylist(Musica musica) {
        playlist.add(musica);
        return "Musica adicionada na Playlist";
    }
    public void retirarDaPlaylist(Musica musica) {
        playlist.remove(musica);
    }

    //Metodos utilizando Pinturas
    public String admirarPintura() {
        return "Nooossa! Que bela de uma pintura daora!!! 🤩🤩🤩";
    }
}


package src;

public abstract class Usuario {
    private String nomeUsuario;
    private String dataNascimento;
    private String genero;



    public Usuario(String nomeUsuario, String dataNascimento, String genero){
        this.nomeUsuario = nomeUsuario;
        this.dataNascimento = dataNascimento;
        this.genero = genero;

    }


}

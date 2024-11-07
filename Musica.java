public class Musica extends Arte {
    private String generoMusical;
    private double duracao;
    private String extensao;

    public Musica(String nome, Autor autor, int anoPublicacao, String generoMusical, double duracao, String extensao) throws ExtensaoException {
        super(nome, autor, anoPublicacao);
        this.generoMusical = generoMusical;
        this.duracao = duracao;
        this.extensao = extensao;
        if (!"mp3".equals(extensao)) {
            throw new ExtensaoException();
        }
    }

    public void listarObras(){
    }

}

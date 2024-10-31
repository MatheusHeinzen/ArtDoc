public class Musica extends Arte {
    private String estilo;
    private double duracao;
    private String extensao;

    public Musica(String nome, String autor, String descricao, int anoPublicacao, String estilo, double duracao, double valorArte, String extensao) throws ExtensaoException {
        super(nome, autor, descricao, anoPublicacao, valorArte);
        this.estilo = estilo;
        this.duracao = duracao;
        this.extensao = extensao;
        if (!"mp3".equals(extensao)) {
            throw new ExtensaoException("Arquivo não suportado. O programa aceita apenas mp3.");
        }
    }

    public void listarObras(){
    }
}

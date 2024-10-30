public abstract class Arte {
    private String nomeArte;
    private String autor;
    private String descricao;
    private int anoPublicacao;
    private double valorArte;


    public Arte(String nome, String autor, String descricao, int anoPublicacao, double valorArte){
        this.nomeArte = nome;
        this.autor = autor;
        this.descricao = descricao;
        this.anoPublicacao  = anoPublicacao;
        this.valorArte = valorArte;
    }

    public String toString() {
        return "Nome: " + nomeArte +
                "\nAutor: " + autor +
                "\nDescrição: " + descricao +
                "\nAno de Publicação: " + anoPublicacao;
    }


    public void listarObras(){

    }

    public String getNomeArte() {
        return nomeArte;
    }

    public double getValorArte() {
        return valorArte;
    }
}

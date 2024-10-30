public class Main {
    public static void main(String[] args) {
        Livro livro1 = new Livro("Harry Potter", "JK", "mlk q quase morreu", 1997, "Ficção", 300, "Sinopse A", 39.90);
        Livro livro2 = new Livro("IT", "Stephen King", "molecada ferrada com um et", 2014, "Terror", 250, "Sinopse B", 29.90);

        livro1.listarObras();

        Critico c = new Critico("Jorge", "30/09", "M" , "Confia");

        c.avaliarArte(5, livro1);
        c.avaliarArte(0, livro1);
        System.out.println(livro1.mediaNota());
    }
}
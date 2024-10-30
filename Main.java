public class Main {
    public static void main(String[] args) {
        Livro livro1 = new Livro("Harry Potter", "JK", "mlk q quase morreu", 1997, "Ficção", 300, "Sinopse A", 39.90);
        Livro livro2 = new Livro("IT", "Stephen King", "molecada ferrada com um et", 2014, "Terror", 250, "Sinopse B", 29.90);

        livro1.listarObras();

        Autor autor = new Autor("Jorge", "30/09", "M" , 5.0 , 3);
        autor.adicionarObra(livro1);
        autor.mostrarMinhasObras();
        autor.adicionarObra(livro2);
        autor.mostrarMinhasObras();
    }
}
package src;

public class Main {
    public static void main(String[] args) {
        Livro livro1 = new Livro("Harry Potter", "JK", "mlk q quase morreu", 1997, "Ficção", 300, "Sinopse A", 39.90);
        Livro livro2 = new Livro("IT", "Stephen King", "molecada ferrada com um et", 0021, "Terror", 250, "Sinopse B", 29.90);

        livro1.listarObras(); // Exibe a lista completa de livros
    }
}
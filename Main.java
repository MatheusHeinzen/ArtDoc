import javax.swing.*;

public class Main {
    public static void main(String[] args) throws NotaNegativaException {
        SwingUtilities.invokeLater( () -> {
            InterfaceGrafica frame = new InterfaceGrafica();
            frame.setVisible(true);
        });

        Autor autor1 = new Autor("JorgeSegundo", "Jorge Segundo", "123", "Sim");

        Livro livro1 = new Livro("Harry Potter", autor1, 1995, "Ficção", 300, 35);
        Livro livro2 = new Livro("IT", autor1, 2014, "Sim", 300, 25);

        livro1.listarArtes();

        Critico c = new Critico("Jorge", "30/09", "M" , "123", "Confia");

        c.avaliarArte(5, livro1);
        c.avaliarArte(0, livro1);
        System.out.println(livro1.mediaNota());

        try {
            Musica musica1 = new Musica("Risk", autor1, 18723, "Masculino", 15, "mp4");
        }
        catch (ExtensaoException e) {
            System.out.println(e.getMessage());
        }

    }
}
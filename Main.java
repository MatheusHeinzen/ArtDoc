import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static Pessoa usuarioLogado;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainInterface());
        Autor autorAdmin = new Autor ("autorAdmin","123","nomeAutor","m");
        FileManager listaPessoas = new FileManager("./database/pessoas.csv");
        listaPessoas.lerArquivoPessoa();
        ArrayList listaAutoresAtualizada = autorAdmin.getListaAutores();
        FileManager listaArtes = new FileManager("./database/artes.csv");
        listaArtes.lerArquivoArte(listaAutoresAtualizada);
    }

    public static void setUsuarioLogado(Pessoa usuario) {
        usuarioLogado = usuario;
    }
    public static Pessoa getUsuarioLogado() {
        return usuarioLogado;
    }

    public static boolean autenticarUsuario(String usuario, String senha) {
        // Exemplo de autenticação (substitua com lógica real, como buscar no banco de dados)
        if (usuario.equals("comprador") && senha.equals("123")) {
            usuarioLogado = MainInterface.criarComprador();
            return true;
        } else if (usuario.equals("autor") && senha.equals("123")) {
            usuarioLogado = MainInterface.criarAutor();
            return true;
        } else if (usuario.equals("critico") && senha.equals("123")) {
            usuarioLogado = MainInterface.criarCritico();
            return true;
        }
        return false;
    }

}
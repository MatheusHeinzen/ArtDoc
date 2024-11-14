import javax.swing.*;

public class Main {
    public static Pessoa usuarioLogado;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainInterface());
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
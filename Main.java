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
            usuarioLogado = new Comprador("comprador", "123", "Nome do Comprador", "M", 100.0);
            return true;
        } else if (usuario.equals("autor") && senha.equals("123")) {
            usuarioLogado = new Autor("autor", "123", "Nome do Autor", "F");
            return true;
        } else if (usuario.equals("critico") && senha.equals("123")) {
            usuarioLogado = new Critico("critico", "123", "Nome do Crítico", "M", 12345);
            return true;
        }
        return false;
    }
}
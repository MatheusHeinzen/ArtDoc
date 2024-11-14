import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static Pessoa usuarioLogado;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainInterface::new);
    }

    public static void setUsuarioLogado(Pessoa usuario) {
        usuarioLogado = usuario;
    }

    public static Pessoa getUsuarioLogado() {
        return usuarioLogado;
    }
}

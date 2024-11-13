import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaArquivo implements Serializable  {
    private static final String NOME_ARQUIVO = "pessoas.dat";

    // Método para salvar a lista de pessoas
    public static void salvarPessoas(List<Pessoa> pessoas) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(NOME_ARQUIVO))) {
            out.writeObject(pessoas);
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para carregar a lista de pessoas
    public static List<Pessoa> carregarPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(NOME_ARQUIVO))) {
            pessoas = (List<Pessoa>) in.readObject();
            System.out.println("Dados carregados com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    public static void main(String[] args) {
        // Exemplo de uso
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Autor("jorgeteceiro", "lala", "38237", "muie"));
        pessoas.add(new Autor("Maria", "rabadao", "fdskfhu", "idsjb"));

        salvarPessoas(pessoas); // Persistindo os dados em arquivo

        List<Pessoa> pessoasCarregadas = carregarPessoas(); // Carregando os dados do arquivo
        for (Pessoa pessoa : pessoasCarregadas) {
            System.out.println(pessoa);
        }
    }
}

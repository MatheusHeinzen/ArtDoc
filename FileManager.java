import javax.imageio.IIOException;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    private String caminhoArquivo;
    String [][] lista = {}; // isso serve pra escrever num arquivo.

    //Construtor
    public FileManager(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    //Metodos para leitura de arquvivos
    public ArrayList<Pessoa> lerArquivoPessoa() {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String cabecalho = br.readLine(); // Ignora o cabeçalho
            String linha;
            Pessoa novaPessoa;
            while ((linha = br.readLine()) != null) {
                String[] dadoSeparado = linha.split(",");
                List<String> dadoTratado = Arrays.asList(dadoSeparado);
                switch (dadoTratado.get(0).toLowerCase()) {
                    case "autor":
                        novaPessoa = new Autor(dadoTratado.get(1), dadoTratado.get(2), dadoTratado.get(3), dadoTratado.get(4));
                        break;
                    case "comprador":
                        int carteira = Integer.parseInt(dadoTratado.get(5));
                        novaPessoa = new Comprador(dadoTratado.get(1), dadoTratado.get(2), dadoTratado.get(3), dadoTratado.get(4), carteira);
                        break;
                    case "critico":
                        int numCertificado = Integer.parseInt(dadoTratado.get(5));
                        novaPessoa = new Critico(dadoTratado.get(1), dadoTratado.get(2), dadoTratado.get(3), dadoTratado.get(4), numCertificado);
                        break;
                    default:
                        throw new IllegalArgumentException("Tipo de Pessoa não reconhecido: " + dadoTratado.get(0));
                }
                pessoas.add(novaPessoa); // Adiciona cada pessoa à lista
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    public void lerArquivoArte(ArrayList<Autor> listaAutores) {
        try {
            FileReader arquivo = new FileReader("caminho/do/arquivo.txt");
            BufferedReader br = new BufferedReader(arquivo);
            String cabecalho = br.readLine();
            while (br.ready()) {
                String dado = br.readLine();
                String[] dadoSeparado = dado.split(",");
                List<String> dadoTratado = Arrays.asList(dadoSeparado);

                for (Autor autor : listaAutores) {
                    if (autor.getNomePessoa().equalsIgnoreCase(dadoTratado.get(2))) {
                        int anoPublicacao = Integer.parseInt(dadoTratado.get(3));
                        double valorArte = Double.parseDouble(dadoTratado.get(4));
                        autor.adicionarNovaArte(
                                dadoTratado.get(0),
                                dadoTratado.get(1),
                                anoPublicacao,
                                valorArte,
                                dadoTratado.get(5),
                                dadoTratado.size() > 6 ? dadoTratado.get(6) : null
                        );
                        break; // Pare o loop após encontrar o autor certo
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void escreverArquivo () {
        File arquivo = new File (caminhoArquivo);
        try {
            FileWriter fileWriter = new FileWriter (arquivo, true);
            for (String[] valor : lista) {
                StringBuilder line = new StringBuilder();
                for(int i=0; i < valor.length; i++){
                    line.append(valor[i]);
                    if (i != valor.length -1){
                        line.append(',');
                    }
                }
                line.append("\n");
                fileWriter.append(line.toString());
            }
            fileWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}










//METODO PARA LER ARQUIVOS SCANNER ENSINADO NA AULA .

//public void lerArquivoScanner() {
//    File file = new File(caminhoArquivo);
//    try {
//        Scanner scanner = new Scanner(file);
//        String cabecalho = scanner.nextLine();
//        System.out.println(cabecalho);
//        while (scanner.hasNextLine()) {
//            String dado = scanner.nextLine();
//            Scanner dadoSeparado = new Scanner(dado).useDelimiter(",");
//            System.out.println("ID" + dadoSeparado.nextInt());
//            System.out.println("Nome" + dadoSeparado.next());
//            System.out.println("Praço" + dadoSeparado.nextInt());
//            dadoSeparado.close();
//        }
//    } catch (FileNotFoundException e) {
//        e.printStackTrace();
//    }
//}



// FileManager listaPessoas = new FileManager("./database/csv.csv");
// listaPessoas.lerArquivoPessoa();
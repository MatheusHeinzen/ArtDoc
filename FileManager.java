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
    public void lerArquivoPessoa () {
        try {
            FileReader arquivo = new FileReader(caminhoArquivo);
            BufferedReader br = new BufferedReader(arquivo);
            String cabecalho = br.readLine();
            while (br.ready()) {
                String dado = br.readLine();
                String [] dadoSeparado = dado.split(",");
                List<String> dadoTratado = Arrays.asList(dadoSeparado);
                // get(0) = tipo
                // get(1) = usuario
                // get(2) = senha
                // get(3) = nomePessoa
                // get(4) = genero
                // get(5) = numCertificado ou Carteira
                Pessoa novaPessoa;
                switch (dadoTratado.get(0).toLowerCase()) {
                    case "autor":
                        novaPessoa = new Autor(dadoTratado.get(1),dadoTratado.get(2),dadoTratado.get(3),dadoTratado.get(4));
                        break;
                    case "comprador":
                        double carteira = Double.parseDouble(dadoTratado.get(5));
                        novaPessoa = new Comprador(dadoTratado.get(1),dadoTratado.get(2),dadoTratado.get(3),dadoTratado.get(4),carteira);
                        break;
                    case "critico":
                        double numCertificado = Double.parseDouble(dadoTratado.get(5));
                        novaPessoa = new Critico(dadoTratado.get(1),dadoTratado.get(2),dadoTratado.get(3),dadoTratado.get(4), (int) numCertificado);
                        break;
                    default:
                        throw new IllegalArgumentException("Tipo de Pessoa não validado" + dadoTratado.get(0));
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void lerArquivoArte (ArrayList<Autor> listaAutores) {
        try {
            FileReader arquivo = new FileReader(caminhoArquivo);
            BufferedReader br = new BufferedReader(arquivo);
            String cabecalho = br.readLine();
            while (br.ready()) {
                String dado = br.readLine();
                String[] dadoSeparado = dado.split(",");
                List<String> dadoTratado = Arrays.asList(dadoSeparado);
                // get(0) = tipo
                // get(1) = nome da arte
                // get(2) = autor (nome do autor)
                // get(3) = anoPublicacao - int
                // get(4) = valorArte - double
                // get(5) = generoOuEstilo
                // get(6) = extensao
                //PROCURANDO O AUTOR
                for (Autor autor : listaAutores) {
                    if (autor.getNomePessoa().equalsIgnoreCase(dadoTratado.get(2))) {
                        int anoPublicacao = Integer.parseInt(dadoTratado.get(3));
                        double valorArte = Double.parseDouble(dadoTratado.get(4));
                        autor.adicionarNovaArte(dadoTratado.get(0), dadoTratado.get(1), anoPublicacao, valorArte, dadoTratado.get(5), dadoTratado.get(6));
                    } else {
                        System.out.println("Autor não encontrado: " + dadoTratado.get(2));
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

    public void salvarArquivoPessoa(ArrayList<Pessoa> listaPessoas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Pessoa pessoa : listaPessoas) {
                bw.write(pessoa.toCSV()); // toCSV() deve converter Pessoa para formato CSV
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();


        }
    }

    public void salvarArquivoArte(ArrayList<Arte> listaArtes) {
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
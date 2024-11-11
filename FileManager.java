import javax.imageio.IIOException;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    private String caminhoArquivo;
    String [][] lista = {};

    //Construtor
    public FileManager(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    //Metodos para leitura de arquvivos
    public void lerArquivoScanner() {
        File file = new File(caminhoArquivo);
        try {
            Scanner scanner = new Scanner(file);
            String cabecalho = scanner.nextLine();
            System.out.println(cabecalho);
            while (scanner.hasNextLine()) {
                String dado = scanner.nextLine();
                Scanner dadoSeparado = new Scanner(dado).useDelimiter(",");
                System.out.println("ID" + dadoSeparado.nextInt());
                System.out.println("Nome" + dadoSeparado.next());
                System.out.println("Praço" + dadoSeparado.nextInt());
                dadoSeparado.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void lerArquivoBufferedReader () {
        try {
            FileReader arquivo = new FileReader(caminhoArquivo);
            BufferedReader br = new BufferedReader(arquivo);
            String cabecalho = br.readLine();
            System.out.println(cabecalho);
            br.close();
            while (br.ready()) {
                String dado = br.readLine();
                String [] dadoSeparado = dado.split(",");
                List<String> dadoTratado = Arrays.asList(dadoSeparado);
                System.out.println("ID" + dadoTratado.get(0));
                System.out.println("Nome" + dadoTratado.get(1));
                System.out.println("Praço" + dadoTratado.get(2));
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


// FileManager fm = new FileManager("./database/csv.csv");
// fm.lerArquivoScanner();
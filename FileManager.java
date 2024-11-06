import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileManager {
    private String caminhoArquivo;

    public FileManager(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

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
                System.out.println(dadoSeparado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}


// FileManager fm = new FileManager("./database/csv.csv");
// fm.lerArquivoScanner();
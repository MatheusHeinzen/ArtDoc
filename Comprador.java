import java.util.ArrayList;

public class Comprador extends Pessoa{
    //Atributos
    private double carteira;
    private ArrayList<Arte> minhasObras = new ArrayList<Arte>();
    private ArrayList<Arte> minhaLista = new ArrayList<Arte>();

    //Construtor
    public Comprador(String nomePessoa, String dataNascimento, String genero, String senha, double carteira) {
        super(nomePessoa, dataNascimento, genero, senha);
        this.carteira = carteira;

    }

    //Métodos
    public String adicionarSaldo(double dinheiro){
        if (dinheiro>0){
            carteira += dinheiro;
            return "Sua carteira agora tem R$ " + carteira;
        } else{
            return "O valor não pode ser adicionado ao saldo, tente colocar um valor válido.";
        }
    }
    public String comprarArte(Arte obraDesejada){
        if (carteira >= obraDesejada.getValorArte()){
            minhasObras.add(obraDesejada);
            return "Obra comprada com sucesso.";
        } else{
            return "A compra foi negada, consulte o seu saldo.";
        }
    }

    public void adicionarNaMinhaLista(Arte obraDesejada){
        minhaLista.add(obraDesejada);
    }

    public void verMinhaLista(){
        for (Arte arte : minhaLista){
            System.out.println(arte.getNomeArte());
        }
    }
}

import java.util.ArrayList;

public class Comprador extends Pessoa{
    //Atributos
    private double carteira;
    private ArrayList<Arte> minhasArtesCompradas = new ArrayList<Arte>();
    private ArrayList<Arte> minhaListaDeDesejos = new ArrayList<Arte>();

    //Construtor
    public Comprador(String usuario, String senha, String nomePessoa, String genero, double carteira) {
        super(usuario, senha, nomePessoa, genero);
        this.carteira = carteira;

    }

    //Getters e Setters
    public double getSaldo() {
        return carteira;
    }
    public void adicionarNaMinhaListaDeDesejos(Arte arteDesejada) {
        minhaListaDeDesejos.add(arteDesejada);
    }
    public void verMinhaListaDeDesejos(){
        for (Arte arte : minhaListaDeDesejos){
            System.out.println(arte.getNomeArte());
        }
    }

    //Métodos para adicionar fundos e comprar Artes.
    public String adicionarSaldo(double dinheiro){
        if (dinheiro>0){
            carteira += dinheiro;
            return "Sua carteira agora tem R$ " + carteira;
        } else{
            return "O valor não pode ser adicionado ao saldo, tente colocar um valor válido.";
        }
    }
    public String comprarArte(Arte arteDesejada){
        if (carteira >= arteDesejada.getValorArte()){
            minhasArtesCompradas.add(arteDesejada);
            return "Obra comprada com sucesso.";
        } else{
            return "A compra foi negada por falta de saldo." +
                    "\n Seu saldo atual é de R$ " + getSaldo();
        }
    }
}
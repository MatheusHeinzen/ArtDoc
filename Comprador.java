import java.util.ArrayList;

public class Comprador extends Pessoa{
    private double carteira;
    private ArrayList<Arte> minhasObras = new ArrayList<Arte>();
    private ArrayList<Arte> minhaLista = new ArrayList<Arte>();

    public Comprador(String nomePessoa, String dataNascimento, String genero, double carteira) {
        super(nomePessoa, dataNascimento, genero);
        this.carteira = carteira;

    }

    public void adicionarSaldo(double dinheiro){
        if (dinheiro>0){
            carteira += dinheiro;
        } else{
            System.out.println("O valor não pode ser adicionado ao saldo, tente colocar um valor válido.");
        }
    }
    public void comprarArte(Arte obraDesejada){
        if (carteira >= obraDesejada.getValorArte()){
            minhasObras.add(obraDesejada);
        } else{
            System.out.println("A compra foi negada, consulte o seu saldo ou faça uma proposta.");
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

    public void fazerProposta(){

    }
}

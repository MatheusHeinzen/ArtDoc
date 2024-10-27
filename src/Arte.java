package src;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Arte {
    private String nomeArte;
    private String autor;
    private String descricao;
    private int anoPublicacao;



    public Arte(String nome, String autor, String descricao, int anoPublicacao){
        this.nomeArte = nome;
        this.autor = autor;
        this.descricao = descricao;
        this.anoPublicacao  = anoPublicacao;
    }

    public String toString() {
        return "Nome: " + nomeArte +
                "\nAutor: " + autor +
                "\nDescrição: " + descricao +
                "\nAno de Publicação: " + anoPublicacao;
    }


    public void listarObras(){

    }


}

package models;

import java.io.Serializable;

public class Produto implements Serializable {
    private String nome;
    private String preco;
//    private int imagem;

    public Produto(String nome, String preco) {
        this.nome = nome;
        this.preco = preco;
//        this.imagem = imagem;
    }

    public String getNome() {
        return this.nome;
    }

    public String getPreco() {
        return this.preco;
    }
}

package models;

public class Usuario {
    public String nome;
    public String profissao;
    public String descricao;


    public Usuario(String nome, String profissao, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.profissao = profissao;
    }
}

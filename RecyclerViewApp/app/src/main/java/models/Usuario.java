package models;

public class Usuario {
    private String nome;
    private String profissao;

    public Usuario(String nome, String profissao) {
        this.nome = nome;
        this.profissao = profissao;
    }

    public String getNome() {
        return this.nome;
    }

    public String getProfissao() {
        return this.profissao;
    }
}

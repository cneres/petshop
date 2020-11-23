package com.model;

public class Servico {


    private int id;
    private String nome;
    private double preço;
    private String descricao;

    //metodo construtor vazio
    public Servico(){

    }

    //metodo construtor com parametros
    public Servico( String nome, double preço, String descricao) {

        this.nome = nome;
        this.preço = preço;
        this.descricao = descricao;
    }

    //getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

package com.model;

public class Cliente {



    private String nome;
    private String cpf;
    private String telefone;
    private String endereço;

    //metodo construtor vazio
    public Cliente(){

    }

    //metodo construtor com parametros
    public Cliente(String nome, String cpf, String telefone, String endereço) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereço = endereço;
    }

    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }


}

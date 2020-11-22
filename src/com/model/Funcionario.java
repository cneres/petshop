package com.model;

public class Funcionario {



    private String nome;
    private String cpf;
    private String telefone;
    private String endereço;
    private String cargo;

    //metodo construtor vazio
    public Funcionario(){

    }

    //metodo construtor com parametros
    public Funcionario(String nome, String cpf, String telefone, String endereço, String cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereço = endereço;
        this.cargo = cargo;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}

package com.model;

import java.util.List;

public class OS {




    private int id;
    private int idAnimal;
    private String cpfFuncionario;
    private String status;
    private List<Servico> listaDeServico;

    //metodo construtor vazio
    public OS(){

    }
    //metodo construtor com parametros
    public OS(int id, int idAnimal, String cpfFuncionario, String status, List<Servico> listaDeServico) {
        this.id = id;
        this.idAnimal = idAnimal;
        this.cpfFuncionario = cpfFuncionario;
        this.status = status;
        this.listaDeServico = listaDeServico;
    }
    //getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Servico> getListaDeServico() {
        return listaDeServico;
    }

    public void setListaDeServico(List<Servico> listaDeServico) {
        this.listaDeServico = listaDeServico;
    }


}

package com.model;

public class Animal {

    private String apelido;
    private String raça;
    private String cor;



    private String cpfDono;
    private int id;



    //metodo construtor com todos os parametros
    public Animal(String apelido, String raça, String cor,String cpfDono, int id){

        super();
        this.apelido = apelido;
        this.raça = raça;
        this.cor = cor;
        this.cpfDono = cpfDono;
        this.id = id;
    }

    //metodo construtor vazio
   public Animal(){

   }
    //getters e setters

    public String getCpfDono() {
        return cpfDono;
    }

    public void setCpfDono(String cpfDono) {
        this.cpfDono = cpfDono;
    }
    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getRaça() {
        return raça;
    }

    public void setRaça(String raça) {
        this.raça = raça;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package com.dao;

import com.model.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO implements DAO<Animal> {


    @Override
    public Animal salvar(Animal entidade) {
        int idAnimal = 0;
        String apelido = "";
        String cpfDono = "";
        String raca = "";
        String cor = "";

        //criando conexao com BD
        String url = "jbdc:sqlite:\\C:\\Users\\Carlos Neres\\IdeaProjects\\petshop\\lib\\sqlite-jdbc-3.32.3.2.jar\\";
        Connection con = null;

        try {
            con = DriverManager.getConnection(url);

            //criando o executor e query
            String sql = "insert into animal (idAnimal, apelido, cpfDono, raca, cor) values (?, ?, ?, ?, ?);";
            PreparedStatement executor = con.prepareStatement(sql);
            executor.setInt(1, idAnimal);
            executor.setString(2,apelido);
            executor.setString(3, cpfDono);
            executor.setString(4, raca);
            executor.setString(5, cor);

            int retorno = executor.executeUpdate();

            if (retorno == 1){

                System.out.println("Sucesso! :)");
            }else{
                System.out.println("Falha :(");
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("AnimalDAO.salvar() -> erro SQL");
        }



        return null;
    }

    @Override
    public Animal atualizar(Animal entidade) {
        return null;
    }

    @Override
    public Animal buscarPorID(Integer ID) {
        return null;
    }

    @Override
    public List<Animal> listar() {

        //criando conexao com BD
        String url = "jbdc:sqlite:\\C:\\Users\\Carlos Neres\\IdeaProjects\\petshop\\lib\\sqlite-jdbc-3.32.3.2.jar\\";
        Connection con;
        try {
            con = DriverManager.getConnection(url);
            List<Animal> listaDeAnimais = new ArrayList<>();

            //criando executor e query
            Statement executor = con.createStatement();
            String sql = "select * from animal;";
            ResultSet resultado = executor.executeQuery(sql);

            //populando os objetos

            while (resultado.next()){

                int id = resultado.getInt("idAnimal");
                String apelido = resultado.getString("apelido");
                String cpfDono = resultado.getString("cpfDono");
                String raca = resultado.getString("raca");
                String cor = resultado.getString("cor");

                Animal animal = new Animal(apelido, raca, cor,cpfDono , id);

                listaDeAnimais.add(animal);
            }

            executor.close();
            con.close();

        } catch (SQLException e) {

            System.out.println("AnimalDAO.list() -> erro SQL");

        }

        return null;
    }

    @Override
    public void apagar(Integer id) {

    }
}

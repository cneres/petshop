package com.dao;

import com.model.Animal;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalDAO implements DAO<Animal> {


    @Override
    public Animal salvar(Animal entidade) {
        int idAnimal = 0;
        String apelido = "";
        String cpfDono = "";
        String raca = "";
        String cor = "";

        //criando conexao com BD
        String url = "jdbc:sqlite:C:\\Users\\Carlos Neres\\IdeaProjects\\petshop\\dblite\\banco.db";
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
            executor.close();

        } catch (SQLException e) {
            System.out.println("AnimalDAO.salvar() -> erro SQL");
        }

        return null;
    }

    @Override
    public Animal atualizar(Animal entidade) {

        Scanner leitor = new Scanner(System.in);

        //criando conexao com BD
        String url = "jdbc:sqlite:C:\\Users\\Carlos Neres\\IdeaProjects\\petshop\\dblite\\banco.db";
        Connection con = null;

        System.out.println("Digite o ID do animal desejado");
        int idAlteracao = leitor.nextInt();

        System.out.println("Selecione o campo que deseja alterar");
        System.out.println("1 - Apelido");
        System.out.println("2 - Raça");
        System.out.println("3 - Cor");

        int opcao = leitor.nextInt();

        switch (opcao){

            case 1:

                System.out.println("Digite o novo apelido do animal");
                String novoApelido = leitor.next();

                //alteração no BD


                try {
                //criar e executar query
                String sql = "update animal set apelido = ? where id = ?;";
                PreparedStatement executor = null;

                    executor = con.prepareStatement(sql);

                executor.setString(1, novoApelido);
                executor.setInt(2, idAlteracao);

                int retorno = executor.executeUpdate();


                if (retorno == 1){

                    System.out.println("Sucesso! :)");
                }else{
                    System.out.println("Falha :(");
                }

                    con.close();

                } catch (SQLException e) {
                    System.out.println("AnimalDAO.atualizar() -> erro SQL");
                }
                break;

            case 2:

                System.out.println("Digite a nova raça do animal");
                String novaRaça = leitor.next();

                //alteração no BD


                try {
                    //criar e executar query
                    String sql = "update animal set raca = ? where id = ?;";
                    PreparedStatement executor = null;

                    executor = con.prepareStatement(sql);

                    executor.setString(1, novaRaça);
                    executor.setInt(2, idAlteracao);

                    int retorno = executor.executeUpdate();


                    if (retorno == 1){

                        System.out.println("Sucesso! :)");
                    }else{
                        System.out.println("Falha :(");
                    }

                    con.close();

                } catch (SQLException e) {
                    System.out.println("AnimalDAO.atualizar() -> erro SQL");
                }
                break;

            case 3:
                System.out.println("Digite a nova cor do animal");
                String novaCor = leitor.next();

                //alteração no BD


                try {
                    //criar e executar query
                    String sql = "update animal set cor = ? where id = ?;";
                    PreparedStatement executor = null;

                    executor = con.prepareStatement(sql);

                    executor.setString(1, novaCor);
                    executor.setInt(2, idAlteracao);

                    int retorno = executor.executeUpdate();


                    if (retorno == 1){

                        System.out.println("Sucesso! :)");
                    }else{
                        System.out.println("Falha :(");
                    }

                    con.close();

                } catch (SQLException e) {
                    System.out.println("AnimalDAO.atualizar() -> erro SQL");
                }

                break;

        }


        return null;
    }

    @Override
    public Animal buscarPorID(Integer ID) {
        return null;
    }

    @Override
    public List<Animal> listar() {

        //criando conexao com BD
        String url = "jdbc:sqlite:X:\\Faculdade\\Desenvolvimento de Software I\\petshop\\dblite\\banco.db";

        try {
            Connection con = DriverManager.getConnection(url);


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

                System.out.println(animal);
              }



            executor.close();
            con.close();

           System.out.println("");
        } catch (SQLException e) {

            System.out.println("AnimalDAO.list() -> erro SQL");

        }

        return null;
    }

    @Override
    public void apagar(Integer id) {

        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o ID do animal desejado");
        int idExclusao = leitor.nextInt();

        //criando conexão com o banco de dados
        String url = "jdbc:sqlite:C:\\Users\\Carlos Neres\\IdeaProjects\\petshop\\dblite\\banco.db";
        Connection con = null;
        try {
        String sql = "delete from pessoas where id = ?";
        PreparedStatement executor = null;

            executor = con.prepareStatement(sql);

        executor.setInt(1, idExclusao);

        int retorno = executor.executeUpdate();

            if (retorno == 1){

                System.out.println("Sucesso! :)");
            }else{
                System.out.println("Falha :(");
            }

        executor.close();
        con.close();
        } catch (SQLException e) {
            System.out.println("AnimalDAO.apagar() -> erro SQL");
        }

    }
}

package com.dao;

import com.model.Animal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalDAO implements DAO<Animal> {


    @Override
    public Animal salvar(Animal entidade) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("Digite o apelido do animal");
        String apelido = in.readLine();

        System.out.println("Digite a raça do animal");
        String raca = in.readLine();

        System.out.println("Digite a cor do animal");
        String cor = in.readLine();

        System.out.println("Digite o CPF do responsável pelo animal");
        String cpf = in.readLine();

        //criando conexao com BD
        String url = "jdbc:sqlite:X:\\Faculdade\\Desenvolvimento de Software I\\petshop\\dblite\\banco.db";
        Connection con = null;

        try {
            con = DriverManager.getConnection(url);

            //criando o executor e query
            String sql = "insert into animal (apelido, raca, cor, cpfDono ) values (?, ?, ?, ?);";
            PreparedStatement executor = con.prepareStatement(sql);
            executor.setString(1, apelido);
            executor.setString(2, raca);
            executor.setString(3, cor);
            executor.setString(4, cpf);

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
    public Animal atualizar(Animal entidade) throws IOException {

        Scanner leitor = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        //criando conexao com BD
        String url = "jdbc:sqlite:X:\\Faculdade\\Desenvolvimento de Software I\\petshop\\dblite\\banco.db";
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
                String novoApelido = in.readLine();

                //alteração no BD
                try {
                    con = DriverManager.getConnection(url);
                //criar e executar query
                String sql = "update animal set apelido = ? where idAnimal = ?;";
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
                String novaRaça = in.readLine();

                //alteração no BD


                try {
                    con = DriverManager.getConnection(url);
                    //criar e executar query
                    String sql = "update animal set raca = ? where idAnimal = ?;";
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
                String novaCor = in.readLine();

                //alteração no BD


                try {
                    con = DriverManager.getConnection(url);
                    //criar e executar query
                    String sql = "update animal set cor = ? where idAnimal = ?;";
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


              }

            for ( Animal animal:listaDeAnimais) {
                System.out.println("ID do animal: " + animal.getId() + "  Apelido: " + animal.getApelido() + "    CPF do responsável: " + animal.getCpfDono() + " Raça: " + animal.getRaca() + "  Cor: " + animal.getCor());
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
    public void apagar(Integer id) throws IOException {

        Scanner leitor = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite o ID do pet que deseja excluir");
        int idExclusao = leitor.nextInt();

        //criando conexão com o banco de dados
        String url = "jdbc:sqlite:X:\\Faculdade\\Desenvolvimento de Software I\\petshop\\dblite\\banco.db";

        try {

        Connection con = DriverManager.getConnection(url);
        String sql = "delete from animal where idAnimal = ?";
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

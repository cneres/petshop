package com.dao;

import com.model.Animal;
import com.model.Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteDAO implements DAO<Cliente> {
    @Override
    public Cliente salvar(Cliente entidade) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("Digite o nome do cliente");
        String nome = in.readLine();

        System.out.println("Digite o CPF do cliente");
        String cpf = in.readLine();

        System.out.println("Digite o telefone do cliente");
        String telefone = in.readLine();

        System.out.println("Digite o endereço do cliente");
        String endereco = in.readLine();

        //criando conexao com BD
        String url = "jdbc:sqlite:X:\\Faculdade\\Desenvolvimento de Software I\\petshop\\dblite\\banco.db";
        Connection con = null;

        try{

            con = DriverManager.getConnection(url);

            //criando o executor e query
            String sql = "insert into cliente (cpf, nome, endereco, telefone) values (?, ?, ?, ?)";
            PreparedStatement executor = con.prepareStatement(sql);
            executor.setString(1, cpf);
            executor.setString(2, nome);
            executor.setString(3, endereco);
            executor.setString(4, telefone);

            int retorno = executor.executeUpdate();

            if (retorno == 1){

                System.out.println("Sucesso! :)");
            }else{
                System.out.println("Falha :(");
            }

            con.close();
            executor.close();

        } catch (SQLException e) {
            System.out.println("ClienteDAO.salvar() -> erro SQL");
        }
        return null;
    }

    @Override
    public Cliente atualizar(Cliente entidade) throws IOException {
        Scanner leitor = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //criando conexao com BD
        String url = "jdbc:sqlite:X:\\Faculdade\\Desenvolvimento de Software I\\petshop\\dblite\\banco.db";
        Connection con = null;

        System.out.println("Digite o CPF do cliente desejado");
        String cpf = in.readLine();

        System.out.println("Selecione o campo que deseja alterar");
        System.out.println("1 - Nome");
        System.out.println("2 - CPF");
        System.out.println("3 - Telefone");
        System.out.println("4 - Endereço");
        int opcao = leitor.nextInt();

        switch (opcao){

            case 1:
                System.out.println("Digite o novo nome do cliente");
                String novoNome = in.readLine();

                try {
                    con = DriverManager.getConnection(url);
                    //criar e executar query
                    String sql = "update cliente set nome = ? where cpf = ?;";
                    PreparedStatement executor = null;

                    executor = con.prepareStatement(sql);

                    executor.setString(1, novoNome);
                    executor.setString(2, cpf);

                    int retorno = executor.executeUpdate();


                    if (retorno == 1){

                        System.out.println("Sucesso! :)");
                    }else{
                        System.out.println("Falha :(");
                    }

                    con.close();

                } catch (SQLException e) {
                    System.out.println("ClienteDAO.atualizar.CASE1() -> erro SQL");
                }
                break;

            case 2:

                System.out.println("Digite o novo CPF do cliente");
                String novoCPF = in.readLine();

                try {
                    con = DriverManager.getConnection(url);
                    //criar e executar query
                    String sql = "update cliente set cpf = ? where cpf = ?;";
                    PreparedStatement executor = null;

                    executor = con.prepareStatement(sql);

                    executor.setString(1, novoCPF);
                    executor.setString(2, cpf);

                    int retorno = executor.executeUpdate();


                    if (retorno == 1){

                        System.out.println("Sucesso! :)");
                    }else{
                        System.out.println("Falha :(");
                    }

                    con.close();

                } catch (SQLException e) {
                    System.out.println("ClienteDAO.atualizar.CASE2() -> erro SQL");
                }
                break;
            case 3:
                System.out.println("Digite o novo telefone do cliente");
                String novoTelefone = in.readLine();

                try {
                    con = DriverManager.getConnection(url);
                    //criar e executar query
                    String sql = "update cliente set telefone = ? where cpf = ?;";
                    PreparedStatement executor = null;

                    executor = con.prepareStatement(sql);

                    executor.setString(1, novoTelefone);
                    executor.setString(2, cpf);

                    int retorno = executor.executeUpdate();


                    if (retorno == 1){

                        System.out.println("Sucesso! :)");
                    }else{
                        System.out.println("Falha :(");
                    }

                    con.close();

                } catch (SQLException e) {
                    System.out.println("ClienteDAO.atualizar.CASE3() -> erro SQL");
                }
                break;


            case 4:
                System.out.println("Digite o novo endereço do cliente");
                String novoEndereco = in.readLine();

                try {
                    con = DriverManager.getConnection(url);
                    //criar e executar query
                    String sql = "update cliente set endereco = ? where cpf = ?;";
                    PreparedStatement executor = null;

                    executor = con.prepareStatement(sql);

                    executor.setString(1, novoEndereco);
                    executor.setString(2, cpf);

                    int retorno = executor.executeUpdate();


                    if (retorno == 1){

                        System.out.println("Sucesso! :)");
                    }else{
                        System.out.println("Falha :(");
                    }

                    con.close();

                } catch (SQLException e) {
                    System.out.println("ClienteDAO.atualizar.CASE4() -> erro SQL");
                }

                break;
        }
        return null;
    }

    @Override
    public Cliente buscarPorID(Integer ID) {
        return null;
    }

    @Override
    public List<Cliente> listar() {

        //criando conexao com BD
        String url = "jdbc:sqlite:X:\\Faculdade\\Desenvolvimento de Software I\\petshop\\dblite\\banco.db";

        try {
            Connection con = DriverManager.getConnection(url);

            List<Cliente> listaDeClientes = new ArrayList<>();

            //criando executor e query
            Statement executor = con.createStatement();
            String sql = "select * from cliente;";
            ResultSet resultado = executor.executeQuery(sql);

            //populando os objetos

            while (resultado.next()){


                String cpf = resultado.getString("cpf");
                String nome = resultado.getString("nome");
                String telefone = resultado.getString("telefone");
                String endereco = resultado.getString("endereco");

                Cliente cliente = new Cliente(nome, cpf, telefone, endereco);
                listaDeClientes.add(cliente);
             }

            for ( Cliente cliente: listaDeClientes) {
                System.out.println("Nome do cliente: " + cliente.getNome() + "  CPF: " + cliente.getCpf() + "    Endereço: " + cliente.getEndereço() + " Telefone: " + cliente.getTelefone());
            }

            executor.close();
            con.close();
        } catch (SQLException e) {

            System.out.println("ClienteDAO.list() -> erro SQL");

        }
            return null;
    }

    @Override
    public void apagar(Integer id) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite o CPF do cliente que deseja excluir");
        String cpfExclusao = in.readLine();

        //criando conexão com o banco de dados
        String url = "jdbc:sqlite:X:\\Faculdade\\Desenvolvimento de Software I\\petshop\\dblite\\banco.db";

        try {

            Connection con = DriverManager.getConnection(url);
            String sql = "delete from cliente where cpf = ?";
            PreparedStatement executor = null;

            executor = con.prepareStatement(sql);

            executor.setString(1, cpfExclusao);

            int retorno = executor.executeUpdate();

            if (retorno == 1){

                System.out.println("Sucesso! :)");
            }else{
                System.out.println("Falha :(");
            }

            executor.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("ClienteDAO.apagar() -> erro SQL");
        }
    }
}

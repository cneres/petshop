package com.dao;

import com.model.Cliente;
import com.model.Funcionario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO implements DAO<Funcionario>{
    @Override
    public Funcionario salvar(Funcionario entidade) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Digite o nome do funcionario");
        String nome = in.readLine();

        System.out.println("Digite o CPF do funcionario");
        String cpf = in.readLine();

        System.out.println("Digite o telefone do funcionario");
        String telefone = in.readLine();

        System.out.println("Digite o endereço do funcionario");
        String endereco = in.readLine();

        System.out.println("Digite o cargo do funcionario");
        String cargo = in.readLine();

        //criando conexao com BD
        String url = "jdbc:sqlite:C:\\Users\\Carlos Neres\\Documents\\GitHub\\petshop\\dblite\\banco.db";
        Connection con = null;

        try{

            con = DriverManager.getConnection(url);

            //criando o executor e query
            String sql = "insert into funcionario (cpf, nome, endereco, telefone, cargo) values (?, ?, ?, ?, ?)";
            PreparedStatement executor = con.prepareStatement(sql);
            executor.setString(1, cpf);
            executor.setString(2, nome);
            executor.setString(3, endereco);
            executor.setString(4, telefone);
            executor.setString(5, cargo);

            int retorno = executor.executeUpdate();

            if (retorno == 1){

                System.out.println("Sucesso! :)");
            }else{
                System.out.println("Falha :(");
            }

            con.close();
            executor.close();

        } catch (SQLException e) {
            System.out.println("FuncionarioDAO.salvar() -> erro SQL");
        }

        return null;
    }

    @Override
    public Funcionario atualizar(Funcionario entidade) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //criando conexao com BD
        String url = "jdbc:sqlite:C:\\Users\\Carlos Neres\\Documents\\GitHub\\petshop\\dblite\\banco.db";
        Connection con = null;

        System.out.println("Digite o CPF do funcionario desejado");
        String cpf = in.readLine();

        System.out.println("Selecione o campo que deseja alterar");
        System.out.println("1 - Nome");
        System.out.println("2 - CPF");
        System.out.println("3 - Telefone");
        System.out.println("4 - Endereço");
        System.out.println("5 - Cargo");
        int opcao = in.read();

        switch (opcao){

            case 1:
                System.out.println("Digite o novo nome do funcionario");
                String novoNome = in.readLine();

                try {
                    //criar e executar query
                    String sql = "update funcionario set nome = ? where cpf = ?;";
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
                    System.out.println("FuncionarioDAO.atualizar.CASE1() -> erro SQL");
                }
                break;

            case 2:

                System.out.println("Digite o novo CPF do funcionario");
                String novoCPF = in.readLine();

                try {
                    //criar e executar query
                    String sql = "update funcionario set cpf = ? where cpf = ?;";
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
                    System.out.println("FuncionarioDAO.atualizar.CASE2() -> erro SQL");
                }
                break;
            case 3:
                System.out.println("Digite o novo telefone do funcionario");
                String novoTelefone = in.readLine();

                try {
                    //criar e executar query
                    String sql = "update funcionario set telefone = ? where cpf = ?;";
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
                    System.out.println("FuncionarioDAO.atualizar.CASE3() -> erro SQL");
                }
                break;


            case 4:
                System.out.println("Digite o novo endereço do funcionario");
                String novoEndereco = in.readLine();

                try {
                    //criar e executar query
                    String sql = "update funcionario set endereco = ? where cpf = ?;";
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
                    System.out.println("FuncionarioDAO.atualizar.CASE4() -> erro SQL");
                }

                break;

            case 5:
                System.out.println("Digite o novo cargoo do funcionario");
                String novoCargo = in.readLine();

                try {
                    //criar e executar query
                    String sql = "update funcionario set cargo = ? where cpf = ?;";
                    PreparedStatement executor = null;

                    executor = con.prepareStatement(sql);

                    executor.setString(1, novoCargo);
                    executor.setString(2, cpf);

                    int retorno = executor.executeUpdate();


                    if (retorno == 1){

                        System.out.println("Sucesso! :)");
                    }else{
                        System.out.println("Falha :(");
                    }

                    con.close();

                } catch (SQLException e) {
                    System.out.println("FuncionarioDAO.atualizar.CASE5() -> erro SQL");
                }

                break;
        }
        return null;
    }

    @Override
    public Funcionario buscarPorID(Integer ID) {
        return null;
    }

    @Override
    public List<Funcionario> listar() {

        //criando conexao com BD
        String url = "jdbc:sqlite:C:\\Users\\Carlos Neres\\Documents\\GitHub\\petshop\\dblite\\banco.db";

        try {
            Connection con = DriverManager.getConnection(url);
            List<Funcionario> listaDeFuncionarios = new ArrayList<>();

            //criando executor e query
            Statement executor = con.createStatement();
            String sql = "select * from funcionario;";
            ResultSet resultado = executor.executeQuery(sql);

            //populando os objetos

            while (resultado.next()){


                String cpf = resultado.getString("cpf");
                String nome = resultado.getString("nome");
                String telefone = resultado.getString("telefone");
                String endereco = resultado.getString("endereco");
                String cargo = resultado.getString("cargo");

                Funcionario funcionario = new Funcionario(nome, cpf, telefone, endereco, cargo);
                listaDeFuncionarios.add(funcionario);

            }
            for ( Funcionario funcionario: listaDeFuncionarios) {
                System.out.println("Nome do Funcionario: " + funcionario.getNome() + "  CPF: " + funcionario.getCpf() + "Endereço: " + funcionario.getEndereço() + " Telefone: " + funcionario.getTelefone() + "Cargo: " + funcionario.getCargo());
            }

            executor.close();
            con.close();
        } catch (SQLException e) {

            System.out.println("FuncionarioDAO.list() -> erro SQL");

        }
        return null;
    }

    @Override
    public void apagar(Integer id) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite o CPF do funcionario que deseja excluir");
        String cpfExclusao = in.readLine();

        //criando conexão com o banco de dados
        String url = "jdbc:sqlite:C:\\Users\\Carlos Neres\\Documents\\GitHub\\petshop\\dblite\\banco.db";

        try {

            Connection con = DriverManager.getConnection(url);
            String sql = "delete from funcionario where cpf = ?";
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
            System.out.println("FuncionarioDAO.apagar() -> erro SQL");
        }


    }
}

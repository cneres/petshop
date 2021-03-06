package com.dao;

import com.model.Cliente;
import com.model.Servico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServicoDAO implements DAO<Servico>{
    @Override
    public Servico salvar(Servico entidade) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("Digite o nome do serviço");
        String nome = in.readLine();

        System.out.println("Digite o preço do serviço");
        double preco = in.read();

        System.out.println("Digite a descrição do serviço");
        String descricao = in.readLine();

        //criando conexao com BD
        String url = "jdbc:sqlite:X:\\Faculdade\\Desenvolvimento de Software I\\petshop\\dblite\\banco.db";
        Connection con = null;

        try{

            con = DriverManager.getConnection(url);

            //criando o executor e query
            String sql = "insert into servico (preco, nome, descricao) values (?, ?, ?)";
            PreparedStatement executor = con.prepareStatement(sql);
            executor.setDouble(1, preco);
            executor.setString(2, nome);
            executor.setString(3, descricao);

            int retorno = executor.executeUpdate();

            if (retorno == 1){

                System.out.println("Sucesso! :)");
            }else{
                System.out.println("Falha :(");
            }

            con.close();
            executor.close();

        } catch (SQLException e) {
            System.out.println("ServicoDAO.salvar() -> erro SQL");
        }
        return null;
    }

    @Override
    public Servico atualizar(Servico entidade) throws IOException {

        Scanner leitor = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        //criando conexao com BD
        String url = "jdbc:sqlite:X:\\Faculdade\\Desenvolvimento de Software I\\petshop\\dblite\\banco.db";
        Connection con = null;

        System.out.println("Digite o ID do serviço desejado");
        int ID = leitor.nextInt();

        System.out.println("Selecione o campo que deseja alterar");
        System.out.println("1 - Nome");
        System.out.println("2 - Preço");
        System.out.println("3 - Descrição");
        int opcao = leitor.nextInt();

        switch (opcao){

            case 1:
                System.out.println("Digite o novo nome do serviço");
                String novoNome = in.readLine();

                try {
                    con = DriverManager.getConnection(url);
                    //criar e executar query
                    String sql = "update servico set nome = ? where idServ = ?;";
                    PreparedStatement executor = null;

                    executor = con.prepareStatement(sql);

                    executor.setString(1, novoNome);
                    executor.setInt(2, ID);

                    int retorno = executor.executeUpdate();


                    if (retorno == 1){

                        System.out.println("Sucesso! :)");
                    }else{
                        System.out.println("Falha :(");
                    }

                    con.close();

                } catch (SQLException e) {
                    System.out.println("ServicoDAO.atualizar.CASE1() -> erro SQL");
                }
                break;

            case 2:

                System.out.println("Digite o novo preço do serviço");
                double novoPreco = leitor.nextDouble();

                try {
                    con = DriverManager.getConnection(url);
                    //criar e executar query
                    String sql = "update servico set preco = ? where idServ = ?;";
                    PreparedStatement executor = null;

                    executor = con.prepareStatement(sql);

                    executor.setDouble(1, novoPreco);
                    executor.setInt(2, ID);

                    int retorno = executor.executeUpdate();


                    if (retorno == 1){

                        System.out.println("Sucesso! :)");
                    }else{
                        System.out.println("Falha :(");
                    }

                    con.close();

                } catch (SQLException e) {
                    System.out.println("ServicoDAO.atualizar.CASE2() -> erro SQL");
                }
                break;
            case 3:
                System.out.println("Digite a nova descrição do serviço");
                String novaDescricao = in.readLine();

                try {
                    con = DriverManager.getConnection(url);
                    //criar e executar query
                    String sql = "update servico set descricao = ? where idServ = ?;";
                    PreparedStatement executor = null;

                    executor = con.prepareStatement(sql);

                    executor.setString(1, novaDescricao);
                    executor.setInt(2, ID);

                    int retorno = executor.executeUpdate();


                    if (retorno == 1){

                        System.out.println("Sucesso! :)");
                    }else{
                        System.out.println("Falha :(");
                    }

                    con.close();

                } catch (SQLException e) {
                    System.out.println("ServicoDAO.atualizar.CASE3() -> erro SQL");
                }
                break;
        }

        return null;
    }

    @Override
    public Servico buscarPorID(Integer ID) {
        return null;
    }

    @Override
    public List<Servico> listar() {
        //criando conexao com BD
        String url = "jdbc:sqlite:X:\\Faculdade\\Desenvolvimento de Software I\\petshop\\dblite\\banco.db";

        try {
            Connection con = DriverManager.getConnection(url);


            List<Servico> listaDeServico = new ArrayList<>();


            //criando executor e query
            Statement executor = con.createStatement();
            String sql = "select * from servico;";
            ResultSet resultado = executor.executeQuery(sql);

            //populando os objetos

            while (resultado.next()){

                int id = resultado.getInt("idServ");
                String nome = resultado.getString("nome");
                Double preco = resultado.getDouble("preco");
                String descricao = resultado.getString("descricao");



                Servico servico = new Servico(id, nome, preco, descricao);
                listaDeServico.add(servico);

            }

            for ( Servico servico: listaDeServico) {
                System.out.println("ID do serviço: " + servico.getId() + "  Nome do serviço: " + servico.getNome() + "  Preço: R$ " + servico.getPreço() + "    Descrição: " + servico.getDescricao());
            }

            executor.close();
            con.close();
        } catch (SQLException e) {

            System.out.println("ServicoDAO.list() -> erro SQL");

        }
        return null;
    }

    @Override
    public void apagar(Integer id) throws IOException {


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite o ID do serviço que deseja excluir");
        int idExclusao = in.read();

        //criando conexão com o banco de dados
        String url = "jdbc:sqlite:X:\\Faculdade\\Desenvolvimento de Software I\\petshop\\dblite\\banco.db";

        try {

            Connection con = DriverManager.getConnection(url);
            String sql = "delete from servico where idServ = ?";
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
            System.out.println("ServicoDAO.apagar() -> erro SQL");
        }
    }
}

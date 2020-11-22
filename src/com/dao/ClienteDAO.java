package com.dao;

import com.model.Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ClienteDAO implements DAO<Cliente> {
    @Override
    public Cliente salvar(Cliente entidade) {

        String nome = "";
        String cpf = "";
        String telefone = "";
        String endereco = "";

        //criando conexão com o DB
        String url = "jdbc:sqlite:C:\\Users\\Carlos Neres\\Documents\\GitHub\\petshop\\dblite\\banco.db";
        Connection con = null;

        try {
            con = DriverManager.getConnection(url);
            String sql = "insert into cliente (nome, cpf, telefone, endereco) values (?, ?, ?, ?);";
            PreparedStatement executor = con.prepareStatement(sql);
            executor.setString(1, nome);
            executor.setString(2, cpf);
            executor.setString(3, telefone);
            executor.setString(4, endereco);

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
    public Cliente atualizar(Cliente entidade) {

        Scanner leitor = new Scanner(System.in);

        //criando conexao com BD
        String url = "jdbc:sqlite:C:\\Users\\Carlos Neres\\IdeaProjects\\petshop\\dblite\\banco.db";
        Connection con = null;

        System.out.println("Digite o CPF do cliente desejado");
        int idAlteracao = leitor.nextInt();

        System.out.println("Selecione o campo que deseja alterar");
        System.out.println("1 - Apelido");
        System.out.println("2 - Raça");
        System.out.println("3 - Cor");

        return null;
    }

    @Override
    public Cliente buscarPorID(Integer ID) {
        return null;
    }

    @Override
    public List<Cliente> listar() {
        return null;
    }

    @Override
    public void apagar(Integer id) {

    }
}

package com.dao;

import com.model.Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ClienteDAO implements DAO<Cliente> {
    @Override
    public Cliente salvar(Cliente entidade) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("Digite o nome do cliente");
        String nome = in.readLine();

        System.out.println("Digite o CPF do cliente");
        String raca = in.readLine();

        System.out.println("");
        String cor = in.readLine();
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

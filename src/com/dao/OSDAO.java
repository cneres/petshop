package com.dao;
import com.model.Cliente;
import com.model.OS;
import com.model.Servico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OSDAO implements DAO<OS>{


    @Override
    public OS salvar(OS entidade) throws IOException {

        Scanner leitor = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int repeat = 1;
        int opcao;

        List<Servico> listaDeServicos = new ArrayList<>();

        System.out.println("Digite o ID do pet");
        int idAnimal = leitor.nextInt();

        System.out.println("Digite o CPF do funcionário responsável");
        String cpfFuncionario = in.readLine();

        System.out.println("Digite o status da negociação");
        String status = in.readLine();

        System.out.println("Digite o ID do serviço a ser adicionado");
        int idServico = leitor.nextInt();

        Servico servico = new Servico();
        servico.setId(idServico);

        listaDeServicos.add(servico);
        while (repeat == 1){

            System.out.println("Deseja adicionar mais algum serviço? 1-SIM | 2-NÃO");
            opcao = leitor.nextInt();

            if (opcao == 1)
            {
                System.out.println("Digite o ID do serviço a ser adicionado");
                idServico = leitor.nextInt();
                servico.setId(idServico);
                listaDeServicos.add(servico);
            }
            else {
                repeat = 2;
            }
        }

        //criando conexao com BD
        String url = "jdbc:sqlite:X:\\Faculdade\\Desenvolvimento de Software I\\petshop\\dblite\\banco.db";
        Connection con = null;

        try {
            con = DriverManager.getConnection(url);

            //criando o executor e query
            String sql = "insert into os (idAnimal, cpfFunc, status) values (?, ?, ?);";
            PreparedStatement executor = con.prepareStatement(sql);
            executor.setInt(1, idAnimal);
            executor.setString(2, cpfFuncionario);
            executor.setString(3, status);


            int retorno = executor.executeUpdate();

            if (retorno == 1){

                System.out.println("Sucesso! :)");
            }else{
                System.out.println("Falha :(");
            }

            con.close();
            executor.close();

        } catch (SQLException e) {
            System.out.println("OSDAO.salvar() -> erro SQL");
        }


        try {
            con = DriverManager.getConnection(url);

            Statement executor1 = con.createStatement();
            String sql = "select max(idOs) from os;";
            ResultSet resultado1 = executor1.executeQuery(sql);
            int idOs = resultado1.getInt("max(idOs)");

            System.out.println(idOs);

            for (Servico servico1:listaDeServicos) {
                sql = "insert into osXserv (idServX, idOsX) values (?, ?);";
                PreparedStatement executor2 = con.prepareStatement(sql);
                executor2.setInt(1, servico1.getId());
                executor2.setInt(2, idOs);
                executor2.executeUpdate();
            }


            con.close();
            executor1.close();


        } catch (SQLException e) {
            System.out.println("OSPRODUTODAO.salvar() -> erro SQL");
        }


        return null;
    }

    @Override
    public OS atualizar(OS entidade) {
        return null;
    }

    @Override
    public OS buscarPorID(Integer ID) {
        return null;
    }

    @Override
    public List<OS> listar() {

        //criando conexao com BD
        String url = "jdbc:sqlite:X:\\Faculdade\\Desenvolvimento de Software I\\petshop\\dblite\\banco.db";

        try {
            Connection con = DriverManager.getConnection(url);


            List<OS> listaDeOS = new ArrayList<>();
            List<Servico> listaDeServicos = new ArrayList<>();

            //criando executor e query
            Statement executor = con.createStatement();
            String sql = "select * from os;";

            ResultSet resultado = executor.executeQuery(sql);
            //populando os objetos

            while (resultado.next()){

                int idOs = resultado.getInt("idOs");
                int idAnimal = resultado.getInt("idAnimal");
                String cpfFuncionario = resultado.getString("cpfFunc");
                String status = resultado.getString("status");


                sql = "select idServX from osXserv where idOsX = " + idOs +";";
                ResultSet resultado1 = executor.executeQuery(sql);

                while (resultado1.next()){

                    int idServico = resultado1.getInt("idServX");
                    Servico servico = new Servico();
                    servico.setId(idServico);
                    listaDeServicos.add(servico);
                }

                OS os = new OS(idOs, idAnimal,cpfFuncionario, status, listaDeServicos);
                listaDeOS.add(os);
            }

            for ( OS os: listaDeOS) {
                System.out.print("ID da O.S " + os.getId() + "    ID do animal: " + os.getIdAnimal() + "     CPF funcionario responsável: " + os.getCpfFuncionario() + "     Status da O.S.: " + os.getStatus());
                System.out.print("  ID's de serviços realizados: ");
                for (Servico servico:os.getListaDeServico()) {
                    System.out.print(servico.getId() + " | ");
                }
            }
            System.out.println("");


            executor.close();
            con.close();
        } catch (SQLException e) {

            System.out.println("ClienteDAO.list() -> erro SQL");

        }

        return null;
    }

    @Override
    public void apagar(Integer id) {

    }
}

package com.dao;
import com.model.Cliente;
import com.model.OS;
import com.model.Servico;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OSDAO implements DAO<OS>{


    @Override
    public OS salvar(OS entidade) throws IOException {

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

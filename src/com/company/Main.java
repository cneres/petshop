package com.company;

import com.dao.*;
import com.model.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        //conexao com o banco de dados - exp p/ metodo dps
        //String url = "jdbc:sqlite:localbancodedados";
        //Connection con = DriverManager.getConnection(url);


        int opcaomain;
        int opcao;
        int opcaocrud;
        int repetir = 1;
        Scanner leitor = new Scanner(System.in);

        do {
            System.out.println("Olá, seja bem vindo ao PetShop FishBallCat");
            System.out.println("Selecione o modo de operação do sistema abaixo!");
            System.out.println("1 - Cadastros");
            System.out.println("2 - Ordens de Serviço");
            opcaomain = leitor.nextInt();


            if (opcaomain == 1) {
                System.out.println("Selecione o setor");
                System.out.println("1 - Clientes");
                System.out.println("2 - Funcionarios");
                System.out.println("3 - Animais");
                System.out.println("4 - Serviços");
                opcao = leitor.nextInt();

                System.out.println("Selecione a opção desejada!");
                System.out.println("1 - Visualizar cadastros");
                System.out.println("2 - Alterar cadastros");
                System.out.println("3 - Incluir cadastro");
                System.out.println("4 - Excluir cadastro");
                opcaocrud = leitor.nextInt();


                switch (opcao) {
                    case 1:


                        if (opcaocrud == 1) {

                            Cliente cliente = new Cliente();
                            ClienteDAO ClienteDAO = new ClienteDAO();
                            ClienteDAO.listar();
                        } else if (opcaocrud == 2) {

                            Cliente cliente = new Cliente();
                            ClienteDAO ClienteDAO = new ClienteDAO();
                            ClienteDAO.atualizar(cliente);

                            //alterarCadastroCliente(cpfAlteracao);
                        } else if (opcaocrud == 3) {

                            Cliente cliente = new Cliente();
                            ClienteDAO ClienteDAO = new ClienteDAO();
                            ClienteDAO.salvar(cliente);

                        } else if (opcaocrud == 4) {
                            Cliente cliente = new Cliente();
                            ClienteDAO ClienteDAO = new ClienteDAO();
                            ClienteDAO.apagar(0);
                        }

                        break;

                    case 2:


                        if (opcaocrud == 1) {

                            Funcionario funcionario = new Funcionario();
                            FuncionarioDAO FuncionarioDao = new FuncionarioDAO();
                            FuncionarioDao.listar();
                        } else if (opcaocrud == 2) {

                            Funcionario funcionario = new Funcionario();
                            FuncionarioDAO FuncionarioDao = new FuncionarioDAO();
                            FuncionarioDao.atualizar(funcionario);

                            //alterarCadastro(cpfAlteracao);
                        } else if (opcaocrud == 3) {

                            Funcionario funcionario = new Funcionario();
                            FuncionarioDAO FuncionarioDao = new FuncionarioDAO();
                            FuncionarioDao.salvar(funcionario);

                        } else if (opcaocrud == 4) {
                            Funcionario funcionario = new Funcionario();
                            FuncionarioDAO FuncionarioDao = new FuncionarioDAO();
                            FuncionarioDao.apagar(0);
                        }

                        break;

                    case 3:


                        if (opcaocrud == 1) {

                            AnimalDAO AnimalDAO = new AnimalDAO();
                            AnimalDAO.listar();
                        } else if (opcaocrud == 2) {
                            Animal animal = new Animal();
                            AnimalDAO AnimalDAO = new AnimalDAO();
                            AnimalDAO.atualizar(animal);

                            //alterarCadastro(idAnimal);
                        } else if (opcaocrud == 3) {
                            Animal animal = new Animal();
                            AnimalDAO AnimalDAO = new AnimalDAO();
                            AnimalDAO.salvar(animal);
                            //cadastrarAnimais();

                        } else if (opcaocrud == 4) {
                            AnimalDAO AnimalDAO = new AnimalDAO();
                            AnimalDAO.apagar(0);
                        }

                        break;

                    case 4:


                        if (opcaocrud == 1) {

                            ServicoDAO ServicoDao = new ServicoDAO();
                            ServicoDao.listar();
                        } else if (opcaocrud == 2) {

                            Servico servico = new Servico();
                            ServicoDAO ServicoDao = new ServicoDAO();
                            ServicoDao.atualizar(servico);

                            //alterarCadastro(idAnimal);
                        } else if (opcaocrud == 3) {
                            Servico servico = new Servico();
                            ServicoDAO ServicoDao = new ServicoDAO();
                            ServicoDao.salvar(servico);
                            //cadastrarServico();

                        } else if (opcaocrud == 4) {
                            Servico servico = new Servico();
                            ServicoDAO ServicoDao = new ServicoDAO();
                            ServicoDao.apagar(0);
                            //excluirServico();
                        }

                        break;


                }


            }
             if (opcaomain == 2){

                 System.out.println("Selecione a opção desejada!");
                 System.out.println("1 - Visualizar O.S's");
                 System.out.println("2 - Nova O.S");
                 System.out.println("3 - Excluir O.S");
//                 System.out.println("4 - Alterar O.S's");
                 opcaocrud = leitor.nextInt();

                 switch (opcaocrud) {
                     case 1:

                         OSDAO OSDAO = new OSDAO();
                         OSDAO.listar();
                         break;

                     case 2:

                         OS Os = new OS();
                         OSDAO OSDao = new OSDAO();
                         OSDao.salvar(Os);
                         break;

                     case 3:

                         OSDAO OsDao = new OSDAO();
                         OsDao.apagar(0);
                         break;

//                     case 4:
//
//                         OS os = new OS();
//                         OSDAO osDao = new OSDAO();
//                         osDao.atualizar(os);
//                         break;
                 }

            }
            System.out.println("Deseja continuar usando o sistema? 1-SIM | 2-NÃO");
            repetir = leitor.nextInt();
        } while(repetir == 1);
    }
}

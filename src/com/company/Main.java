package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //conexao com o banco de dados - exp p/ metodo dps
        //String url = "jdbc:sqlite:localbancodedados";
        //Connection con = DriverManager.getConnection(url);


        int opcao;
        int optcrud;
        String rpt = "s";
        Scanner leitor = new Scanner(System.in);

        do {



            System.out.println("Olá, seja bem vindo ao PetShop FishBallCat");
            System.out.println("Selecione o modo de operação do sistema abaixo!");
            System.out.println("1 - Cadastros");
            System.out.println("2 - Ordens de Serviço");
            opcao = leitor.nextInt();


            if (opcao == 1) {
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
                optcrud = leitor.nextInt();


                switch (opcao) {
                    case 1:


                        if (optcrud == 1) {

                            //listarClientes();
                        } else if (optcrud == 2) {

                            System.out.println("Digite o CPF do cliente que deseja alterar");
                            String cpfAlteracao = leitor.next();

                            //alterarCadastroCliente(cpfAlteracao);
                        } else if (optcrud == 3) {

                            //cadastrarClientes();

                        } else if (optcrud == 4) {
                            System.out.println("Digite o CPF do cliente que deseja excluir");
                            //excluirClientes();
                        }

                        break;

                    case 2:


                        if (optcrud == 1) {

                            //listarFuncionarios();
                        } else if (optcrud == 2) {

                            System.out.println("Digite o CPF do funcionario que deseja alterar");
                            String cpfAlteracao = leitor.next();

                            //alterarCadastro(cpfAlteracao);
                        } else if (optcrud == 3) {

                            //cadastrarClientes();

                        } else if (optcrud == 4) {
                            System.out.println("Digite o CPF do cliente que deseja excluir");
                            //excluirClientes();
                        }

                        break;

                    case 3:


                        if (optcrud == 1) {

                            //listarAnimais();
                        } else if (optcrud == 2) {

                            System.out.println("Digite o ID do pet que deseja alterar");
                            int idAnimal = leitor.nextInt();

                            //alterarCadastro(idAnimal);
                        } else if (optcrud == 3) {

                            //cadastrarAnimais();

                        } else if (optcrud == 4) {
                            System.out.println("Digite o ID do pet que deseja excluir");
                            //excluirClientes();
                        }

                        break;

                    case 4:


                        if (optcrud == 1) {

                            //listarServicos();
                        } else if (optcrud == 2) {

                            System.out.println("Digite o ID do serviço que deseja alterar");
                            int idAnimal = leitor.nextInt();

                            //alterarCadastro(idAnimal);
                        } else if (optcrud == 3) {

                            //cadastrarServico();

                        } else if (optcrud == 4) {
                            System.out.println("Digite o ID do serviço que deseja excluir");
                            //excluirServico();
                        }

                        break;


                }


            }
            System.out.println("Deseja continuar usando o sistema? s/n");
        } while(rpt == "s");
    }
}

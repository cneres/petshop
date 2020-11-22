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
        Scanner leitor = new Scanner(System.in);

        do {

            System.out.println("Olá, seja bem vindo ao PetShop FishBallCat");
            System.out.println("Selecione o modo de operação do sistema abaixo!");
            System.out.println("1 - Cadastros");
            System.out.println("2 - Ordens de Serviço");
            opcao = leitor.nextInt();

            if (opcao == 1)
            {
                System.out.println("Selecione o que deseja cadastrar");
                System.out.println("1 - Clientes");
                System.out.println("2 - Funcionarios");
                System.out.println("3 - Animais");
                System.out.println("4 - Serviços");
                opcao = leitor.nextInt();

                switch (opcao){

                    case 1:
                        //cadastroClientes();
                        break;

                    case 2:
                        //cadastroFuncionarios();
                        break;

                    case 3:
                        //cadastroAnimais();
                        break;

                    case 4:
                        //cadastroServiços();
                        break;
                }

            }else if(opcao == 2)
            {
                System.out.println("Selecione o tipo de cadastro que deseja!");
                System.out.println("1 - Clientes");
                System.out.println("2 - Funcionarios");
                System.out.println("3 - Animais");
                System.out.println("4 - Serviços");
                opcao = leitor.nextInt();

                switch (opcao)
                {
                    case 1:
                        System.out.println("Selecione a opção desejada!");
                        System.out.println("1 - Visualizar cadastros");
                        System.out.println("2 - Alterar cadastros");
                        opcao = leitor.nextInt();

                        if (opcao == 1){

                            //listarClientes();
                        }else if(opcao == 2){

                            System.out.println("Digite o CPF do cliente que deseja alterar");
                            String cpfAlteracao = leitor.next();

                            //alterarCadastroCliente(cpfAlteracao);
                        }else {

                            System.out.println("Opção Invalida!");
                        }
                        break;

                    case 2:

                        System.out.println("Selecione a opção desejada!");
                        System.out.println("1 - Visualizar cadastros");
                        System.out.println("2 - Alterar cadastros");
                        opcao = leitor.nextInt();

                        if (opcao == 1)
                        {
                            //listarFuncionarios();
                        }else if (opcao == 2)
                        {
                            System.out.println("Digite o CPF do funcionario que deseja alterar");
                            String cpfAlteracao = leitor.next();

                            //alterarCadastroFuncionario(cpfAlteracao);
                        }else{

                            System.out.println("Opção Invalida!");
                        }

                        break;

                    case 3:

                        System.out.println("Selecione a opção desejada!");
                        System.out.println("1 - Visualizar cadastros");
                        System.out.println("2 - Alterar cadastros");
                        opcao = leitor.nextInt();

                        if (opcao == 1){

                            //listarAnimais();

                        }else if(opcao == 2){

                            System.out.println("Digite o ID do animal que deseja alterar");
                            int IDAlteracao = leitor.nextInt();

                            //alterarCadastroAnimal(IDAlteracao);

                        }else {

                            System.out.println("Opção Invalida!");
                        }

                    break;

                    case 4:
                        System.out.println("Selecione a opção desejada!");
                        System.out.println("1 - Visualizar cadastros");
                        System.out.println("2 - Alterar cadastros");
                        opcao = leitor.nextInt();

                        if (opcao == 1){

                            //listarServiços();
                        }else if(opcao == 2){

                            System.out.println("Digite o ID do serviço que deseja alterar");
                            int IDAlteracao = leitor.nextInt();

                            //alterarCadastroServico(IDAlteracao);
                        }else {

                            System.out.println("Opção Invalida!");
                        }

                    break;


                }


            }


        }while (opcao != 3);

    }
}

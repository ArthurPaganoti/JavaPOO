package BancoArrayList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Scanner para ler os dados do teclado

        Banco banco = new Banco(); // Instanciação do objeto banco

        int menu = 0; // Variavel para o menu

        while (menu != 6) { // Enquanto o número digitado for diferente de 6 o menu vai continuar aparecendo

            // Menu
            System.out.println("1 - Criar conta ");
            System.out.println("2 - Extrato ");
            System.out.println("3 - Sacar ");
            System.out.println("4 - Depositar ");
            System.out.println("5 - Transferir ");
            System.out.println("6 - Sair ");
            menu = sc.nextInt(); // Lendo o número digitado pelo usuário

            Pessoa pessoa = new Pessoa("", "", 0); // Instanciação do objeto pessoa
            Conta conta = new Conta(0, " ", 0); // Instanciação do objeto conta

            switch (menu) { // Switch case para as opções do menu

                case 1: // Caso o usuário digite 1
                    System.out.println("Informe o número da conta: "); // Pede o número da conta
                    int numeroConta = sc.nextInt(); // Lê o número da conta

                    Conta contaExistente = banco.buscaContaExistente(numeroConta); // Verifica se a conta já existe.

                    if (contaExistente != null) { // Se a conta for diferente de null, ou seja, se ela existir
                        System.out.println("Conta já existente!"); // Aparece essa mensagem
                        break; // E o programa para
                    } else { // Se não existir coninua o cadastro
                        // Pede os dados para o cadastro,lê os dados digitados pelo usuário e armazena nas variaveis
                        System.out.println("Informe o nome do titular da conta: ");
                        String nomeTitular = sc.next();
                        System.out.println("Informe o CPF: ");
                        String cpf = sc.next();
                        System.out.println("Informe a idade: ");
                        int idade = sc.nextInt();
                        System.out.println("Informe o saldo inicial: ");
                        double saldo = sc.nextDouble();

                        conta = new Conta(numeroConta, nomeTitular, saldo); // Apartir das informações digitadas pelo usuário, é criado uma conta
                        pessoa = new Pessoa(nomeTitular, cpf, idade);

                        banco.adicionaConta(conta); // Adiciona a conta criada no ArrayList
                        System.out.println("Conta criada com sucesso!"); // Aparece a mensagem de conta criada
                    }
                    break; // Para o programa

                case 2: // Caso o usuário digite 2
                    System.out.println("Informe o número da conta: "); // Pede o número da conta
                    int numeroExtrato = sc.nextInt(); // Lê o número da conta

                    Conta conta1 = banco.buscaContaExistente(numeroExtrato); // Verifica se a conta existe

                    if (conta1 != null) { // Se a conta for diferente de null, ou seja, se ela existir
                        System.out.println("Nome: " + conta1.getNomeTitular()); // Damos um getNomeTitular para pegar o nome do titular da conta
                        System.out.println("Número Conta: " + conta1.getNumeroConta()); // Damos um getNumeroConta para pegar o número da conta
                        System.out.println("Saldo: R$" + conta1.getSaldo()); // Damos um getSaldo para pegar o saldo da conta
                        break; // Para o programa
                    } else { // Se não existir
                        System.out.println("Conta não encontrada!"); // Aparece essa mensagem que a conta não foi encontrada
                    }
                    break; // Para o programa

                case 3: // Caso o usuário digite 3
                    System.out.println("Informe o número da conta: "); // Pede o número da conta
                    int numeroSacar = sc.nextInt(); // Lê o número da conta

                    Conta conta2 = banco.buscaContaExistente(numeroSacar); // Verifica se a conta existe

                    if (conta2 != null) { // Se a conta for diferente de null, ou seja, se ela existir
                        System.out.println("Informe a quantia para o saque: "); // Pede a quantia para o saque
                        double quantiaSaque = sc.nextDouble(); // Lê a quantia para o saque
                        if (conta2.sacar(quantiaSaque)) { // Se a lógica do saque for verdadeira
                            System.out.println("Saque realizado com sucesso!"); // Aparece essa mensagem
                            break; // Para o programa
                        } else { // Se não for verdadeira
                            System.out.println("Falha ao realizar o saque!"); // Aparece essa mensagem
                            break; // Para o programa
                        }
                    } else { // Se a conta não existir
                        System.out.println("Conta não encontrada"); // Aparece essa mensagem
                    }
                    break; // Para o programa

                case 4: // Caso o usuário digite 4
                    System.out.println("Informe o número da conta: "); // Pede o número da conta
                    int numeroDeposito = sc.nextInt(); // Lê o número da conta

                    Conta conta3 = banco.buscaContaExistente(numeroDeposito); // Verifica se a conta existe

                    if (conta3 != null) { // Se a conta for diferente de null, ou seja, se ela existir
                        System.out.println("Informe a quantia para o deposito: "); // Pede a quantia para o deposito
                        double quantiaDeposito = sc.nextDouble(); // Lê a quantia para o deposito
                        if (conta3.depositar(quantiaDeposito)) { // Se a lógica do deposito for verdadeira
                            System.out.println("Deposito feito com sucesso!"); // Aparece essa mensagem
                            break; // Para o programa
                        } else { // Se não for verdadeira
                            System.out.println("Erro no deposito!"); // Aparece essa mensagem
                            break; // Para o programa
                        }
                    } else {  // Se a conta não existir
                        System.out.println("Conta não encontrada"); // Aparece essa mensagem
                    }
                    break; // Para o programa

                case 5: // Caso o usuário digite 5
                    System.out.println("Informe o número da conta: "); // Pede o número da conta
                    int numeroTransferencia = sc.nextInt(); // Lê o número da conta

                    Conta conta4 = banco.buscaContaExistente(numeroTransferencia); // Verifica se a conta existe

                    if (conta4 != null) { // Se a conta que for transferir for diferente de null, ou seja, se ela existir
                        System.out.println("Informe a conta destino: "); // Pede a conta destino
                        int numeroDestino = sc.nextInt(); // Lê a conta destino
                        Conta conta5 = banco.buscaContaExistente(numeroDestino); // Verifica se a conta destino existe
                        if (conta5 != null) { // Se a conta destino for diferente de null, ou seja, se ela existir
                            System.out.println("Informe a quantia para transferir: "); // Pede a quantia para transferir
                            double quantiaTransferencia = sc.nextDouble(); // Lê a quantia para transferir
                            if (conta4.transferir(conta5, quantiaTransferencia)) { // Se a lógica da transferencia for verdadeira
                                System.out.println("Transferencia realizada com sucesso!"); // Aparece essa mensagem
                                break; // Para o programa
                            } else {
                                System.out.println("Erro na transferencia"); // Aparece essa mensagem
                                break; // Para o programa
                            }
                        } else { // Se a conta destino não existir
                            System.out.println("Conta destino não encontrada");
                            break;
                        }
                    } else { // Se a conta que for transferir não existir
                        System.out.println("Conta não encontrada");

                    }
                    break;

                case 6: // Caso o usuário digite 6 (Opção sair)
                    System.out.println("Saindo...");
                    break;

                default: // Caso o usuário digite um número diferente das opções do menu
                    System.out.println("Nenhuma das opções é valida");
                    break;
            }
        }
    }
}
package ExercicioBanco;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US); // Para o programa aceitar o ponto ao invés da vírgula
        Scanner sc = new Scanner(System.in); // Para ler os dados digitados pelo usuário

        ContaCorrente contaCorrente = new ContaCorrente(); // Instanciando a classe ContaCorrente

        int menu = 0; // Variável para o menu

        while (menu != 5) { // Enquanto o menu for diferente de 5, execute o código abaixo

            // Menu de opções
            System.out.println("1- Criar conta");
            System.out.println("2- Depositar");
            System.out.println("3- Sacar");
            System.out.println("4- Transferir");
            System.out.println("5- Sair");
            menu = sc.nextInt(); // Lendo a opção escolhida pelo usuário

            switch (menu) { // Switch para as opções do menu

                case 1: // Caso a opção escolhida seja 1, execute o código abaixo
                    System.out.println("Digite o número da conta: ");
                    int numeroConta = sc.nextInt(); // Lendo o número da conta
                    System.out.println("Digite o nome do titular da conta: ");
                    String nomeTitular = sc.next(); // Lendo o nome do titular da conta
                    System.out.println("Deseja fazer um depósito inicial? (s/n)");
                    char resposta = sc.next().charAt(0); // Lendo a resposta do usuário

                    if (resposta == 's') { // Se a resposta for 's', execute o código abaixo
                        System.out.println("Digite o valor do depósito inicial: ");
                        double depositoInicial = sc.nextDouble(); // Lendo o valor do depósito inicial
                        contaCorrente.depositar(depositoInicial); // Chamando o método depositar e passando o valor do depósito inicial
                        System.out.println("Conta criada com sucesso!");
                    } else {
                        System.out.println("Conta criada com sucesso!");
                    }
                    break; // Quebra o switch

                    case 2: // Caso a opção escolhida seja 2, execute o código abaixo
                        System.out.println("Digite o valor do depósito: ");
                        double deposito = sc.nextDouble(); // Lendo o valor do depósito
                        if (contaCorrente.depositar(deposito)) { // Se o método depositar funcionar
                            System.out.println("Depósito realizado com sucesso!");
                            System.out.println("Saldo atual: R$" + contaCorrente.saldo);
                        } else {
                            System.out.println("Erro no deposito!");
                        }
                        break;

                case 3:
                    System.out.println("Informe a quantia que deseja sacar: ");
                    double quantiaSaque = sc.nextDouble(); // Lendo a quantia que deseja sacar
                    if (contaCorrente.sacar(quantiaSaque)) { // Se o método sacar funcionar
                        System.out.println("Saque realizado com sucesso: ");
                        System.out.println("Saldo atual: R$" + contaCorrente.saldo);
                    } else {
                        System.out.println("Erro no saque!");
                    }
                    break;

                case 4:
                    System.out.println("Informe o número da conta de destino: ");
                    contaCorrente.numeroConta = sc.nextInt(); // Lendo o número da conta de destino
                    System.out.println("Informe o valor da transferência: ");
                    double quantia = sc.nextDouble(); // Lendo o valor da transferência
                    if (contaCorrente.transferir(contaCorrente, quantia)) { // Se o método transferir funcionar
                        System.out.println("Transferência realizada com sucesso!");
                        System.out.println("Saldo atual: R$" + contaCorrente.saldo);
                    } else {
                        System.out.println("Erro na transferência!");
                    }
                    break;

                    case 5:
                        System.out.println("Saindo..."); // Caso a opção escolhida seja 5, execute o código abaixo
                        break;

                default:
                    System.out.println("Opção inválida!");  // Caso a opção escolhida seja diferente das opções acima, execute o código abaixo
                    break;
            }
        }

    }
}
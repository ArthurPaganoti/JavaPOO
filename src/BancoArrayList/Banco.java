package BancoArrayList;

import java.util.ArrayList;

class Banco {

    ArrayList<Conta> contas = new ArrayList<Conta>(); // Criando um ArrayList com a classe conta

    public void adicionaConta(Conta conta) { // Método para adicionar uma conta no ArrayList que recebe um objeto do tipo Conta
        contas.add(conta); // Adicionando a conta no ArrayList
    }

    public void removeConta(Conta conta) { // Método para remover uma conta no ArrayList que recebe um objeto do tipo Conta
        contas.remove(conta); // Removendo a conta no ArrayList
    }

    public Conta buscaContaExistente(int numeroConta) { // Método para buscar uma conta no ArrayList que recebe um número de conta
        for (int i = 0; i < contas.size(); i++) { // Laço de repetição para percorrer o ArrayList
            if (contas.get(i).getNumeroConta() == numeroConta) { // Verificando se o número da conta é igual ao número da conta passado como parâmetro
                return contas.get(i); // Retornando a conta
            }
        }
        return null; // Retornando null caso não encontre a conta
    }
}
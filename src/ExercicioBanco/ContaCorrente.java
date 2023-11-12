package ExercicioBanco;

public class ContaCorrente {

    // Alguns atributos da classe ContaCorrente
    int numeroConta;
    String nomeTitular;
    double saldo;

    // Método para sacar
    public boolean sacar (double quantiaSaque) { // Passado o paramêtro quantiaSaque
        if (quantiaSaque > 0 && saldo >= quantiaSaque) { // Se quantiaSaque for mairo que 0 e saldo maior igual a quantia
            saldo -= quantiaSaque; // Pega o saldo atual da conta e subtrai com o valor da quantiaSaque
            return true; // Retorna true caso tenha ocorrido com sucesso
        }
        return false; // Se não  retorna que a operação deu false
    }

    // Método depositar
    public boolean depositar(double quantiaDeposito) { // Passado o paramêtro quantiaDeposito
        if (quantiaDeposito > 0) { // Se a quantiaDeposito for maior que 0
            saldo += quantiaDeposito; // Pega o saldo atual da conta e soma com quantiaDeposito
        }
        return false;
    }

    // Método transferir
    public boolean transferir(ContaCorrente contaDestino, double quantia) { // Criando um novo objeto Conta e a quantia da transferencia
        if (contaDestino != null ) { // Se a contaDestino for diferente de null (se ela existir0
            if (sacar(quantia)) { // Se a mesma lógica do sacar funcionar no quantia
                contaDestino.depositar(quantia); // Depositamos o valor na contaDestino
                return true; // Retornamos true caso tenha dado certo
            }
        }
        return false; // Se não retornamos false
    }
}
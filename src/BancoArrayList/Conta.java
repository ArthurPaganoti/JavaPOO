package BancoArrayList;

class Conta {

    // Atributos da classe conta
    int numeroConta;

    String nomeTitular;
    double saldo;

    public Conta(int numeroConta, String nomeTitular, double saldo) { // Construtor da classe conta
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
    }

    // Getters e setters da classe conta
    // Obs: Não colocamos o setter para o saldo, pois o saldo só pode ser alterado através de saques e depósitos
    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean sacar(double quantiaSaque) { // Método sacar que recebe a quantia do saque
        if (quantiaSaque > 0 && this.saldo >= quantiaSaque) { // Verifica se a quantia do saque é maior que 0 e se o saldo é maior ou igual a quantia do saque
            this.saldo -= quantiaSaque; // Se for, o saldo é decrementado pela quantia do saque
            return true; // Retorna true
        }
        return false; // Caso contrário, retorna false
    }

    public boolean depositar(double quantiaDeposito) { // Método depositar que recebe a quantia do depósito
        if (quantiaDeposito > 0) { // Verifica se a quantia do depósito é maior que 0
            this.saldo += quantiaDeposito; // Se for, o saldo é incrementado pela quantia do depósito
            return true; // Retorna true
        }
        return false; // Caso contrário, retorna false
    }

    public boolean transferir(Conta contaDestino, double quantiaTransferencia) { // Método transferir que recebe a conta de destino e a quantia da transferência
        if (contaDestino != null) { // Verifica se a conta de destino é diferente de null
            if (sacar(quantiaTransferencia)) { // Chama o método sacar passando a quantia da transferência
                contaDestino.depositar(quantiaTransferencia); // Chama o método depositar da conta de destino passando a quantia da transferência
                return true; // Retorna true
            }
        }
        return false; // Caso contrário, retorna false
    }
}

package BancoArrayList;

class Pessoa {

    // Atributos de Pessoa
    String nomePessoa;

    String cpfPessoa;

    int idade;

    public Pessoa(String nomePessoa, String cpfPessoa, int idade) { // Construtor de Pessoa
        this.nomePessoa = nomePessoa;
        this.cpfPessoa = cpfPessoa;
        this.idade = idade;
    }

    // Getters e SettersS
    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}

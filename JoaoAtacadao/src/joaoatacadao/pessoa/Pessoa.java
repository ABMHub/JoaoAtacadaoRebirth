package joaoatacadao.pessoa;

public abstract class Pessoa {
    protected String nome;
    protected String dataNascimento;
    protected String cpf;
    
    public Pessoa(String nome, String dataNascimento, String cpf){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Override
    public String toString() {
        return "Nome: " + nome + ",\nData de Nascimento: " + dataNascimento + ",\nCPF: " + cpf;
    }
}

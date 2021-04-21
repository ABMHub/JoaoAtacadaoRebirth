package joaoatacadao.pessoa;

public class Funcionario extends Pessoa {
    protected double salario;

    public Funcionario(String nome, String dataNascimento, String cpf, double salario) {
        super(nome, dataNascimento, cpf);
        this.salario = salario;
    }
    
    public static Funcionario instanciarFuncionario (String[] dados) {
        return new Funcionario(dados[1], dados[2], dados[0], Float.parseFloat(dados[3]));
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    @Override
    public String toString() {
        return super.toString() + ",\nSalário: " + salario;
    }
}

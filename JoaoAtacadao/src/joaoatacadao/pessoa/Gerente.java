package joaoatacadao.pessoa;

import java.util.Date;

public class Gerente extends Funcionario {
    private String senhaGerente;

    public Gerente(String nome, String dataNascimento, long cpf, 
                    double salario, String senhaGerente){
        super(nome, dataNascimento, cpf, salario);
        this.senhaGerente = senhaGerente;
    }

    public static Gerente instanciaGerente(String[] dados) {
        return new Gerente(dados[1], dados[2], Long.parseLong(dados[0]), Float.parseFloat(dados[3]), dados[4]);
    }
    
    public boolean isSenha (String senha) {
        return senha.equals(this.senhaGerente);
    }
    
    public String getSenhaGerente() {
        return senhaGerente;
    }

    public void setSenhaGerente(String senhaGerente) {
        this.senhaGerente = senhaGerente;
    }
    
    @Override
    public String toString() {
        return super.toString() + ",\nSenha do Gerente: " + senhaGerente;
    }
}

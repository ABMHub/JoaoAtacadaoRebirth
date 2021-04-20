package joaoatacadao.pessoa;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import joaoatacadao.BancoDeDados;

public class Cliente extends Pessoa {
    private double saldoEmConta;
    private String senhaCartaoFidelidade;

    public Cliente(String nome, String dataNascimento, long cpf, 
                   double saldoEmConta, String senhaCartaoFidelidade) {
        super(nome, dataNascimento, cpf);
        this.saldoEmConta = saldoEmConta;
        this.senhaCartaoFidelidade = senhaCartaoFidelidade;
    }
    
    public boolean pagar (String senha, float total) {
        if (senha == null)
            return false;
        if (senha.equals(this.getSenhaCartaoFidelidade())) {
            if (this.saldoEmConta >= total) {
                this.saldoEmConta = (float) this.saldoEmConta - total; 
                String dado = "CPF:" + this.cpf + ",\nNome:" + this.nome
                    + ",\nData de Nascimento:" + this.dataNascimento + ",\nSenha:" + this.senhaCartaoFidelidade
                    + ",\nSaldo:" + this.saldoEmConta + ";";
               
                try {
                    BancoDeDados.editar("dados/cadastrarCliente.txt", Long.toString(this.cpf), dado);
                    JOptionPane.showMessageDialog(null, "Saldo antigo: " + (this.saldoEmConta + total) +
                            "\nValor cobrado: " + total + "\nValor atual: " +
                            this.saldoEmConta, "Aviso", JOptionPane.WARNING_MESSAGE);
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                           
            }
            else {
                JOptionPane.showMessageDialog(null, "Você não tem saldo suficiente!", "Aviso", JOptionPane.WARNING_MESSAGE);
                return false;
            }                 
        }
        
        else {
            JOptionPane.showMessageDialog(null, "Senha incorreta!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        return true;
    }

    public boolean ehAniversario (){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data = sdf.format(new Date());

        this.dataNascimento = this.dataNascimento.substring(0, 5);
        data = data.substring(0, 5);

        if(data.equals(this.dataNascimento))
            return true;
        
        return false;
    }
    
    //Um cliente é instanciado para que ele possa efetuar o pagamento 
    public static Cliente instanciarCliente (String[] dados) {
        return new Cliente(dados[1], dados[2], Long.parseLong(dados[0]), Float.parseFloat(dados[4]), dados[3]);
    }
    
    public double getSaldoEmConta() {
        return saldoEmConta;
    }

    public String getSenhaCartaoFidelidade() {
        return senhaCartaoFidelidade;
    }

    public void setSaldoEmConta(double saldoEmConta) {
        this.saldoEmConta = saldoEmConta;
    }

    public void setSenhaCartaoFidelidade(String senhaCartaoFidelidade) {
        this.senhaCartaoFidelidade = senhaCartaoFidelidade;
    }
    
    @Override
    public String toString() {
        return super.toString() + ",\nSaldo em Conta: " + saldoEmConta + ",\nSenha do Cartão Fidelidade: " + senhaCartaoFidelidade;
    }
}

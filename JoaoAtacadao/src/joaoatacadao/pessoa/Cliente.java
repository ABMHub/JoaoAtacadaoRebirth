package joaoatacadao.pessoa;

import camadaDePersistencia.Conexao;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Cliente extends Pessoa {
    private double saldoEmConta;
    private String senhaCartaoFidelidade;

    public Cliente(String nome, String dataNascimento, String cpf, 
                   double saldoEmConta, String senhaCartaoFidelidade) {
        super(nome, dataNascimento, cpf);
        this.saldoEmConta = saldoEmConta;
        this.senhaCartaoFidelidade = senhaCartaoFidelidade;
    }
    
    public boolean pagar (String senha, float total) {
        if (senha == null)
            return false;
        
        // System.out.println(senha + " =? " + this.getSenhaCartaoFidelidade());
        
        if (senha.equals(this.getSenhaCartaoFidelidade())) {
            if (this.saldoEmConta >= total) {
                this.saldoEmConta = (float) this.saldoEmConta - total;    
                Conexao.update("cliente", "saldo = " + Double.toString(this.saldoEmConta), "cpf = '" + this.cpf + "'");
                
                JOptionPane.showMessageDialog(null, "Saldo antigo: " + (this.saldoEmConta + total) +
                        "\nValor cobrado: " + total + "\nValor atual: " +
                        this.saldoEmConta, "Aviso", JOptionPane.WARNING_MESSAGE);
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String data = sdf.format(new Date());

        String datanac = this.dataNascimento.substring(5, 10);
        data = data.substring(5, 10);
        
        if(data.equals(datanac))
            return true;
        
        return false;
    }
    
    //Um cliente é instanciado para que ele possa efetuar o pagamento 
    public static Cliente instanciarCliente (String[] dados) {
        return new Cliente(dados[1], dados[2], dados[0], Float.parseFloat(dados[3]), dados[4]);
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

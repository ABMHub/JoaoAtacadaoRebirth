/*
 Classe responsável por efetuar o cadastro de um cliente no banco de dados adequado.
 */
package telas;

import camadaDePersistencia.Conexao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static joaoatacadao.BancoDeDados.escritor;
import static joaoatacadao.Validacao.ehInteiro;


/**
 *
 * @author João Víctor
 */
public class CadastrarCliente extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarCliente
     */
    public CadastrarCliente() {
        initComponents();
        setResizable(false); // maximize button disable
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCadastrarCliente = new javax.swing.JPanel();
        pnlDadosCliente = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblDataNascimento = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtDataNascimento = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        pnlCartaoFidelidade = new javax.swing.JPanel();
        lblLimiteCartao = new javax.swing.JLabel();
        lblSenhaCartao = new javax.swing.JLabel();
        txtLimiteCartao = new javax.swing.JTextField();
        pswSenhaCartao = new javax.swing.JPasswordField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cliente");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/cliente2.png")).getImage());

        pnlCadastrarCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastrar Cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        pnlDadosCliente.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lblNome.setText("Nome:");

        lblDataNascimento.setText("Data de Nascimento:");

        lblCpf.setText("CPF:");

        javax.swing.GroupLayout pnlDadosClienteLayout = new javax.swing.GroupLayout(pnlDadosCliente);
        pnlDadosCliente.setLayout(pnlDadosClienteLayout);
        pnlDadosClienteLayout.setHorizontalGroup(
            pnlDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtDataNascimento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                        .addComponent(txtCpf, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        pnlDadosClienteLayout.setVerticalGroup(
            pnlDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDadosClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        txtNome.getAccessibleContext().setAccessibleName("");
        txtNome.getAccessibleContext().setAccessibleDescription("");
        txtDataNascimento.getAccessibleContext().setAccessibleDescription("");
        txtCpf.getAccessibleContext().setAccessibleDescription("");

        pnlCartaoFidelidade.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cartão Fidelidade", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lblLimiteCartao.setText("Limite:");

        lblSenhaCartao.setText("Senha do Cartão:");

        javax.swing.GroupLayout pnlCartaoFidelidadeLayout = new javax.swing.GroupLayout(pnlCartaoFidelidade);
        pnlCartaoFidelidade.setLayout(pnlCartaoFidelidadeLayout);
        pnlCartaoFidelidadeLayout.setHorizontalGroup(
            pnlCartaoFidelidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCartaoFidelidadeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCartaoFidelidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSenhaCartao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLimiteCartao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(pnlCartaoFidelidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLimiteCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pswSenhaCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCartaoFidelidadeLayout.setVerticalGroup(
            pnlCartaoFidelidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCartaoFidelidadeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCartaoFidelidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLimiteCartao)
                    .addComponent(txtLimiteCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCartaoFidelidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenhaCartao)
                    .addComponent(pswSenhaCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        txtLimiteCartao.getAccessibleContext().setAccessibleDescription("");

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar1.png"))); // NOI18N
        btnSalvar.setMnemonic('S');
        btnSalvar.setText("Salvar");
        btnSalvar.setToolTipText("Salva o cadastro do Cliente");
        btnSalvar.setFocusPainted(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar2.png"))); // NOI18N
        btnCancelar.setMnemonic('C');
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancela o cadastro");
        btnCancelar.setFocusPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCadastrarClienteLayout = new javax.swing.GroupLayout(pnlCadastrarCliente);
        pnlCadastrarCliente.setLayout(pnlCadastrarClienteLayout);
        pnlCadastrarClienteLayout.setHorizontalGroup(
            pnlCadastrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastrarClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCartaoFidelidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlCadastrarClienteLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(86, 86, 86))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadastrarClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDadosCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCadastrarClienteLayout.setVerticalGroup(
            pnlCadastrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastrarClienteLayout.createSequentialGroup()
                .addComponent(pnlDadosCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCartaoFidelidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCadastrarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCadastrarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    /*
    Após a verificação de que todos os campos foram devidamente preenchidos, os dados são salvos
    no banco de dados e em seguida os campos são esvaziados.
    */
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String senha = new String(pswSenhaCartao.getPassword()).trim();
        
        if(txtNome.getText().equals("") || txtDataNascimento.getText().equals("") 
                || txtCpf.getText().equals("") || txtLimiteCartao.getText().equals("") 
                || pswSenhaCartao.getPassword().equals("") || senha.equals(""))
            JOptionPane.showMessageDialog(null, "Todos os dados devem ser inseridos!!!", "Aviso", JOptionPane.WARNING_MESSAGE);
        
        else if(!ehInteiro(txtCpf.getText()))
            JOptionPane.showMessageDialog(null, "O CPF deve ser um número inteiro positivo!", "Aviso", JOptionPane.WARNING_MESSAGE);
        
        else
        {
            String temp = "";
            
            temp += "'" + txtCpf.getText() + "'";
            temp += ", '" + txtNome.getText() + "'";
            temp += ", '" + txtDataNascimento.getText() + "'";
            temp += ", '" + senha + "'";
            temp += ", " + txtLimiteCartao.getText();

            System.out.println(temp);
            
            Conexao.create("cliente", temp);
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            txtCpf.setText("");
            txtNome.setText("");
            txtDataNascimento.setText("");
            txtLimiteCartao.setText("");
            pswSenhaCartao.setText("");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblLimiteCartao;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenhaCartao;
    private javax.swing.JPanel pnlCadastrarCliente;
    private javax.swing.JPanel pnlCartaoFidelidade;
    private javax.swing.JPanel pnlDadosCliente;
    private javax.swing.JPasswordField pswSenhaCartao;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtDataNascimento;
    private javax.swing.JTextField txtLimiteCartao;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}

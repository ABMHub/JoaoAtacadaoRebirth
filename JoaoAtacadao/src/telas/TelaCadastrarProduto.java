/*
 
Classe responsável por ler os dados referentes aos produtos e adicioná-los em seu respectivo banco de 
dados, note que cada tipo de produto (periférico, livro, etc) é salvo em um banco de dados próprio.
Portanto, cada código de barras deve seguir um padrão que pode ser visto no switch case. O código
de barras de um livro por exemplo necessariamente precisa começar com G.


*/
package telas;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static joaoatacadao.BancoDeDados.escritor;
import static joaoatacadao.Validacao.ehFlutuante;
import static joaoatacadao.Validacao.ehInteiro;

public class TelaCadastrarProduto extends javax.swing.JFrame {
    private String menu;
   
    public TelaCadastrarProduto(){
        initComponents();
        setResizable(false); // maximize button disable
    }
    
    //Construtor que inicializa cada label com o nome adequado e oculta as que não são necessárias
    public TelaCadastrarProduto(String menu) {
        initComponents();
        this.menu = menu;
        
        switch(menu){
            case "livros":
                jLabel5.setText("Faixa Etária:");
                jLabel6.setText("Tema:");
                jLabel7.setText("Autor:");
                jLabel8.setText("Editora:");
                jLabel9.setText("Quantidade de Páginas:");
                jLabel10.setText("ISBN:");
                rdbSim.setVisible(false);
                rdbNao.setVisible(false);
                jLabel11.setText("");
                
            break;
                
            case "filmes":
                jLabel5.setText("Faixa Etária:");
                jLabel6.setText("Tema:");
                jLabel7.setText("Diretor:");
                jLabel8.setText("Duração:");
                jLabel9.setText("");
                jTextField9.setVisible(false);
                jLabel10.setText("");
                jTextField10.setVisible(false);
                rdbSim.setVisible(false);
                rdbNao.setVisible(false);
                jLabel11.setText("");
                
            break;
                
            case "perifericos":
                jLabel5.setText("Cor:");
                jLabel6.setText("Modelo:");
                jLabel7.setText("Tipo:");
                jLabel8.setText("Padrão de Entrada:");
                jLabel9.setText("");
                jTextField9.setVisible(false);
                jLabel10.setText("");
                jTextField10.setVisible(false);
                rdbSim.setVisible(false);
                rdbNao.setVisible(false);
                jLabel11.setText("");
                
            break;
                
            case "celulares":
                jLabel5.setText("Cor:");
                jLabel6.setText("Modelo:");
                jLabel7.setText("Tamanho da tela:");
                jLabel8.setText("Memória:");
                jLabel9.setText("Processador:");
                jLabel10.setText("Câmera:");
                rdbSim.setVisible(false);
                rdbNao.setVisible(false);
                jLabel11.setText("");
                
            break;
                
            case "computadores":
                jLabel5.setText("Cor:");
                jLabel6.setText("Modelo:");
                jLabel7.setText("Processador:");
                jLabel8.setText("GPU:");
                jLabel9.setText("Memória:");
                jLabel10.setText("Fonte:");;
                rdbSim.setVisible(true);
                rdbNao.setVisible(true);
                jLabel11.setText("RGB:");
                
            break;
                
            case "eletroeletronicos":
                jLabel5.setText("Consumo de Energia:");
                jLabel6.setText("Potência:");
                jLabel7.setText("");
                jTextField7.setVisible(false);
                jLabel8.setText("");
                jTextField8.setVisible(false);
                jLabel9.setText("");
                jTextField9.setVisible(false);
                jLabel10.setText("");
                jTextField10.setVisible(false);
                rdbSim.setVisible(true);
                rdbNao.setVisible(true);
                jLabel11.setText("Smart:");
                
            break;
                
            case "vestuario":
                jLabel5.setText("Tamanho:");
                jLabel6.setText("Cor:");
                jLabel7.setText("Material:");
                jLabel8.setText("");
                jTextField8.setVisible(false);
                jLabel9.setText("");
                jTextField9.setVisible(false);
                jLabel10.setText("");
                jTextField10.setVisible(false);
                rdbSim.setVisible(false);
                rdbNao.setVisible(false);
                jLabel11.setText("");
                
            break;
                
            default:
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupo = new javax.swing.ButtonGroup();
        pnlDadosProduto = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        rdbSim = new javax.swing.JRadioButton();
        rdbNao = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produto");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/cadastro1.png")).getImage());

        pnlDadosProduto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Produto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("Nome:");

        jLabel2.setText("Código de Barras:");

        jLabel3.setText("Preço:");

        jLabel4.setText("Marca:");

        jLabel5.setText("jLabe5:");

        jLabel6.setText("jLabel6:");

        jLabel7.setText("jLabel7:");

        jLabel8.setText("jLabel8:");

        jLabel9.setText("jLabel9:");

        jLabel10.setText("jLabel10:");

        jTextField1.setName("Teste"); // NOI18N

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar1.png"))); // NOI18N
        btnSalvar.setMnemonic('S');
        btnSalvar.setText("Salvar");
        btnSalvar.setFocusPainted(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar2.png"))); // NOI18N
        btnCancelar.setMnemonic('C');
        btnCancelar.setText("Cancelar");
        btnCancelar.setFocusPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel11.setText("jLabel11");

        btnGrupo.add(rdbSim);
        rdbSim.setText("Sim");

        btnGrupo.add(rdbNao);
        rdbNao.setSelected(true);
        rdbNao.setText("Não");

        javax.swing.GroupLayout pnlDadosProdutoLayout = new javax.swing.GroupLayout(pnlDadosProduto);
        pnlDadosProduto.setLayout(pnlDadosProdutoLayout);
        pnlDadosProdutoLayout.setHorizontalGroup(
            pnlDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosProdutoLayout.createSequentialGroup()
                .addGroup(pnlDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosProdutoLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(29, 29, 29))
                    .addGroup(pnlDadosProdutoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4)
                            .addComponent(jTextField5)
                            .addComponent(jTextField6)
                            .addComponent(jTextField7)
                            .addComponent(jTextField8)
                            .addComponent(jTextField9)
                            .addComponent(jTextField10)
                            .addGroup(pnlDadosProdutoLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(rdbSim)
                                .addGap(29, 29, 29)
                                .addComponent(rdbNao)
                                .addGap(0, 29, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        pnlDadosProdutoLayout.setVerticalGroup(
            pnlDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosProdutoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdbSim)
                        .addComponent(rdbNao)))
                .addGap(18, 18, 18)
                .addGroup(pnlDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(pnlDadosProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDadosProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDadosProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    //Método que efetivamente lê os dados da interface gráfica e os salva no banco de dados.
    //Aqui são chamados métodos estáticos da classe validação para garantir que os números digitados
    //pelo usuário sejam de fato números (inteiros ou reais de acordo com a situação) e sempre positivos.
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String temp = "";
        boolean erro = false;
        if(!ehFlutuante(jTextField3.getText()))
        {
            JOptionPane.showMessageDialog(null, "O preço deve ser um número real!", "Aviso", JOptionPane.WARNING_MESSAGE);
            erro = true;
        }
        temp  = "Código:" + jTextField2.getText();
        temp += ",\nNome:" + jTextField1.getText();        
        temp += ",\nValor:" + jTextField3.getText();
        temp += ",\nMarca:" + jTextField4.getText();

        switch(menu)
        {
            case "livros":  
               
                temp += ",\nFaixa Etária:" + jTextField5.getText();
                temp += ",\nTema:" + jTextField6.getText();
                
                temp +=  ",\nAutor:" + jTextField7.getText();
                temp += ",\nEditora:" + jTextField8.getText();
                temp += ",\nQuantidade de Páginas:" + jTextField9.getText();
                
                if(!ehInteiro(jTextField9.getText()))
                {
                    JOptionPane.showMessageDialog(null, "A quantidade de páginas deve ser um número inteiro positivo!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    erro = true;
                }
                
                    
                temp += ",\nISBN:" + jTextField10.getText() + ";\n\n";

            break;
            
            case "filmes":
                
                temp += ",\nFaixa Etária:" + jTextField5.getText();
                temp += ",\nTema:" + jTextField6.getText();
                
                temp +=  "\nDiretor:" + jTextField7.getText();
                temp += ",\nDuração:" + jTextField8.getText() + ";\n\n";
                
                if(!ehInteiro(jTextField8.getText()))
                {
                    JOptionPane.showMessageDialog(null, "A duração deve ser um número inteiro positivo!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    erro = true;
                }

            break;
            
            case "perifericos":
                temp += ",\nCor:" + jTextField5.getText();
                temp += ",\nModelo:" + jTextField6.getText();
                
                temp += ",\nTipo:" + jTextField7.getText();
                temp += ",\nPadrão de Entrada:" + jTextField8.getText() + ";\n\n";

            break;
                
            case "celulares":
                
                temp += ",\nCor:" + jTextField5.getText();
                temp += ",\nModelo:" + jTextField6.getText();
                
                temp += ",\nTamanho da Tela:" + jTextField7.getText();
                temp += ",\nMemória:" + jTextField8.getText();
                temp += ",\nProcessador:" + jTextField9.getText();
                temp += ",\nCâmera:" + jTextField10.getText() + ";\n\n";
            break;
            
            case "computadores":
                temp += ",\nCor:" + jTextField5.getText();
                temp += ",\nModelo:" + jTextField6.getText();
                
                temp += ",\nProcessador:" + jTextField7.getText();
                temp += ",\nGPU:" + jTextField8.getText();
                temp += ",\nMemória:" + jTextField9.getText();
                temp += ",\nFonte:" + jTextField10.getText();
                if(rdbSim.isSelected())
                    temp += ",\nRGB:" + "true" + ";\n\n";
                else
                    temp += ",\nRGB:" + "false" + ";\n\n";
            break;
            
            case "eletroeletronicos":
                
                temp += ",\nConsumo de Energia:" + jTextField5.getText();
                temp += ",\nPotência:" + jTextField6.getText();
                if(rdbSim.isSelected())
                    temp += ",\nSmart:" + "true" + ";\n\n";
                else
                    temp += ",\nSmart:" + "false" + ";\n\n";
            break;
            
            case "vestuario":
                temp += ",\nTamanho:" + jTextField5.getText();
                temp += ",\nCor:" + jTextField6.getText();
                temp += ",\nMaterial:" + jTextField7.getText() + ";\n\n";
            break;
            
            default:
        }
        
        try{
            if(jTextField1.getText().equals("") || jTextField2.getText().equals("") || jTextField3.getText().equals("") || 
               jTextField4.getText().equals("") || jTextField5.getText().equals("") || jTextField6.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Todos os dados devem ser inseridos!!!", "Aviso", JOptionPane.WARNING_MESSAGE);
            
            else if(!menu.equals("eletroeletronicos") && jTextField7.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Todos os dados devem ser inseridos!!!", "Aviso", JOptionPane.WARNING_MESSAGE);
            
            else if(!menu.equals("eletroeletronicos") && !menu.equals("vestuario") && jTextField7.getText().equals(""))
                JOptionPane.showMessageDialog(null, "Todos os dados devem ser inseridos!!!", "Aviso", JOptionPane.WARNING_MESSAGE);
            
            else if((jTextField9.getText().equals("") || jTextField10.getText().equals("")) && 
                    (menu.equals("livros") || menu.equals("computadores") || menu.equals("celulares")))
                JOptionPane.showMessageDialog(null, "Todos os dados devem ser inseridos!!!", "Aviso", JOptionPane.WARNING_MESSAGE);
                    
            else{
                if(!erro)
                {
                    escritor("dados/" + menu + ".txt", temp);
                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                    this.setVisible(false);
                }
            }
            
        }catch (IOException ex) {
            Logger.getLogger(TelaCadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(TelaCadastrarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastrarProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup btnGrupo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel pnlDadosProduto;
    private javax.swing.JRadioButton rdbNao;
    private javax.swing.JRadioButton rdbSim;
    // End of variables declaration//GEN-END:variables
}

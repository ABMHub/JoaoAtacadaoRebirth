/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import camadaDePersistencia.Conexao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pichau
 */
public class Historico extends javax.swing.JFrame {

    private int pagina = 0;
    private String arquivo = new String("Todos");
    ArrayList<String[]> historico = null;
    
    public Historico() {
        initComponents();
        setResizable(false); // maximize button disable
    }

    private ArrayList<String[]> getDados()
    {
        String numeroDaCompra = txtNumeroDaCompra.getText();
        String dataDaCompra   = txtDataDaCompra.getText();
        
        ArrayList<String[]> lista = null;
        
        if(numeroDaCompra.equals("") && dataDaCompra.equals("")) {
            lista = Conexao.select("view_historico", pagina); 
        }else{
            if(dataDaCompra.equals("")){            //Se a data da compra estiver vazia, buscar pelo número
                lista = Conexao.select("view_historico", ("numero_da_compra = " + numeroDaCompra), pagina);
            }else{
               if(numeroDaCompra.equals("")){       //Se o número da compra estiver vazio, buscar pelo número
                   lista = Conexao.select("view_historico", ("data_da_compra = '" + dataDaCompra + "'"), pagina);
               }else{
                   lista = Conexao.select("view_historico", ("numero_da_compra = " + numeroDaCompra + 
                           " && data_da_compra = '" + dataDaCompra + "'"), pagina);
               }    
            }
        }
        
        return lista;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistorico = new javax.swing.JTable();
        lblPesquisaDeProdutos = new javax.swing.JLabel();
        lblPesquisar = new javax.swing.JLabel();
        lblPesquisar1 = new javax.swing.JLabel();
        txtDataDaCompra = new javax.swing.JTextField();
        txtNumeroDaCompra = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnEsquerda = new javax.swing.JButton();
        btnDireita = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tblHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número da Compra", "Código de Barras", "Nome", "Valor da Unitário", "Qtd. de Itens", "Data", "CPF"
            }
        ));
        jScrollPane1.setViewportView(tblHistorico);

        lblPesquisaDeProdutos.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblPesquisaDeProdutos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPesquisaDeProdutos.setText("Histórico de Compras");

        lblPesquisar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPesquisar.setText("Filtrar por número da compra:");

        lblPesquisar1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPesquisar1.setText("Filtrar por data de compra:");

        txtDataDaCompra.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtNumeroDaCompra.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar2.png"))); // NOI18N
        btnPesquisar.setMnemonic('P');
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setFocusPainted(false);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnEsquerda.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnEsquerda.setText("🡄");
        btnEsquerda.setFocusPainted(false);
        btnEsquerda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEsquerdaActionPerformed(evt);
            }
        });

        btnDireita.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnDireita.setText("🡆");
        btnDireita.setFocusPainted(false);
        btnDireita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDireitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPesquisaDeProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNumeroDaCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(txtDataDaCompra))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(268, 268, 268)
                                .addComponent(btnPesquisar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(216, 216, 216)
                                .addComponent(btnEsquerda)
                                .addGap(116, 116, 116)
                                .addComponent(btnDireita)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPesquisaDeProdutos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtNumeroDaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPesquisar)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPesquisar1)
                            .addComponent(txtDataDaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(btnPesquisar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDireita)
                    .addComponent(btnEsquerda))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        pagina = 0;
        ArrayList<String[]> lista = getDados();
        
        if(lista.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Não foram encontrados resultados para esses filtros!", 
                    "Falha na Busca", JOptionPane.ERROR_MESSAGE);
        }
        historico = lista;
        criaTabela(lista);    
        
            
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEsquerdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsquerdaActionPerformed

        ArrayList<String[]> lista = getDados();
        if (pagina <= 0)
            return;
        pagina -= 1;
        lista = getDados();
        
        if (!lista.isEmpty()) {
            historico = lista;
            criaTabela(lista);
        }
        else
            pagina += 1;
    }//GEN-LAST:event_btnEsquerdaActionPerformed

    private void btnDireitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDireitaActionPerformed
        if(historico == null)
            return;
        pagina += 1;
        ArrayList<String[]> lista = getDados();
        if (!lista.isEmpty()) {
            historico = lista;
            criaTabela(lista);
        }
        else
            pagina -= 1;
    }//GEN-LAST:event_btnDireitaActionPerformed

    private void criaTabela(ArrayList<String[]> historico) {
        DefaultTableModel modelo = new DefaultTableModel( new Object[] { "Número da Compra", "Código de Barras", 
            "Nome", "Valor Unitário", "Qtd. Itens", "data", "CPF"} , 0);
        
        for (int i = 0; i < historico.size(); i++ ){
            Object linha[] = new Object[] {
                historico.get(i)[0],
                historico.get(i)[1],
                historico.get(i)[2],
                historico.get(i)[3],
                historico.get(i)[4],
                historico.get(i)[5],
                historico.get(i)[6]
            };
            
            modelo.addRow(linha);
        }
        tblHistorico.setModel(modelo);
    }
    
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
            java.util.logging.Logger.getLogger(Historico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Historico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDireita;
    private javax.swing.JButton btnEsquerda;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPesquisaDeProdutos;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JLabel lblPesquisar1;
    private javax.swing.JTable tblHistorico;
    private javax.swing.JTextField txtDataDaCompra;
    private javax.swing.JTextField txtNumeroDaCompra;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import camadaDePersistencia.Conexao;

/**
 *
 * @author João Víctor
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        botaoMagico.setOpaque(false);
        botaoMagico.setContentAreaFilled(false);
        botaoMagico.setBorderPainted(false);
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botaoMagico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("João Atacadão");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/loja1.png")).getImage());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cliente1.png"))); // NOI18N
        jButton1.setMnemonic('C');
        jButton1.setText("Cliente");
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/funcionario1.png"))); // NOI18N
        jButton2.setMnemonic('F');
        jButton2.setText("Funcionário");
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produto1.png"))); // NOI18N
        jButton3.setMnemonic('P');
        jButton3.setText("Produto");
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/gerenciamento.png"))); // NOI18N
        jButton4.setMnemonic('G');
        jButton4.setText("Gerenciamento");
        jButton4.setFocusPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/caixa1.png"))); // NOI18N
        jButton5.setMnemonic('A');
        jButton5.setText("Caixa");
        jButton5.setFocusPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/saida1.png"))); // NOI18N
        jButton6.setMnemonic('S');
        jButton6.setText("Sair");
        jButton6.setFocusPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 255));
        jLabel1.setText("Bem-vindo ao João Atacadão");

        botaoMagico.setMnemonic('M');
        botaoMagico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoMagicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(88, 88, 88)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoMagico)
                .addGap(41, 41, 41)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(botaoMagico)))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(jButton4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6))))
                    .addComponent(jButton5))
                .addContainerGap(135, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new CadastrarCliente().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new CadastrarFuncionario().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new CadastrarProduto().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new ListarProdutos().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Caixa caixa = new Caixa();
        if (caixa.valido)
            caixa.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void botaoMagicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoMagicoActionPerformed
        Conexao.create("eletroeletronico", "'1', 'Geladeira', 1000, 'eletrolux', 'eletroeletronico'", "'1', '1000', '500', true");
        Conexao.create("eletroeletronico", "'2', 'Microondas', 500, 'panasonic', 'eletroeletronico'", "'2', '2000', '300', false");
        Conexao.create("eletroeletronico", "'3', 'Cafeteira', 200, 'tres coracoes', 'eletroeletronico'", "'3', '100', '900', true");
        
        Conexao.create("vestuario", "'4', 'Salto Preto', 200, 'havan', 'vestuario'", "'4', '37', 'preto', 'plastico'");
        Conexao.create("vestuario", "'5', 'Sapatilha Cinderela', 750, 'disney', 'vestuario'", "'5', '33', 'azul-transparente', 'cristal'");
        Conexao.create("vestuario", "'6', 'Casaco Branco', 270, 'zara', 'vestuario'", "'6', 'L', 'branco', 'tecido'");
        
        Conexao.create("computador", "'7', 'Laptop Xuxa', 100, 'ciatoy', 'computador'", "'7', 'nao', 'nao', true, '10kb', 'nao', 'rosa', 'Xuxa So Para Baixinhos'");
        Conexao.create("computador", "'8', 'Pichau Gamer', 7000, 'pichau', 'computador'", "'8', 'i9-11', 'rtx3090', true, '64gb', 'boazona', 'todas', 'XGamerDestroyer'");
        Conexao.create("computador", "'9', 'PC Generico', 1300, 'lenovo', 'computador'", "'9', 'i3-10', 'onboard', false, '8gb', 'media', 'azul', 'home office'");
        
        Conexao.create("celular", "'10', 'Samsung S20', 3000, 'Samsung', 'celular'", "'10', 'snapdragon', '15', '16gb', '65mp', 'cinza', 'S20'");
        Conexao.create("celular", "'11', 'Moto G8', 1300, 'Motorola', 'celular'", "'11', 'snapdragon', '13', '8gb', '32mp', 'preto', 'G8'");
        Conexao.create("celular", "'12', 'Nokia 3180', 200, 'Nokia', 'celular'", "'12', 'uns fios', '5', '16kb', 'nao', 'azul', '3180'");
        
        Conexao.create("periferico", "'13', 'HyperX Surge', 300, 'HyperX', 'periferico'", "'13', 'mouse', 'usb', 'preto', 'Surge'");
        Conexao.create("periferico", "'14', 'JBL Quantum 100', 200, 'JBL', 'periferico'", "'14', 'headset', 'p3', 'preto', 'Quantum 100'");
        Conexao.create("periferico", "'15', 'Monitor Samsung', 600, 'Samsung', 'periferico'", "'15', 'monitor', 'hdmi', 'preto', 'generico'");
        
        Conexao.create("filme", "'16', 'Interestelar', 50, 'Paramount', 'filme'", "'16', 'nolan', 180, '14', 'scifi'");
        Conexao.create("filme", "'17', 'Os Incriveis', 20, 'Disney', 'filme'", "'17', 'roberta', 90, 'L', 'herois'");
        Conexao.create("filme", "'18', 'Madagascar', 15, 'Pixar', 'filme'", "'18', 'caio', 99, 'L', 'aventura'");
        
        Conexao.create("livro", "'19', 'Fundacao', 20, 'Aleph', 'livro'", "'19', 'asimov', 180, 'aleph', '14156671', '14', 'scifi'");
        Conexao.create("livro", "'20', 'Senhor dos Aneis', 40, 'IMFE', 'livro'", "'20', 'tolkien', 310, 'IMFE', '416561', '12', 'aventura'");
        Conexao.create("livro", "'21', 'Duna', 50, 'Editora', 'livro'", "'21', 'frank herbert', 680, 'Editora', '3315517', '14', 'scifi'");
        
        Conexao.create("funcionario", "'062.942.051-31', 'Lucas ADM', '2000-10-02', 7000, true, '3591'");
        Conexao.create("funcionario", "'415.941.131-13', 'Joao Pedro', '2001-05-02', 3000, false, null");
        Conexao.create("funcionario", "'516.521.331-22', 'Joao Victor', '2000-11-13', 3000, false, null");
        
        Conexao.create("cliente", "'145.132.672-13', 'Joao Bernardo', '1973-10-11', 200, '123'");
        Conexao.create("cliente", "'613.754.356-11', 'Joao Lucas', '2013-10-11', 1000, '123'");
        Conexao.create("cliente", "'854.469.345-77', 'Joao Maranhão', '2001-09-01', 2200, '123'");
    }//GEN-LAST:event_botaoMagicoActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoMagico;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

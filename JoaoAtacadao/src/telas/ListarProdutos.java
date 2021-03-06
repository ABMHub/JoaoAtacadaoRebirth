/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import camadaDePersistencia.Conexao;
import java.text.Normalizer;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import joaoatacadao.Validacao;
import joaoatacadao.pessoa.Gerente;

/**
 *
 * @author lucas
 */
public class ListarProdutos extends javax.swing.JFrame {

    private int pagina = 0;
    private String arquivo = new String("Todos");
    ArrayList<String[]> produtos;
    
    public ListarProdutos() {
        initComponents();
        carregaDepartamentos();
        setResizable(false); // maximize button disable
        tblProdutos.setRowSelectionAllowed(true);
        tblProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    private String campoDeSenha (String mensagem) {
        JLabel label = new JLabel(mensagem);
        JPasswordField jpf = new JPasswordField();
        JOptionPane.showConfirmDialog(null,
        new Object[]{label, jpf}, "Senha:",
        JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
        
        String senhaDigitada = new String(jpf.getPassword());
        return senhaDigitada;
    }
    
    public void carregaDepartamentos () {
        cmbDepartamentos.removeAllItems();
        
        cmbDepartamentos.addItem("Todos");
        cmbDepartamentos.addItem("Livro");
        cmbDepartamentos.addItem("Filme");
        cmbDepartamentos.addItem("Periférico");
        cmbDepartamentos.addItem("Celular");
        cmbDepartamentos.addItem("Computador");
        cmbDepartamentos.addItem("Eletroeletrônico");
        cmbDepartamentos.addItem("Vestuário");
        
    }
    
    public void updateArquivo () {
        arquivo = Normalizer.normalize(((String) cmbDepartamentos
                .getSelectedItem()), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
    
    private void criaTabela(ArrayList<String[]> produtos) {
        DefaultTableModel modelo = new DefaultTableModel( new Object[] { "Código", "Nome", "Preço", "Marca" } , 0);
        
        for (int i = 0; i < produtos.size(); i++ ){
            Object linha[] = new Object[] {
                produtos.get(i)[0],
                produtos.get(i)[1],
                produtos.get(i)[2],
                produtos.get(i)[3]
            };
            
            modelo.addRow(linha);
        }
        tblProdutos.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlListarProdutos = new javax.swing.JPanel();
        lblPesquisaDeProdutos = new javax.swing.JLabel();
        lblPesquisar = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        lblDepartamento = new javax.swing.JLabel();
        cmbDepartamentos = new javax.swing.JComboBox<>();
        btnPesquisarTodos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btnDireita = new javax.swing.JButton();
        btnEsquerda = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de Produtos");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/gerente1.png")).getImage());

        lblPesquisaDeProdutos.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblPesquisaDeProdutos.setText("Pesquisa de Produtos");

        lblPesquisar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPesquisar.setText("Código:");

        txtPesquisar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar2.png"))); // NOI18N
        btnPesquisar.setMnemonic('P');
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setFocusPainted(false);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        lblDepartamento.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDepartamento.setText("Departamento");

        cmbDepartamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnPesquisarTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lista1.png"))); // NOI18N
        btnPesquisarTodos.setMnemonic('L');
        btnPesquisarTodos.setText("Listar Todos");
        btnPesquisarTodos.setFocusPainted(false);
        btnPesquisarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarTodosActionPerformed(evt);
            }
        });

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Preço", "Marca"
            }
        ));
        jScrollPane1.setViewportView(tblProdutos);

        btnDireita.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnDireita.setText("🡆");
        btnDireita.setFocusPainted(false);
        btnDireita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDireitaActionPerformed(evt);
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

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir2.png"))); // NOI18N
        btnExcluir.setMnemonic('E');
        btnExcluir.setText("Excluir");
        btnExcluir.setFocusPainted(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlListarProdutosLayout = new javax.swing.GroupLayout(pnlListarProdutos);
        pnlListarProdutos.setLayout(pnlListarProdutosLayout);
        pnlListarProdutosLayout.setHorizontalGroup(
            pnlListarProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListarProdutosLayout.createSequentialGroup()
                .addGroup(pnlListarProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlListarProdutosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlListarProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlListarProdutosLayout.createSequentialGroup()
                                .addComponent(txtPesquisar)
                                .addGap(18, 18, 18)
                                .addComponent(btnPesquisar))
                            .addGroup(pnlListarProdutosLayout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(pnlListarProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDepartamento))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(25, 25, 25))
                    .addGroup(pnlListarProdutosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))
                    .addGroup(pnlListarProdutosLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(lblPesquisaDeProdutos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListarProdutosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEsquerda)
                .addGap(61, 61, 61)
                .addComponent(btnDireita)
                .addGap(139, 139, 139))
            .addGroup(pnlListarProdutosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPesquisarTodos)
                .addGap(47, 47, 47)
                .addComponent(btnExcluir)
                .addGap(73, 73, 73))
        );
        pnlListarProdutosLayout.setVerticalGroup(
            pnlListarProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListarProdutosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblPesquisaDeProdutos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(pnlListarProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar)
                    .addComponent(lblPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDepartamento)
                .addGap(18, 18, 18)
                .addComponent(cmbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlListarProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisarTodos)
                    .addComponent(btnExcluir))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(pnlListarProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEsquerda)
                    .addComponent(btnDireita))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        txtPesquisar.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlListarProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlListarProdutos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private ArrayList getDados() {
        if (arquivo.equals("Todos"))
            return Conexao.select("produto", pagina);
        else 
            return Conexao.select("view_" + arquivo, pagina);
    }
    
    private void btnPesquisarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarTodosActionPerformed
        updateArquivo();
        pagina = 0;
        produtos = getDados();
        
        if (produtos != null)
            criaTabela(produtos);
    }//GEN-LAST:event_btnPesquisarTodosActionPerformed
    
    private void btnDireitaActionPerformed(java.awt.event.ActionEvent evt) {                                         
        ArrayList lista = null;
        pagina += 1;
        lista = getDados();
        if (!lista.isEmpty()) {
            produtos = lista;
            criaTabela(lista);
        }
        else
            pagina -= 1;
    }                                        

    private void btnEsquerdaActionPerformed(java.awt.event.ActionEvent evt) {                                         
        ArrayList lista = null;
        if (pagina <= 0)
            return;
        pagina -= 1;
        lista = getDados();
        
        if (!lista.isEmpty()) {
            produtos = lista;
            criaTabela(lista);
        }
        else
            pagina += 1;
    }                                        

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        String codigo = txtPesquisar.getText();
        txtPesquisar.setText("");
        if(!Validacao.ehInteiro(codigo))
        {
             JOptionPane.showMessageDialog(null, "Código Inválido!", "Falha na Busca", JOptionPane.ERROR_MESSAGE);
             return;
        }
        
        String[] lista = null;
        if (codigo.trim().equals(""))
            return;
        lista = Conexao.select("*", "produto", "codigo_de_barras = " + codigo);   
        
        ArrayList arraylist = new ArrayList<>();
        arraylist.add(lista);
        produtos = arraylist;
        if (lista != null)
            criaTabela(arraylist);
        else
             JOptionPane.showMessageDialog(null, "Produto não encontrado!", "Falha na Busca", JOptionPane.ERROR_MESSAGE);
            
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String cpf = JOptionPane.showInputDialog("Gerente, insira seu CPF");
        if (cpf == null) {
            JOptionPane.showMessageDialog(null, "Informe o CPF!", "Falha na Busca", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String[] dados = null;
        if (cpf.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Informe um CPF de gerente válido!", "Erro de validação", JOptionPane.ERROR_MESSAGE);
            return;
        }
        dados = Conexao.select("*", "funcionario", "cpf = '" + cpf + "'");
        
        if (dados == null || dados[4].equals("0")) {
            JOptionPane.showMessageDialog(null, "Informe um CPF de gerente válido!", "Erro de validação", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Gerente gerente = Gerente.instanciaGerente(dados);
        
        String senha = campoDeSenha("Gerente, insira sua senha!");
        
        if (senha == null || !gerente.isSenha(senha)) {
            JOptionPane.showMessageDialog(null, "Senha incorreta!", "Erro de validação", JOptionPane.ERROR_MESSAGE);
            return;
        }        
        
        int index = tblProdutos.getSelectedRow();
        if (index < 0)
            return;
        if(produtos == null)
            return;
        Conexao.delete("produto", "codigo_de_barras = " + produtos.get(index)[0]);
        produtos = getDados();
        if (produtos != null)
            criaTabela(produtos);
    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(ListarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDireita;
    private javax.swing.JButton btnEsquerda;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnPesquisarTodos;
    private javax.swing.JComboBox<String> cmbDepartamentos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblPesquisaDeProdutos;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JPanel pnlListarProdutos;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}

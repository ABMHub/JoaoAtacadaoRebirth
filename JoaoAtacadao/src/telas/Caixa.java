/*
 Classe responsável pela identificação dos produtos que são levados ao caixa. Ela conta com mecanismos
 para calcular o valor total e parcial da compra, bem como identificar os dados lidos do banco de dados
 e exibi-los para o usuário. Também é possível excluir um produto da lista de compras caso o cliente 
 desista do mesmo, porém nesse caso o gerente deve ser chamado para que possa digitar a senha de gerente,
 sem isso o produto não pode ser removido do log de compras.
 */
package telas;

import camadaDePersistencia.Conexao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;
import joaoatacadao.Carrinho;
import joaoatacadao.ItemPedido;
import joaoatacadao.pessoa.Cliente;
import joaoatacadao.pessoa.Funcionario;
import joaoatacadao.pessoa.Gerente;
import joaoatacadao.produto.Produto;

public class Caixa extends javax.swing.JFrame {
    public boolean valido = true;
    private Carrinho carrinho = new Carrinho();
    private Funcionario funcionario;
    private Cliente cliente;
    private ItemPedido item;
    boolean desconto = false;
    /**
     * Creates new form Caixa
     */
    public Caixa() {
        initComponents();
        resetBtn();
        requisitarFuncionario();
        if (valido)
            requisitarCliente();
        setResizable(false); // maximize button disable
    }

    //Método responsável por reiniciar alguns campos de textos e botões
    public void resetBtn() {
        btnAdicionar.setEnabled(false);
        btnCancelar.setEnabled(true);
        
        txaDadosProduto.setText("");
        txtQuantidade.setText("");
        txtPesquisar.setText("");
        
        txtQuantidade.setEditable(false);
        
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
    
    private void requisitarFuncionario () {
        String cpf = JOptionPane.showInputDialog("Funcionário, insira seu CPF");
        String[] dados = null;
        dados = Conexao.select("cpf, nome, data_de_nascimento, salario, gerente, "
                + "senha", "funcionario", "cpf = '" + cpf + "'");
        
        
        
        if (dados == null) {
            JOptionPane.showMessageDialog(null, "Funcionario não encontrado!", "Falha na Busca", JOptionPane.ERROR_MESSAGE);
            this.valido = false;
        }
        else {
            try {
                InputStream is = Conexao.select("funcionario", "cpf = '" + dados[0] + "'");
                
                Image imagem = ImageIO.read(is);
                Image imagemFinal = imagem.getScaledInstance(64, 64, Image.SCALE_SMOOTH);
                jLabel2.setIcon(new ImageIcon(imagemFinal));
                jLabel4.setText(dados[1]);            
                funcionario = Funcionario.instanciarFuncionario(dados);
            } catch (IOException ex) {
                Logger.getLogger(Caixa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    private void requisitarCliente () {
        String cpf = JOptionPane.showInputDialog("Cliente, insira seu CPF");
        String[] dados = null;
        dados = Conexao.select("*", "cliente", "cpf = '" + cpf + "'");
        
        if (dados == null) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Falha na Busca", JOptionPane.ERROR_MESSAGE);
            this.valido = false;
        }
        else {
            cliente = Cliente.instanciarCliente(dados);
        }
    }
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    /*
    Caso seja clicado em "Adicionar Produto", o objeto (item) instanciado no método pesquisar é adicionado 
    a uma arraylist. Note que todos os produtos que estão sendo processados no caixa ficam salvos em memória.
    */
    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {
        String qtd = txtQuantidade.getText();
        item.setQuantidade((qtd.equals("") || Integer.parseInt(qtd) == 0) ? 1 : Integer.parseInt(qtd));
        lblItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/carrinho1.png")));

        resetBtn();

        carrinho.adicionaProduto(item);
        criaTabela(carrinho.getProdutos());

        lblTotal.setText(Float.toString(carrinho.getTotal()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        pnlCaixa = new javax.swing.JPanel();
        lblPesquisar = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaDadosProduto = new javax.swing.JTextArea();
        btnPagar = new javax.swing.JButton();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnDesconto = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblItem = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jScrollPane2.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Caixa Registradora");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/caixa1.png")).getImage());

        pnlCaixa.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "CAIXA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11)))); // NOI18N

        lblPesquisar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPesquisar.setText("Informe o código de barras:");

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Pesquisar1.png"))); // NOI18N
        btnPesquisar.setMnemonic('P');
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setFocusPainted(false);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Preço", "Quantidade", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProdutos);

        txaDadosProduto.setEditable(false);
        txaDadosProduto.setColumns(20);
        txaDadosProduto.setRows(5);
        jScrollPane3.setViewportView(txaDadosProduto);

        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pagar1.png"))); // NOI18N
        btnPagar.setMnemonic('g');
        btnPagar.setText("Pagar");
        btnPagar.setFocusPainted(false);
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        lblQuantidade.setText("Informe a quantidade:");

        txtQuantidade.setEditable(false);

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adicionar1.png"))); // NOI18N
        btnAdicionar.setMnemonic('A');
        btnAdicionar.setText("Adicionar");
        btnAdicionar.setFocusPainted(false);
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir1.png"))); // NOI18N
        btnExcluir.setMnemonic('E');
        btnExcluir.setText("Excluir");
        btnExcluir.setFocusPainted(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnDesconto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/desconto.png"))); // NOI18N
        btnDesconto.setMnemonic('d');
        btnDesconto.setText("Desconto");
        btnDesconto.setFocusPainted(false);
        btnDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescontoActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar1.png"))); // NOI18N
        btnCancelar.setMnemonic('C');
        btnCancelar.setText("Cancelar");
        btnCancelar.setFocusPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("TOTAL:");

        lblTotal.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTotal.setText("0.0");

        lblItem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/carrinho1.png"))); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Operador:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout pnlCaixaLayout = new javax.swing.GroupLayout(pnlCaixa);
        pnlCaixa.setLayout(pnlCaixaLayout);
        pnlCaixaLayout.setHorizontalGroup(
            pnlCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCaixaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3)
                    .addGroup(pnlCaixaLayout.createSequentialGroup()
                        .addGroup(pnlCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlCaixaLayout.createSequentialGroup()
                                .addComponent(lblQuantidade)
                                .addGap(47, 47, 47))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCaixaLayout.createSequentialGroup()
                                .addComponent(lblPesquisar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(pnlCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlCaixaLayout.createSequentialGroup()
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPesquisar)))))
                .addGap(18, 18, 18)
                .addGroup(pnlCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCaixaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblItem, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(65, 65, 65))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCaixaLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(btnDesconto)
                .addGap(47, 47, 47)
                .addComponent(btnPagar)
                .addGap(63, 63, 63)
                .addComponent(btnAdicionar)
                .addGap(54, 54, 54)
                .addComponent(btnExcluir)
                .addGap(50, 50, 50)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCaixaLayout.setVerticalGroup(
            pnlCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCaixaLayout.createSequentialGroup()
                .addGroup(pnlCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCaixaLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(lblItem, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlCaixaLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(pnlCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(lblTotal)
                                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPesquisar))))
                    .addGroup(pnlCaixaLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCaixaLayout.createSequentialGroup()
                        .addGroup(pnlCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPesquisar)
                            .addComponent(lblQuantidade)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnExcluir)
                    .addComponent(btnPagar)
                    .addComponent(btnDesconto)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtPesquisar.getAccessibleContext().setAccessibleName("");
        txtPesquisar.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    /*
    Método que faz a pesquisa a partir do código de barras no banco de dados, note que, uma vez que o
    funcionário estaria vendo o código de barras, espera-se que o mesmo o digite corretamente, caso o 
    código não seja encontrado no banco de dados uma mensagem de erro é exibida.
    Note também que ela instancia em item (um objeto dessa classe) um objeto do tipo Produto que,
    eventualmente, poderá ou não ser adicionado na arraylist.
    */
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        String codigo = txtPesquisar.getText();
        String arquivo;
        String [] dados = null;
        ImageIcon img;
        
        if (codigo.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado!", "Falha na Busca", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        dados = Conexao.select("*", "produto", "codigo_de_barras = " + codigo);
        
        if (dados == null) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado!", "Falha na Busca", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        arquivo = dados[4].toLowerCase();
        dados = Conexao.select("*", "view_" + dados[4], "codigo_de_barras = " + codigo);
                
        switch(arquivo)
        {
            case "celular": 
                img = new javax.swing.ImageIcon(getClass().getResource("/imagens/celular1.png"));
                break;
            
            case "computador":
                img = new javax.swing.ImageIcon(getClass().getResource("/imagens/computador1.png"));
                break;
                
            case "eletroeletronico":
                img = new javax.swing.ImageIcon(getClass().getResource("/imagens/eletroeletronicos1.png"));
                break;
                
            case "filme":
                img = new javax.swing.ImageIcon(getClass().getResource("/imagens/filme1.png"));
                break;    
            
            case "periferico":
                img = new javax.swing.ImageIcon(getClass().getResource("/imagens/periferico1.png"));
                break;
            
            case "vestuario":
                img = new javax.swing.ImageIcon(getClass().getResource("/imagens/vestuario1.png"));
                break;    
                
            case "livro":
                img = new javax.swing.ImageIcon(getClass().getResource("/imagens/livro1.png"));
                break;
                
            default:
                img = new javax.swing.ImageIcon(getClass().getResource("/imagens/carrinho1.png"));
               
        }        
        
            lblItem.setIcon(img);
            item = new ItemPedido(dados, arquivo);
            txtQuantidade.setEditable(true);
            txaDadosProduto.setText((item.getProduto()).toString());
            btnAdicionar.setEnabled(true);
            btnCancelar.setEnabled(true);
            
    }                                            

//GEN-FIRST:event_btnCancelarActionPerformed
 
//GEN-LAST:event_btnCancelarActionPerformed


/*
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        resetBtn();
    }                                           
*/
    private void btnDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescontoActionPerformed
        lblItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/carrinho1.png")));
        if (cliente.ehAniversario()){
            carrinho.setAniversario(true);
            carrinho.atualizaPrecos();
            lblTotal.setText(Float.toString(carrinho.getTotal()));
            JOptionPane.showMessageDialog(null, "Você conseguiu 10% de desconto de aniversariante!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }

        else {
            JOptionPane.showMessageDialog(null, "Não existem descontos disponíveis no momento", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDescontoActionPerformed

    //Método responsável por fazer a exclusão de um item tanto da tabela quanto da arraylist de produtos
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        lblItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/carrinho1.png")));
        String cpf = JOptionPane.showInputDialog("Gerente, insira seu CPF");
        if (cpf == null) {
            JOptionPane.showMessageDialog(null, "Informe o CPF!", "Falha na Busca", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String[] dados = null;
        
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

        if (tblProdutos.getSelectedRow() >= 0) {
            carrinho.removeProduto(tblProdutos.getSelectedRow());
        }
        criaTabela(carrinho.getProdutos());

        lblTotal.setText(Float.toString(carrinho.getTotal()));
    }//GEN-LAST:event_btnExcluirActionPerformed

//GEN-FIRST:event_btnAdicionarActionPerformed
 
//GEN-LAST:event_btnAdicionarActionPerformed

    /*
    Método responsável por lidar com o pagamento do cliente, tenha em vista que na loja só é possível
    pagar através do cartão fidelidade.
    */
    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        lblItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/carrinho1.png")));
        String senha = campoDeSenha("Insira sua senha do cartão fidelidade");
        float total = 0;
        for (int i = 0 ; i < carrinho.getProdutos().size(); i++) {
            total += carrinho.getProdutos().get(i).getSubtotal();
        }
        if (desconto)
        total = (float) 0.90 * total;

        if (cliente.pagar(senha, total)){
            ArrayList<String> arr = new ArrayList();
            arr.add(cliente.getCpf());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String data = sdf.format(new Date());
            arr.add(data);
            
            String codCompra = Conexao.procedure("cria_carrinho", arr);
            
            for (int i = 0; i < carrinho.getProdutos().size(); i++) {
                ItemPedido aux = carrinho.getProdutos().get(i);
                Conexao.create("ItemPedido", "'" + aux.getProduto().getCodigoDeBarras() + "', " + codCompra + ", " + aux.getQuantidade());
            }
            
            resetBtn();
            carrinho.zerarCarrinho();
            criaTabela(carrinho.getProdutos());
            lblTotal.setText(Float.toString(carrinho.getTotal()));
        }
        //ArrayList<String> arr = new ArrayList();
        //arr.add("145.132.672-13");
        //arr.add("2021-05-03");
        
        //System.out.println(Conexao.procedure("cria_carrinho", arr));
    }//GEN-LAST:event_btnPagarActionPerformed

    /*
    Método que faz a pesquisa a partir do código de barras no banco de dados, note que, uma vez que o
    funcionário estaria vendo o código de barras, espera-se que o mesmo o digite corretamente, caso o 
    código não seja encontrado no banco de dados uma mensagem de erro é exibida.
    Note também que ela instancia em item (um objeto dessa classe) um objeto do tipo Produto que,
    eventualmente, poderá ou não ser adicionado na arraylist.
    
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        String codigo = txtPesquisar.getText();
        String arquivo;
        String [] dados = null;
        ImageIcon img;

        dados = Conexao.select("*", "produto", "codigo_de_barras = " + codigo);

        if (dados == null) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado!", "Falha na Busca", JOptionPane.ERROR_MESSAGE);
            return;
        }

        arquivo = dados[4].toLowerCase();
        dados = Conexao.select("*", "view_" + dados[4], "codigo_de_barras = " + codigo);

        switch(arquivo)
        {
            case "celular":
            img = new javax.swing.ImageIcon(getClass().getResource("/imagens/celular1.png"));
            break;

            case "computador":
            img = new javax.swing.ImageIcon(getClass().getResource("/imagens/computador1.png"));
            break;

            case "eletroeletronico":
            img = new javax.swing.ImageIcon(getClass().getResource("/imagens/eletroeletronicos1.png"));
            break;

            case "filme":
            img = new javax.swing.ImageIcon(getClass().getResource("/imagens/filme1.png"));
            break;

            case "periferico":
            img = new javax.swing.ImageIcon(getClass().getResource("/imagens/periferico1.png"));
            break;

            case "vestuario":
            img = new javax.swing.ImageIcon(getClass().getResource("/imagens/vestuario1.png"));
            break;

            case "livro":
            img = new javax.swing.ImageIcon(getClass().getResource("/imagens/livro1.png"));
            break;

            default:
            img = new javax.swing.ImageIcon(getClass().getResource("/imagens/carrinho1.png"));

        }

        lblItem.setIcon(img);
        item = new ItemPedido(dados, arquivo);
        txtQuantidade.setEditable(true);
        txaDadosProduto.setText((item.getProduto()).toString());
        btnAdicionar.setEnabled(true);
        btnCancelar.setEnabled(true);

    }//GEN-LAST:event_btnPesquisarActionPerformed
*/
    /*
    Método repsonsável por criar a tabela que mostra o log de produtos
    */
    private void criaTabela(ArrayList<ItemPedido> produtos) {
        DefaultTableModel modelo = new DefaultTableModel( new Object[] { "Código", "Preço", "Quantidade", "Subtotal" } , 0);
        
        for (int i = 0; i < produtos.size(); i++ ){
            Produto prod = carrinho.getProdutos().get(i).getProduto();
            Object linha[] = new Object[] {
                prod.getCodigoDeBarras(),
                prod.getValor(),
                carrinho.getProdutos().get(i).getQuantidade(),
                carrinho.getProdutos().get(i).getSubtotal()
            };
            
            modelo.addRow(linha);
        }
        tblProdutos.setModel(modelo);
    }
    

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
            java.util.logging.Logger.getLogger(Caixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Caixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Caixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Caixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Caixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDesconto;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lblItem;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlCaixa;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextArea txaDadosProduto;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
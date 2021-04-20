package joaoatacadao;

import java.util.ArrayList;

public class Carrinho {
    private float total;
    private ArrayList<ItemPedido> produtos;
    private boolean aniversario;

    public Carrinho() {
        produtos = new ArrayList<ItemPedido>();
    }    
    
    public void atualizaPrecos() {
        total = 0;
        for (int i = 0; i<produtos.size(); i++) {
            total += produtos.get(i).getSubtotal();
        }
        if (aniversario)
            total = total * (float) 0.9;
    }
    
    public void zerarCarrinho ()  {
        this.produtos = new ArrayList<ItemPedido>();
        total = 0;
    }
    
    public void adicionaProduto (ItemPedido produto) {
        produtos.add(produto);
        if (aniversario)
            total += produto.getSubtotal() * 0.9;
        else
            total += produto.getSubtotal();        
    }
    
    public void removeProduto (int index) {
        if (aniversario)
            total -= produtos.get(index).getSubtotal() * 0.9;
        else
            total -= produtos.get(index).getSubtotal();
        produtos.remove(index);        
    }
    
    public ArrayList<ItemPedido> getProdutos() {
        return produtos;
    }    
    
    public float getTotal() {
        return total;
    }    

    public boolean isAniversario() {
        return aniversario;
    }

    public void setAniversario(boolean aniversario) {
        this.aniversario = aniversario;
    }
    
    
}

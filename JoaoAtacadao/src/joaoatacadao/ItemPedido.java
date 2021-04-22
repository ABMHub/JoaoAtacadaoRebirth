/*
    Classe ItemPedido que cria, a partir de parâmetros, um objeto adequado do tipo produto.
    Ela decide qual objeto criar a partir do código de barras como pode ser visto no switch case

    O método setQuantidade também calcula o subtotal de produtos do mesmo tipo, isto é, multiplica 
    o valor do item pela quantidade itens (iguais) que serão comprados.
*/
package joaoatacadao;

import joaoatacadao.produto.Celular;
import joaoatacadao.produto.Computador;
import joaoatacadao.produto.Eletroeletronico;
import joaoatacadao.produto.Filmes;
import joaoatacadao.produto.Livros;
import joaoatacadao.produto.Periferico;
import joaoatacadao.produto.Produto;
import joaoatacadao.produto.Vestuario;

public class ItemPedido {
    private float subtotal;
    private int quantidade;
    Produto produto;

    public ItemPedido(String []dados, String categoria) {
        criaProduto(dados, categoria);
        this.subtotal = Float.parseFloat(dados[2]);
        this.quantidade = 1;
    }
    
    private void criaProduto (String[] dados, String categoria) {
        switch(categoria.toLowerCase())
        {
            //celular
            case "celular":
                produto = new Celular(dados[5], dados[6], dados[4], dados[7], dados[8], dados[9], 
                          dados[1], dados[0], Float.parseFloat(dados[2]), dados[3]);
                break;
            
            case "computador":
                produto = new Computador(dados[4], dados[5], dados[7], dados[8], Boolean.parseBoolean(dados[6]), dados[9], 
                          dados[10], dados[1], dados[0], Float.parseFloat(dados[2]), dados[3]);
                break;
                
            case "eletroeletronico":
                produto = new Eletroeletronico(dados[4], dados[5], Boolean.parseBoolean(dados[6]), dados[1], dados[0], 
                          Float.parseFloat(dados[2]), dados[3]);
                break;
                
            case "filme":
                produto = new Filmes(dados[4], Integer.parseInt(dados[5]), dados[6], dados[7], dados[1], dados[0], 
                        Float.parseFloat(dados[2]), dados[3]);
                break;    
            
            case "periferico":
                produto = new Periferico(dados[4], dados[5], dados[6], dados[7], dados[1], dados[0], 
                Float.parseFloat(dados[2]), dados[3]);
                break;
            
            case "vestuario":
                produto = new Vestuario(dados[4], dados[5], dados[6], dados[1], dados[0], Float.parseFloat(dados[2]), dados[3]);
                break;    
                
            case "livro":
                produto = new Livros(dados[4], dados[6], Integer.parseInt(dados[5]), dados[7], dados[8], dados[9], dados[1], dados[0], 
                          Float.parseFloat(dados[2]), dados[3]);
                break;
                
            default:
                System.out.println("deu ruim");
                break;   //Deu ruim
        }
    }

    private float atualizaPreco (int quantidade) {
        return quantidade * produto.getValor();
    }
    
    public float getSubtotal() {
        return subtotal;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }   
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        subtotal = atualizaPreco(quantidade);
    }
}

/*
    Classe abstrata que cria mais atributos específicos dos quais os produtos podem derivar
*/
package joaoatacadao.produto;

public abstract class Informatica extends Produto {
    protected String cor;
    protected String modelo;

    public Informatica(String cor, String modelo, String nome, String codigoDeBarras, float valor, String marca) {
        super(nome, codigoDeBarras, valor, marca);
        this.cor = cor;
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public abstract String toString();
    
    
}

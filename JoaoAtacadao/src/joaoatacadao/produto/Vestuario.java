/*
    Classe Vestuário concreta, ela implementa o método abstrato de suas classes pais.
*/
package joaoatacadao.produto;

public class Vestuario extends Produto{
    protected String tamanho;
    protected String cor;
    protected String material;

    public Vestuario(String tamanho, String cor, String material, String nome, String codigoDeBarras, float valor, String marca) {
        super(nome, codigoDeBarras, valor, marca);
        this.tamanho = tamanho;
        this.cor = cor;
        this.material = material;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getCor() {
        return cor;
    }

    public String getMaterial() {
        return material;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ",\nCódigo de Barras: " + codigoDeBarras + ",\nValor: " + valor + ",\nMarca: " + marca   
        + ",\nTamanho: " + tamanho + ",\nCor:" + cor + ",\nMaterial:" + material;
    }
    
    
}

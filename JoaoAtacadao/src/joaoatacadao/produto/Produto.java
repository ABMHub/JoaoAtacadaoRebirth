/*
    Classe abstrata produto que possui várias classes derivadas. Note que o método toString é abstrato.
    Aqui são encontrados atributos básicos que os produtos têm em comum.
*/
package joaoatacadao.produto;

public abstract class Produto {
    protected String nome;
    protected String codigoDeBarras;
    protected float valor;
    protected String marca;

    public Produto(String nome, String codigoDeBarras, float valor, String marca) {
        this.nome = nome;
        this.codigoDeBarras = codigoDeBarras;
        this.valor = valor;
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public float getValor() {
        return valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public abstract String toString();
    
    
}

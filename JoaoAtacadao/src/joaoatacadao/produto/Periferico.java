/*
    Classe concreta Periférico que implementa o método toString de suas classes pais
*/
package joaoatacadao.produto;

public class Periferico extends Informatica {
    protected String tipo;
    protected String padraoDeEntrada;

    public Periferico(String tipo, String padraoDeEntrada, String cor, String modelo, String nome, String codigoDeBarras, float valor, String marca) {
        super(cor, modelo, nome, codigoDeBarras, valor, marca);
        this.tipo = tipo;
        this.padraoDeEntrada = padraoDeEntrada;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPadraoDeEntrada() {
        return padraoDeEntrada;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPadraoDeEntrada(String padraoDeEntrada) {
        this.padraoDeEntrada = padraoDeEntrada;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ",\nCódigo de Barras: " + codigoDeBarras + ",\nValor: " + valor + ",\nMarca: " + marca
                + ",\nCor: " + cor + ",\nModelo: " + modelo
                + ",\nTipo: " + tipo + ",\nPadrão de Entrada: " + padraoDeEntrada;
    }
    
    
}

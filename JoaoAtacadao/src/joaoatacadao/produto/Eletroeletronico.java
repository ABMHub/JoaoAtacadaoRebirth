/*
    Classe concreta Periférico que implementa o método toString de sua classe pai
*/

package joaoatacadao.produto;

public class Eletroeletronico extends Produto {
    protected String consumoDeEnergia;
    protected String potencia;
    protected boolean smart;

    public Eletroeletronico(String consumoDeEnergia, String potencia, boolean smart, String nome, String codigoDeBarras, float valor, String marca) {
        super(nome, codigoDeBarras, valor, marca);
        this.consumoDeEnergia = consumoDeEnergia;
        this.potencia = potencia;
        this.smart = smart;
    }

    public String getConsumoDeEnergia() {
        return consumoDeEnergia;
    }

    public String getPotencia() {
        return potencia;
    }

    public boolean isSmart() {
        return smart;
    }

    public void setConsumoDeEnergia(String consumoDeEnergia) {
        this.consumoDeEnergia = consumoDeEnergia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public void setSmart(boolean smart) {
        this.smart = smart;
    }

    @Override
    public String toString() {
        String auxSmart = smart ? "É Smart" : "Não é Smart";
        return "Nome: " + nome + ",\nCódigo de Barras: " + codigoDeBarras + ",\nValor: " + valor + ",\nMarca: " + marca
         + ",\nConsumoDeEnergia: " + consumoDeEnergia + ",\nPotência: " + potencia + ",\nSmart: " + auxSmart;
    }
    
    
}

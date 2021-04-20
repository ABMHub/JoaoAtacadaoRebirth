/*
    Classe concreta Periférico que implementa o método toString de suas classes pais
*/

package joaoatacadao.produto;

public class Computador extends Informatica {
    protected String processador;
    protected String gpu;
    protected String memoria;
    protected String fonte;
    protected boolean rgb;

    public Computador(String processador, String gpu, String memoria, String fonte, boolean rgb, String cor, String modelo, String nome, String codigoDeBarras, float valor, String marca) {
        super(cor, modelo, nome, codigoDeBarras, valor, marca);
        this.processador = processador;
        this.gpu = gpu;
        this.memoria = memoria;
        this.fonte = fonte;
        this.rgb = rgb;
    }

    public String getProcessador() {
        return processador;
    }

    public String getGpu() {
        return gpu;
    }

    public String getMemoria() {
        return memoria;
    }

    public String getFonte() {
        return fonte;
    }

    public boolean isRgb() {
        return rgb;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public void setRgb(boolean rgb) {
        this.rgb = rgb;
    }

    @Override
    public String toString() {
        String auxRgb = rgb ? "Tem RGB" : "Não tem RGB";
        return "Nome: " + nome + ",\nCódigo de Barras: " + codigoDeBarras + ",\nValor: " + valor + ",\nMarca: " + marca
            + ",\nCor: " + cor + ",\nModelo: " + modelo    
            + ",\nProcessador: " + processador + ",\nGPU: " + gpu +
            ",\nMemória:" + memoria + ",\nFonte: " + fonte + ",\nRGB: " + auxRgb;
    }
    
    
}

/*
    Classe concreta Periférico que implementa o método toString de suas classes pais
*/

package joaoatacadao.produto;

public class Celular extends Informatica{
    protected String tamanhoDaTela;
    protected String memoria;
    protected String processador;
    protected String camera;

    public Celular(String tamanhoDaTela, String memoria, String processador, String camera, String cor, String modelo, String nome, String codigoDeBarras, float valor, String marca) {
        super(cor, modelo, nome, codigoDeBarras, valor, marca);
        this.tamanhoDaTela = tamanhoDaTela;
        this.memoria = memoria;
        this.processador = processador;
        this.camera = camera;
    }

    public String getTamanhoDaTela() {
        return tamanhoDaTela;
    }

    public String getMemoria() {
        return memoria;
    }

    public String getProcessador() {
        return processador;
    }

    public String getCamera() {
        return camera;
    }

    public void setTamanhoDaTela(String tamanhoDaTela) {
        this.tamanhoDaTela = tamanhoDaTela;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    @Override
    public String toString() {
        return  "Nome: " + nome + ",\nCódigo de Barras: " + codigoDeBarras + ",\nValor: " + valor + ",\nMarca: " + marca
                + ",\nCor: " + cor + ",\nModelo: " + modelo    
                + ",\nTamanho da Tela: " + tamanhoDaTela + ",\nMemória: " +
                memoria + ",\nProcessador: " + processador + ",\nCâmera: " + camera;
    }
    
    
}

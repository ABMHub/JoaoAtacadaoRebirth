/*
    Classe concreta Filmes que implementa o método toString de suas classes pais
*/

package joaoatacadao.produto;

public class Filmes extends Entretenimento {
    protected String diretor;
    protected int duracao;

    public Filmes(String diretor, int duracao, String faixaEtaria, String tema, String nome, String codigoDeBarras, float valor, String marca) {
        super(faixaEtaria, tema, nome, codigoDeBarras, valor, marca);
        this.diretor = diretor;
        this.duracao = duracao;
    }

    public String getDiretor() {
        return diretor;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ",\nCódigo de Barras: " + codigoDeBarras + ",\nValor: " + valor + ",\nMarca: " + marca
                + ",\nFaixa Etária: " + faixaEtaria + ",\nTema: " + tema
                + ",\nDiretor: " + diretor + ",\nDuração: " + duracao;
    }   
    
    
    
}

/*
    Classe abstrata que cria mais atributos específicos dos quais os produtos podem derivar
*/

package joaoatacadao.produto;

public abstract class Entretenimento extends Produto{
    protected String faixaEtaria;
    protected String tema;

    public Entretenimento(String faixaEtaria, String tema, String nome, String codigoDeBarras, float valor, String marca) {
        super(nome, codigoDeBarras, valor, marca);
        this.faixaEtaria = faixaEtaria;
        this.tema = tema;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public String getTema() {
        return tema;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @Override
    public abstract String toString();
    
    
}

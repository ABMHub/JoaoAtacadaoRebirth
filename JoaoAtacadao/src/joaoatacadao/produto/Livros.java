/*
    Classe concreta Livros que implementa o método toString de suas classes pais
*/
package joaoatacadao.produto;

public class Livros extends Entretenimento {
    protected String autor;
    protected String editora;
    protected int qtdPaginas;
    protected String ISBN;

    public Livros(String autor, String editora, int qtdPaginas, String ISBN,
            String faixaEtaria, String tema, String nome, String codigoDeBarras,
            float valor, String marca) {
        super(faixaEtaria, tema, nome, codigoDeBarras, valor, marca);
        this.autor = autor;
        this.editora = editora;
        this.qtdPaginas = qtdPaginas;
        this.ISBN = ISBN;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public int getQtdPaginas() {
        return qtdPaginas;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setQtdPaginas(int qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ",\nCódigo de Barras: " + codigoDeBarras + ",\nValor: " + valor + ",\nMarca: " + marca
                + ",\nFaixa Etária: " + faixaEtaria + ",\nTema: " + tema
                + ",\nAutor: " + autor + ",\nEditora: " + editora +
                ",\nQuantidade de Páginas: " + qtdPaginas + ",\nISBN: " + ISBN;
    }
    
}

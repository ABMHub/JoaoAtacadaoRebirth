
package camadaDePersistencia;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao{
    private static Connection connection;
    private static Statement stmt;
    private static ResultSet data;
    
    public static Connection abreConeccao() throws SQLException {
        return DriverManager.getConnection(Endereco.url, Endereco.usuario, Endereco.senha); // Estabelece a conexão
    }
    
    public static Boolean fechaConeccao(Connection coneccao, Statement stmt, ResultSet resultados) {
        try {
            coneccao.close();
            stmt.close();
            if (resultados != null)
                resultados.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
    }
    
    //Create em tabela geral
    public static void create(String tabela, String valores) {
        try {
            connection = abreConeccao();
            stmt = connection.createStatement();
            stmt.execute("INSERT INTO " + tabela + " VALUES ( " + valores + ")");
        } catch (SQLException ex)
        {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fechaConeccao(connection, stmt, data);
        }
    }
    
    //Create em tabela de produto
    public static void create(String tabela, String valores_produto, String valores_especificos) {
        try {
            connection = abreConeccao();
            stmt = connection.createStatement();
            stmt.execute("INSERT INTO Produto VALUES (" + valores_produto + ")");
            stmt.execute("INSERT INTO " + tabela + " VALUES (0, " + valores_especificos + ")");
        } catch (SQLException ex)
        {
            //System.out.println("Entrada duplicada!");
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fechaConeccao(connection, stmt, null);
        }
    }
    
    
    public static void consulta(String colunas, String tabela) {
        try {
            connection = abreConeccao();
            stmt = connection.createStatement();
            
            data = stmt.executeQuery("SELECT nome FROM agente");
            while(data.next()) {
                System.out.println(data.getString("nome"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fechaConeccao(connection, stmt, data);
        }
    }
    
    public static void update(String tabela, String dados, String chave) {
        try {
            connection = abreConeccao();
            stmt = connection.createStatement();
            
            stmt.execute("UPDATE " + tabela + " SET " + dados + " WHERE " + chave);            
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fechaConeccao(connection, stmt, data);
        }
    }
    
    // Funcao para deletar registro de determinada tabela
    // 'Tabela' eh o nome da tabela, 'chave' eh 'nome da chave = valor da chave'
    public static void delete(String tabela, String chave) {
        try {
            connection = abreConeccao();
            stmt = connection.createStatement();
            stmt.execute("DELETE FROM " + tabela + " WHERE " + chave);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fechaConeccao(connection, stmt, data);
        }
    }
    
    public static void delete(String tabela, String chave, Boolean produto) {
        if (produto) {
           try {
                connection = abreConeccao();
                stmt = connection.createStatement();
                stmt.execute("DELETE FROM " + tabela + " WHERE " + tabela + ".codigo_de_barras = " + chave);
                stmt.execute("DELETE FROM produto WHERE codigo_de_barras = " + chave);
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                fechaConeccao(connection, stmt, data);
            } 
        }
        else delete(tabela, chave);
    }
}

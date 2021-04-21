
package camadaDePersistencia;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao{
    private static String connectionString = "jdbc:mysql://localhost:3306/joaoatacado";
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
            resultados.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
    }
    
    public static void create(String tabela, String valores) {
        try {
            connection = DriverManager.getConnection(connectionString, "root", "1732");
            stmt = connection.createStatement();
            stmt.execute("INSERT INTO " + tabela + " VALUES " + valores);
        } catch (SQLException e)
        {
            System.out.println("Entrada duplicada!");
        } finally {
            fechaConeccao(connection, stmt, data);
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
    
    // Funcao para deletar registro de determinada tabela
    // 'Tabela' eh o nome da tabela, 'chave' eh 'nome da chave = valor da chave'
    public static void delete(String tabela, String chave) {
        try {
            connection = DriverManager.getConnection(connectionString, "root", "3591");
            stmt = connection.createStatement();
            data = stmt.executeQuery("DELETE FROM " + tabela + " WHERE " + chave);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fechaConeccao(connection, stmt, data);
        }
    }
}

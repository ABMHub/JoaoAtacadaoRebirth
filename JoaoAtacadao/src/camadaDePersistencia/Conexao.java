
package camadaDePersistencia;
import java.sql.*;

public class Conexao{
    private static String connectionString = "jdbc:mysql://localhost:3306/detran2";
    private static Connection connection;
    private static Statement stmt;
    private static ResultSet data;
    
    public static void consulta() throws SQLException {
        connection = DriverManager.getConnection(connectionString, "root", "3591");
        stmt = connection.createStatement();
        data = stmt.executeQuery("SELECT nome FROM agente");
        while(data.next()) {
            System.out.println(data.getString("nome"));
        }
    }
}

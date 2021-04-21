
package camadaDePersistencia;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Arrays;

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
    public static boolean create(String tabela, String valores) {
        boolean deuCerto = true;
        try {
            connection = abreConeccao();
            stmt = connection.createStatement();
            stmt.execute("INSERT INTO " + tabela + " VALUES ( " + valores + ")");
        } catch (SQLException ex)
        {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            deuCerto = false;
        } finally {
            fechaConeccao(connection, stmt, data);
        }
        return deuCerto;
    }
    
    //Create em tabela de produto
    public static boolean create(String tabela, String valores_produto, String valores_especificos) {
        boolean deuCerto = true;
        try {
            connection = abreConeccao();
            stmt = connection.createStatement();
            stmt.execute("INSERT INTO Produto VALUES (" + valores_produto + ")");
            stmt.execute("INSERT INTO " + tabela + " VALUES (0, " + valores_especificos + ")");
        } catch (SQLException ex)
        {
            //System.out.println("Entrada duplicada!");
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            deuCerto = false;
        } finally {
            fechaConeccao(connection, stmt, null);
        }
        return deuCerto;
    }
    
    public static ArrayList<String[]> select(String tabela, int pag)
    {
        ArrayList<String[]> lista = new ArrayList();
       
        try {
            connection = abreConeccao();
            stmt = connection.createStatement();
            data = stmt.executeQuery("SELECT * FROM " + tabela);                          //resgata a saída do select
            String[] resultados = null;
            
            for(int i = 1; data.next() && i <= (pag*10 + 10); i++)
            {
                if(i > pag*10)
                {
                    ResultSetMetaData metadata = data.getMetaData();                            //resgata os metadados do resultado obtido
                    int num_colunas = metadata.getColumnCount(); 

                    resultados = new String[num_colunas];
                    
                    for(int j = 1; j <= num_colunas; j++)
                    {
                        resultados[j-1] = data.getString(j);
                    }
                    lista.add(resultados);
                }
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fechaConeccao(connection, stmt, data);
        }
        return lista;
    }
    
    public static ArrayList<String[]> select(String tabela, String condicional, int pag)
    {
        ArrayList<String[]> lista = new ArrayList();
       
        try {
            connection = abreConeccao();
            stmt = connection.createStatement();
            data = stmt.executeQuery("SELECT * FROM " + tabela + " WHERE " + condicional);                 
            String[] resultados = null;
            
            for(int i = 1; data.next() && i <= (pag*10 + 10); i++)
            {
                if(i > pag*10)
                {
                    ResultSetMetaData metadata = data.getMetaData();                            //resgata os metadados do resultado obtido
                    int num_colunas = metadata.getColumnCount(); 

                    resultados = new String[num_colunas];

                    for(int j = 1; j <= num_colunas; j++)
                    {
                        resultados[j-1] = data.getString(j);
                    }
                    lista.add(resultados);
                }
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fechaConeccao(connection, stmt, data);
        }
        return lista;
    }
    
    public static String[] select(String colunas, String tabela, String condicional) {
        String resultados[] = null;
        
        try {
            connection = abreConeccao();
            stmt = connection.createStatement();
            data = stmt.executeQuery("SELECT " + colunas + " FROM " + tabela + 
                                     " WHERE " + condicional);     //resgata a saída do select

            if(!data.next()) return null;   
            ResultSetMetaData metadata = data.getMetaData();                            //resgata os metadados do resultado obtido
            int num_colunas = metadata.getColumnCount(); 
            
            resultados = new String[num_colunas];                              //cria um vetor com o número de colunas de elementos
                                                                                        //acessa o resultado obtido
            for(int i = 1; i <= num_colunas; i++)
            {
                resultados[i-1] = data.getString(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fechaConeccao(connection, stmt, data);
        }
        
        return resultados;
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

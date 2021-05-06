
package camadaDePersistencia;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao{
    private static Connection connection;
    private static Statement stmt;
    private static CallableStatement procStmt;
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
    
    public static Boolean fechaConeccao(Connection coneccao, CallableStatement stmt, ResultSet resultados) {
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

    public static boolean update(String chave, File arquivo) throws FileNotFoundException, IOException, SQLException
    {
        boolean deuCerto = true;
        connection = abreConeccao();
        connection.setAutoCommit(false);
        
        try (FileInputStream fis = new FileInputStream(arquivo);
            PreparedStatement ps = connection.prepareStatement("UPDATE ImagensPadrao SET imagem = (?) WHERE id = \"" + chave + "\";")) 
            {
                ps.setBinaryStream(1, fis, (int) arquivo.length());
                ps.executeUpdate();
                connection.commit();
            } catch (SQLException ex)
            {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                deuCerto = false;
            } finally {
                fechaConeccao(connection, stmt, data);
            }
        
        return deuCerto;
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
            stmt.execute("INSERT INTO " + tabela + " VALUES (" + valores_especificos + ")");
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
    
    
    public static InputStream select(String tabela, String condicional)
    {
        InputStream is = null;
        try {
            connection = abreConeccao();
            stmt = connection.createStatement();
            data = stmt.executeQuery("SELECT imagem FROM " + tabela + 
                                     " WHERE " + condicional);
            while (data.next()) 
            {
                is = data.getBinaryStream(1);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fechaConeccao(connection, stmt, data);
        }
        
        return is;
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
    
    public static String procedure(String proc, ArrayList<String> parametros) {
        String retorno = "";
        try {
            connection = abreConeccao();
            String parString = "{call " + proc + "(";
            for (int i = 0; i < parametros.size(); i++) {
                parString += "?, ";
            }
            parString = parString.substring(0, parString.length() - 2) + ")}";
            procStmt = connection.prepareCall(parString);
            
            for (int i = 0; i < parametros.size(); i++) {
                procStmt.setString(i+1, parametros.get(i));
            }
            
            procStmt.execute();
            data = procStmt.getResultSet();
            data.next();
            retorno = data.getString("id");
                      
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fechaConeccao(connection, procStmt, data);
        }
        return retorno;  
    }
    
    public static InputStream procedure(String cpf) {
        InputStream is = null;
      
        try {
            connection = abreConeccao();
            String parString = "{call GerarImagem(?)}";
            procStmt = connection.prepareCall(parString);            

            procStmt.setString(1, cpf);

            
            procStmt.execute();
            data = procStmt.getResultSet();
            while (data.next()) 
            {
                is = data.getBinaryStream(1);
            }
                      
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fechaConeccao(connection, procStmt, data);
        }
        return is;  
    }
}

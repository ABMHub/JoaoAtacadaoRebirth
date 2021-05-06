
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
    
    // Metodo para abrir a coneccao
    private static Connection abreConeccao() throws SQLException {
        return DriverManager.getConnection(Endereco.url, Endereco.usuario, Endereco.senha); // Estabelece a conexão
    }
    
    // Metodo para encerrar a coneccao
    private static Boolean fechaConeccao(Connection coneccao, Statement stmt, ResultSet resultados) {
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
    
    // Metodo para encerrar a coneccao
    private static Boolean fechaConeccao(Connection coneccao, CallableStatement stmt, ResultSet resultados) {
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

    // Metodo para atualizar uma imagem ('arquivo') em uma determinada 'tabela' no banco, passando sua 'chave' primaria que servira como condicional.
    public static boolean update(String tabela, String chave, File arquivo) throws FileNotFoundException, IOException, SQLException
    {
        boolean deuCerto = true;
        connection = abreConeccao();
        connection.setAutoCommit(false);
        
        try (FileInputStream fis = new FileInputStream(arquivo);
            PreparedStatement ps = connection.prepareStatement("UPDATE " + tabela + " SET imagem = (?) WHERE " + chave + ";")) 
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
    
    // Metodo para inserir 'valores' em uma 'tabela' qualquer
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
    
    // Metodo para inserir registros de 'produto', assim como criar suas especializacoes, passando o nome da especializacao ('tabela'), e os valores para cada
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
    
    // Metodo para selecionar determinada 'pag'ina, delimitada para cada 10 registros, de uma 'tabela' especifica
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
    
    // Mesmo metodo anterior, mas com a possibilidade de se usar uma 'condicional'.
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
    
    // Metodo que seleciona determinada imagem de 'tabela' a partir de uma 'condicional'
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
    
    // Metodo para selecionar determinadas 'colunas' de uma 'tabela', a partir de uma condicional
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
    
    // Metodo para atualizar determinado 'dado' de uma 'tabela', a partir de uma 'condicional'
    public static void update(String tabela, String dados, String condicional) {
        try {
            connection = abreConeccao();
            stmt = connection.createStatement();
            
            stmt.execute("UPDATE " + tabela + " SET " + dados + " WHERE " + condicional);            
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fechaConeccao(connection, stmt, data);
        }
    }
    
    // Metodo para deletar determinado registro de uma 'tabela', de acordo com dada 'condicional'
    public static void delete(String tabela, String condicional) {
        try {
            connection = abreConeccao();
            stmt = connection.createStatement();
            stmt.execute("DELETE FROM " + tabela + " WHERE " + condicional);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fechaConeccao(connection, stmt, data);
        }
    }
    
    // Metodo para chamar uma procedure ('proc') com 'parametros' especificados
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
    
    // Metodo para chamar a procedure 'GerarImagem' com 'cpf' como parametro
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

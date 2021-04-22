package joaoatacadao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import camadaDePersistencia.Conexao;
import java.sql.SQLException;
import java.util.ArrayList;
import telas.Principal;

public class JoaoAtacadao {    
    
    public static void main(String[] args) throws IOException {
        //Path path = Paths.get("dados/");
        //Files.createDirectories(path);
        
        //Conexao.create("Vestuario", "'3456', 'roupa', 10.89, 'da feira'", "'3456', 'M', 'azul'");
        //Conexao.create("funcionario", "('cpf1543', 'joao', '2020/09/02', 12, true)");
        //String r[] = Conexao.select("*", "Produto", "3456");
        
        //for(int i = 11; i < 22; i++)
        //{
        //    Conexao.create("ItemPedido", String.valueOf(i) + ", 2, 2");
        //}
        
        
        //ArrayList<String[]> lista = Conexao.select("funcionario", 0);
        new Principal().setVisible(true);
    }
    
}

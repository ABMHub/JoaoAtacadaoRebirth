package joaoatacadao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import camadaDePersistencia.Conexao;
import java.sql.SQLException;
import telas.Principal;

public class JoaoAtacadao {    
    
    public static void main(String[] args) throws IOException, SQLException {
        Path path = Paths.get("dados/");
        Files.createDirectories(path);
        
        Conexao.create("Vestuario", "'3456', 'roupa', 10.89, 'da feira'", "'3456', 'M', 'azul'");
        //Conexao.create("funcionario", "('cpf1543', 'joao', '2020/09/02', 12, true)");
        
        //new Principal().setVisible(true);
    }
    
}

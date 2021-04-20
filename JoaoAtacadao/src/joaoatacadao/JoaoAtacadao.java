package joaoatacadao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import telas.Principal;

public class JoaoAtacadao {    
    
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("dados/");
        Files.createDirectories(path);
        
        new Principal().setVisible(true);
    }
    
}

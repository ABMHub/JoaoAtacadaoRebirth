/*
 Classe responsável por fazer a validação dos dados
 */
package joaoatacadao;

import javax.swing.JOptionPane;

public class Validacao {
    //Método que verifica se uma string é um número inteiro positivo
    public static boolean ehInteiro(String string)
    {
        int i;
        
        for(i=0; i<string.length(); i++)
        {
            if(string.charAt(i) < '0' || string.charAt(i) > '9')
                return false;
        }
        return true;
    }
    
    //Método que verifica se uma string é um número real positivo
    public static boolean ehFlutuante(String string)
    {
        int i;
        int contador = 0;
        
        if(!string.equals("") && string.charAt(0) == '.')
            return false;
        
        for(i=0; i<string.length(); i++)
        {
            if((string.charAt(i) < '0' || string.charAt(i) > '9') && string.charAt(i) != '.')
            {
                return false;
            }else
            {
                if(string.charAt(i) == '.')
                {
                    contador++;
                    if(contador > 1)
                        return false;
                }
            }
        }
        return true;
    }
    
    //Método que verifica se o formato do cpf está correto
    public static boolean cpfValido(String string)
    {
        int i;
        
        if(string.equals("") || string.charAt(0) == '.' || string.charAt(0) == '-' )
            return false;
        
        for(i = 0; i<string.length(); i++)
        {
            if((string.charAt(i) < '0' || string.charAt(i) > '9') && string.charAt(i) != '.' && string.charAt(i) != '-')
                return false;
            
            if(i != 3 && i !=7 && string.charAt(i) == '.')
                return false;
            
            if(i != 11 && string.charAt(i) == '-')
                return false;  
        }
        
        return i == 14;
    }
}

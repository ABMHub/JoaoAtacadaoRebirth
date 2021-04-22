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
    
    // retorna null se é uma data inválida no formato dd/mm/aaaa
    // retorna uma data no formato aaaa/mm/dd se for uma data valida no formato dd/mm/aaaa
    public static String validaData(String data)
    {
        if(data.length() != 10)
            return null;
        
        if(data.charAt(2) != '/' && data.charAt(5) != '/')
            return null;
        
        String[] dados = data.split("/");
        
        if(ehInteiro(dados[0]) == false ||
           ehInteiro(dados[1]) == false ||
           ehInteiro(dados[1]) == false)
            return null;
        
        int dia = Integer.parseInt(dados[0]);
        int mes = Integer.parseInt(dados[1]);
        int ano = Integer.parseInt(dados[2]);
        
        if(mes > 12 || mes < 1)
            return null;
        
        if(ano < 1 || ano > 9999)
            return null;
        
        switch(mes)
        {
            case 1:
            case 3:
            case 5:
            case 7: 
            case 8:
            case 10:
            case 12:
                if(dia < 1 || dia > 31)
                    return null;
                break;
                
            case 2:
                if(ano % 4 == 0){
                    
                    if(dia < 1 || dia > 29)
                        return null;
                    
                }else if(dia < 1 || dia > 28)
                    return null;
                
                break;
                
            default:
                if(dia < 1 || dia > 30)
                    return null;
        }
        return dados[2] + "/" + dados[1] + "/" + dados[0];
    }   
}

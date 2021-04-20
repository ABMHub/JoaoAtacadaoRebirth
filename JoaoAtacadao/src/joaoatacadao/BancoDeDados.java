package joaoatacadao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BancoDeDados {
    
    // Função para concatenar dois arrays de Strings em um array só.
    public static String[] concatArray(String[] vetor, String[] vetor2) {
        String[] vetorRetorno = new String[vetor.length + vetor2.length];       // String com tamanho igual a soma do tamanho dos outros
        for (int i = 0; i < vetor.length; i++) {                                // for até o tamanho do primeiro array
            vetorRetorno[i] = vetor[i];                                         // atribui o valor da primeira string ao valor da string maior
        }
        for (int i = vetor.length; i < vetor.length + vetor2.length; i++) {     // for do tamanho do primeiro array até o tamanho do array grande
            vetorRetorno[i] = vetor2[i-vetor.length];                           // atribui o valor da segunda string ao valor da string maior
        }
        return vetorRetorno;                                                    
    }
    
    // Função para criar todos os arquivos do banco de dados
    public static void criaArquivos () throws IOException {
        File arq;
        String[] nomesArquivos = {"livros.txt", "filmes.txt", "perifericos.txt",            // Array com todos os nomes de arquivos disponíveis
            "celulares.txt", "computadores.txt", "eletroeletronicos.txt", "vestuario.txt",
            "cadastrarCliente.txt", "cadastrarFuncionario.txt"};
        
        for (int i = 0; i < nomesArquivos.length; i++) {                        // Loop para criar todos os arquivos na pasta dados
            arq = new File("dados/" + nomesArquivos[i]);
            arq.createNewFile();
        }
    }
    
    // Função para escrever dados ao final de um arquivo
    public static void escritor(String arquivo, String dadoQueSeraEscrito) throws IOException { 
        criaArquivos();
        BufferedWriter bufferDeEscrita = new BufferedWriter(new FileWriter(arquivo, true));     // Cria fileWriter com flag de "append" em true
        bufferDeEscrita.append(dadoQueSeraEscrito.trim() + "\n");               // Escreve dado no fim do arquivo, retirando os espaços desnecessários e criando um espaço no final
        
        bufferDeEscrita.close();                                                // Fecha arquivo
    }
    
    // Função para reescrever arquivo completamente com os dados passados
    public static void reescritor(String arquivo, String dadoQueSeraEscrito) throws IOException { 
        BufferedWriter bufferDeEscrita = new BufferedWriter(new FileWriter(arquivo));
        bufferDeEscrita.write(dadoQueSeraEscrito.trim() + "\n");                // Limpa arquivo anterior e escreve novo arquivo com os dados
        
        bufferDeEscrita.close();
    }
    
    // Função para pesquisar determinado código no banco, e retornar os atributos do objeto
    public static String[] pesquisa(String arquivo, String codigo) throws FileNotFoundException {
        Scanner entrada = new Scanner(new File(arquivo));
        
        if (!(entrada.hasNextLine())) {                         // Pequena função para checar se o programa acabou
            entrada.close();                                    // Caso acabe, a função encerra
            return null;                                       
        }
                    
        do {                       
            entrada.useDelimiter(",");                          // Lê até a primeira ',' lendo o código do produto/cpf do cliente
            String stringAux = entrada.next();
            
            if (!(entrada.hasNextLine())) {                         // Função para checar se o programa acabou
                entrada.close();
                return null;
            }
            
            entrada.useDelimiter("\n");                         // Termina de ler a linha do código
            entrada.next();
            stringAux = stringAux.split(":")[1];                // Isola o código ou cpf
            
            if (stringAux.equals(codigo)) {                     // Se encontramos o código/cpf, começa o algoritmo de retorno
                entrada.useDelimiter(";");                      // Termina de ler o objeto correspondente ao código
                
                String[] vetor = entrada.next().split(",");     // Separa os atributos do objeto
                for (int i = 0; i < vetor.length; i++) {        
                    vetor[i] = (vetor[i].split(":"))[1];        // Isola os atributos em um array de retorno
                }
                
                String[] aux = {codigo};
                
                entrada.close();
                return concatArray(aux, vetor);                 // Retorna os códigos + o array de retorno
            }
            
            entrada.useDelimiter(";");                          // Caso não tenha encontrado o codigo/cpf procurado, pula para o próximo objeto
            entrada.next();
                        
        } while(entrada.hasNextLine());                         // Este loop acontece enquanto o arquivo tiver dados
        
        entrada.close();
        return null;                                            // Caso não encontre o cpf/código, retorna null
    }
    
    // Função que lê todos os dados de um arquivo, de 10 em 10, usando paginação
    public static ArrayList leitura(String arquivo, int pg) throws FileNotFoundException {
        Scanner entrada = new Scanner(new File(arquivo));
        
        if (!(entrada.hasNextLine())) {                     // Encerra a função caso o arquivo termine
            entrada.close();
            return new ArrayList();
        }
        
        for (int i = 0; i < pg*10; i++) {        // Pula o arquivo até página escolhida
            if (!(entrada.hasNext()))           // Caso não seja possível chegar até a página escolhida, encerra e retorna null
                return null;
            entrada.useDelimiter(";");                      
            entrada.next();
            entrada.useDelimiter("\n");
            entrada.next();
        }
        
        ArrayList lista = new ArrayList<>();                  // Cria arraylist para a tabela
        
        for (int j = 0; j < 10; j++) {                      // Lê os 10 próximos 
            entrada.useDelimiter(";");
            String[] vetor = entrada.next().split(",");     // Separa os atributos
            
            if (!(entrada.hasNextLine())) {                 // Se o arquivo tiver acabado, retorna a lista
                entrada.close();
                return lista;
            }              

            for (int i = 0; i < vetor.length; i++) {
                vetor[i] = (vetor[i].split(":"))[1];        // Isola os atributos
            }
            lista.add(vetor);                               // Adiciona vetor na lista
            
            entrada.useDelimiter("\n");                     // Termina de ler o atributo para dar erro
            entrada.next();
            
            if (!(entrada.hasNextLine())) {                 // Se o arquivo tiver acabado, retorna a lista
                entrada.close();
                return lista;
            }                               
        }
        
        entrada.close();                                    // Fecha arquivo e retorna a arraylist
        return lista;
    }
    
    // Função interna que, dependendo do parâmetro "remover", remove ou edita um parâmetro, reescrevendo completamente o arquivo
    private static void alterar(String arquivo, String codigo, String dado, boolean remover) throws FileNotFoundException {
        Scanner entrada = new Scanner(new File(arquivo));       
        String texto = new String("");
        String codAnalise;
        String stringAux;
        
        if (!(entrada.hasNextLine())) {                                         // Função para encerrar o programa caso o arquivo acabe
            entrada.close();
            return;
        }
        
        do {                       
            entrada.useDelimiter(",");                                          // Lê código para análise
            stringAux = entrada.next();
            codAnalise = stringAux.split(":")[1];                               // Isola o código 
            
            if (codAnalise.equals(codigo)) {                                    // Caso seja o código que estamos procurando, processamos o objeto
                entrada.useDelimiter(";");                                      // Pula o objeto que encontramos
                entrada.next();                                                     
                
                entrada.useDelimiter("\n");
                entrada.next();
                
                if (!remover) {                                                 // Caso queiramos editar, adicionamos a nova versão do dado na nova versão do arquivo
                    texto = texto + "\n" + dado;
                }
                
                while (entrada.hasNextLine()) {                                 // Depois que achamos o objeto, iteraremos o restante do arquivo para salva-lo
                    entrada.useDelimiter(";");
                    texto = texto + entrada.next();
                    
                    if (!entrada.hasNextLine())
                        break;
                    
                    entrada.useDelimiter("\n");
                    texto = texto + entrada.next();
                }
            }
            
            else {                                                              // Caso não seja o que estamos procurando, salvamos ele para a nova versão do arquivo
                entrada.useDelimiter(";");
                texto = texto + stringAux + entrada.next();
                
                entrada.useDelimiter("\n");
                texto = texto + entrada.next();
            }
                        
        } while(entrada.hasNextLine());
        
        
        try {
            reescritor(arquivo, texto.trim());
        } catch (IOException ex) {
            Logger.getLogger(BancoDeDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        entrada.close();
    }
    
    // Função para editar um objeto do arquivo texto
    public static void editar (String arquivo, String codigo, String dado) throws FileNotFoundException {
        alterar(arquivo, codigo, dado, false);
    }
    
    // Função para deletar um objeto do arquivo texto
    public static void remover (String arquivo, String codigo) throws FileNotFoundException {
        alterar(arquivo, codigo, null, true);
    }
}
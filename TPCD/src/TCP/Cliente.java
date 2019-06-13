package TCP;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Giulia & Guilherme
 */
public class Cliente {
    public static void main(String[] args) throws IOException{
        String sentence;
        DataOutputStream outTo;
        DataInputStream inFrom;
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        
        Socket clientSocket = new Socket("localhost", 10000);
        outTo = new DataOutputStream(clientSocket.getOutputStream()); 
        inFrom = new DataInputStream(clientSocket.getInputStream());
        
        
        
        while(true){
            do{
                System.out.println("Escolha seu servico: ");
                sentence = keyboard.readLine(); 
                outTo.writeUTF(sentence + '\n');
               
                sentence = inFrom.readUTF();
                System.out.println(sentence);
                
                System.out.println("Deseja executar novamente? s | n : ");
                sentence = keyboard.readLine(); 
            }while(sentence.equals('s'));
            
        }
        

        //connectionSocket.close();
    }
}

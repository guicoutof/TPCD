
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Giulia
 */
public class Cliente {
    public static void main(String[] args) throws IOException{
        String sentence;
        DataOutputStream outTo;
        BufferedReader inFrom;
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        
        Socket clientSocket = new Socket("localhost", 10000);
        outTo = new DataOutputStream(clientSocket.getOutputStream()); 
        inFrom = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        
        
        while(true){
            do{
                System.out.println("Escolha seu servico: ");
                sentence = keyboard.readLine(); 
                outTo.writeBytes(sentence + '\n');
                
                sentence = inFrom.readLine();
                System.out.println("Message received from TCPC: " + sentence);
            
                System.out.println("continue: ");
                sentence = keyboard.readLine(); 
                outTo.writeBytes(sentence + '\n'); 
            }while(sentence.equals('s'));
            
        }
        

        //connectionSocket.close();
    }
}

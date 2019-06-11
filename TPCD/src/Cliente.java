
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
        BufferedReader inFrom;
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream outTo;
        
        System.out.print("Waiting for connection ... " + '\n');
        ServerSocket welcomeSocket = new ServerSocket(); 

        Socket connectionSocket = welcomeSocket.accept();
        System.out.println("Connection accepted, Socket: " + connectionSocket + '\n'); 

        welcomeSocket.close();
        
        outTo = new DataOutputStream(connectionSocket.getOutputStream()); 
        
        while(true){
            do{
                //primeiro envio
                inFrom = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
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


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
 * @author gui_c
 */
public class Servidor {
    public static void main(String[] args) throws IOException {
        try{
            int serverPort = 10000; // the server port
            ServerSocket listenSocket = new ServerSocket(serverPort);
            System.out.println("ServerSocket: " + listenSocket);
            while(true) {
                    Socket clientSocket = listenSocket.accept();
                    System.out.println("Socket after accept: " + clientSocket);
                    Connection c = new Connection(clientSocket);
            }
        } catch(IOException e) {System.out.println("Listen socket:"+e.getMessage());}
    }
}

class Connection extends Thread {
	DataInputStream in;
	DataOutputStream out;
	Socket clientSocket;
	public Connection (Socket aClientSocket) {
		try {
			clientSocket = aClientSocket;
			System.out.println("Socket in Connection: " + clientSocket);
			in = new DataInputStream( clientSocket.getInputStream());
			out = new DataOutputStream( clientSocket.getOutputStream());
			this.start();
		} catch(IOException e) {System.out.println("Connection:"+e.getMessage());}
	}
	public void run(){
		try {			                 // an echo server
                    DatagramSocket S_Socket = new DatagramSocket(10001); 
                    InetAddress IPAddress = InetAddress.getByName("localhost"); 
                    byte[] sendData = new byte[1024]; 
                    while(true){
                        String data = in.readUTF();	                  // read a line of data from the stream
                           //ler o pacote
                            //out.writeUTF(data);

                                    // UDP


                        sendData = data.getBytes();
                        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 	10002); 
                        S_Socket.send(sendPacket);

                        sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 	10003);
                        S_Socket.send(sendPacket);

                        sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 	10004);
                        S_Socket.send(sendPacket);
                    }
		}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		} catch(IOException e) {System.out.println("readline:"+e.getMessage());
		} finally{ try {clientSocket.close();}catch (IOException e){/*close failed*/}}
                

	}
}
package TCP;


import RMI.InterfaceServicos;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Giulia & Guilherme
 */
public class Servidor {
    public static void main(String[] args) throws IOException, NotBoundException {
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
        InterfaceServicos servicos;
        
	public Connection (Socket aClientSocket) throws NotBoundException {
		try {
			clientSocket = aClientSocket;
			System.out.println("Socket in Connection: " + clientSocket);
			in = new DataInputStream( clientSocket.getInputStream());
			out = new DataOutputStream( clientSocket.getOutputStream());
                        //rmi lookup
                        System.out.println(" > IP CONECTADO: "+aClientSocket.getLocalAddress());
                        servicos = (InterfaceServicos) Naming.lookup("rmi://localhost:1099/RMI");
			this.start();
		} catch(IOException e) {System.out.println("Connection:"+e.getMessage());}
	}
	public void run(){
		try {			                 // an echo server
                    byte[] sendData = new byte[1024]; 
                    while(true){
                        String data = in.readUTF();
                        String[] argumentos = data.split(" ");
                        String resposta = ""; 
                        
                        switch(Integer.valueOf(argumentos[0])){
                            case 1:
                                String[] params = argumentos[1].split("/");
                                resposta += servicos.signo(Integer.valueOf(params[0]),Integer.valueOf(params[1]));
                                break;
                            case 2:
                                resposta += servicos.imc(Float.valueOf(argumentos[1]),Float.valueOf(argumentos[2]));
                                break;
                            case 3:
                                resposta += servicos.impostoRenda(Float.valueOf(argumentos[1]),Integer.valueOf(argumentos[2]),Integer.valueOf(argumentos[3]));
                                break;
                            default:
                                resposta += "Servico nao encontrado";
                                break;
                        }
                        out.writeUTF("> " + resposta + "\n");    //resposta ao cliente

                    }
		}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		} catch(IOException e) {System.out.println("readline:"+e.getMessage());
		} finally{ try {clientSocket.close();}catch (IOException e){/*close failed*/}}
                

	}
}
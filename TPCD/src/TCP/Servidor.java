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
            int serverPort = 10000; //porta do servidor
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
        
	public Connection (Socket cSocket) throws NotBoundException {
		try {
			clientSocket = cSocket;
			System.out.println("Socket in Connection: " + clientSocket);
			in = new DataInputStream( clientSocket.getInputStream());
			out = new DataOutputStream( clientSocket.getOutputStream());

                        System.out.println(" > IP CONECTADO: "+clientSocket.getLocalAddress());
                        servicos = (InterfaceServicos) Naming.lookup("rmi://localhost:1099/RMI");
			this.start();
		} catch(IOException e) {
                    System.out.println("Connection:"+e.getMessage());
                }
	}
	public void run(){
		try {			                 
                    while(true){
                        String data = in.readUTF();
                        String[] args = data.split(" ");
                        String resposta = ""; 
                        
                        switch(Integer.valueOf(args[0])){
                            case 1://servico de identificacao astrologica
                                String[] params = args[1].split("/");
                                resposta += servicos.signo(Integer.valueOf(params[0]),Integer.valueOf(params[1]));
                                break;
                            case 2://servico de indice de massa corporal
                                resposta += servicos.imc(Float.valueOf(args[1]),Float.valueOf(args[2]));
                                break;
                            case 3:// servico de calculo do imposto de renda retido na fonte
                                resposta += servicos.impostoRenda(Float.valueOf(args[1]),Integer.valueOf(args[2]),Integer.valueOf(args[3]));
                                break;
                            default:
                                resposta += "Servico nao encontrado";
                                break;
                        }
                        out.writeUTF("> " + resposta + "\n");    //resposta ao cliente

                    }
		}catch (EOFException e){
                    System.out.println("EOF:"+e.getMessage());
		} catch(IOException e) {
                    System.out.println("readline:"+e.getMessage());
		} finally{
                    try {
                        clientSocket.close();
                    }catch (IOException e){/*close failed*/
                    }
                }
	}
}

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Guilherme Couto
 */
public class MensageiroImpl extends UnicastRemoteObject implements Mensageiro{
    
    public MensageiroImpl() throws RemoteException{
        super();
    }
    
    public void enviarMensagem(String msg) throws RemoteException{
        System.out.println(msg);
    }
    
    public String lerMensagem() throws RemoteException{
        return "This is not a Hello World! message";
    }
    
}

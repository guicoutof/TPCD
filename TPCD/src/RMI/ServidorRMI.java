/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Giulia & Giulherme
 */
public class ServidorRMI {
    
    public ServidorRMI() throws RemoteException{
        String name = "RMI";                //nome do local do método remoto
        int rmiPort = 1099;                 //porta do RMI
        String host = "localhost";          //host do RMI
        String rmiUrl = "rmi://"+host+":";  //URL base do RMI

        InterfaceServicos engine = new Servicos();   //instanciando os servicos
        Registry registry = LocateRegistry.createRegistry(rmiPort);
        System.out.println("RMI funcionando na porta: "+rmiPort);
        registry.rebind(name, engine);              //associando nome à isntancia
        System.out.println("Endereço RMI: \""+rmiUrl+rmiPort+"/"+(registry.list()[0])+"\"");        
    }

    public static void main (String[] args) throws RemoteException{
        new ServidorRMI();
    }
}

package service3;


import service1.ZodiacSign;
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
public class EjcompBirthdayImpl extends UnicastRemoteObject implements EjcompBirthday{
    
    public EjcompBirthdayImpl() throws RemoteException{
        super();
    }
    
    public void calculateSign(String dia,String mes,String ano) throws RemoteException{
        System.out.println("Couto");
    }
    

    
}

package service1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.Month;
/**
 *
 * @author Guilherme Couto
 */
public interface ZodiacSign extends Remote{
    public String calculateSign(int dia,String mes)throws RemoteException;
}

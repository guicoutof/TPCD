/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Giulia & Guilherme 
 */
public interface InterfaceServicos extends Remote{// Interface dos Servicos 
    
    String signo(int dia,int mes) throws RemoteException;
    String imc(float altura,float peso) throws RemoteException;
    String impostoRenda(float base,int nDp,int inss) throws RemoteException;

}

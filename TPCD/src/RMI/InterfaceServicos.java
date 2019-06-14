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
public interface InterfaceServicos extends Remote{
    
    String signo(int dia,int mes) throws RemoteException;
    String imc(float altura,float peso) throws RemoteException;
    float impostoRenda(float base,int nDp,int inss) throws RemoteException;
//
//    float soma(float num1, float num2)           throws RemoteException;
//    float subtracao (float num1, float num2)     throws RemoteException;
//    float divisao (float num1, float num2)       throws RemoteException;
//    float multiplicacao (float num1, float num2) throws RemoteException;
//    float exponencial (float num1, float num2)   throws RemoteException;
//    float fatorial (float num1)                  throws RemoteException;
}

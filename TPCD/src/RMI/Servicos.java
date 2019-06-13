/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Giulia & Giulherme
 */
public class Servicos extends UnicastRemoteObject implements InterfaceServicos{

    public Servicos () throws RemoteException{
        super();
    }
    
    @Override
    public String signo(int dia, int mes) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String imc(int altura,float peso) throws RemoteException {
        float imc = peso/(altura*altura);
        if(imc < 18.5f){
            return imc + " : abaixo do peso";
        }else if(imc >= 18.5f && imc < 25){
            return imc + " : peso normal";
        }else if(imc >= 25 && imc < 30){
            return imc + " : sobrepeso";
        }else if(imc >= 30 && imc < 35){
            return imc + " : obesidade grau 1";
        }else if(imc >= 35 && imc < 40){
            return imc + " : obesidade grau 2";
        }else if(imc >= 40){
            return imc + " : obesidade grau 3";
        }
        return "Dados invalidos";
    }

    @Override
    public float impostoRenda(float base,int nDp,boolean inss) throws RemoteException {
        float aliquota = 1f;
        float descInss;
        float deducao = 0f;
        if(base < 1903.98f){
            return 0;
        }else{
            if(inss){
                 descInss = base*0.12f;
            }else  descInss = 0f;
            
            if(base >= 1903.99f && base <=2862.65f ){
                aliquota = 0.075f;
                deducao = 142.80f;
            }else if(base > 2862.65f && base <= 3751.05f){
                aliquota = 0.15f;
                deducao = 354.80f;
                
            }else if(base > 3751.05f && base <= 4664.68){
                aliquota = 0.225f;
                deducao = 636.13f;
            }else if(base > 4664.68f){
                aliquota = 27.5f;
                deducao = 869.36f;
            }
        }
        
        float IR = ((base-(nDp*2275.08f)-descInss)*aliquota)-deducao;//imposto de renda retido na fonte
        
        if(IR>=0)
            return IR;
        else
            return 0;
         
    }
    
}

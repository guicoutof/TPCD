package service1;


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
public class ZodiacSignImpl extends UnicastRemoteObject implements ZodiacSign{
    
    public ZodiacSignImpl() throws RemoteException{
        super();
    }
    
    public String calculateSign(String dia,String mes) throws RemoteException{
        
        int day = Integer.parseInt(dia);
        mes = mes.toLowerCase();
        
        if((mes.equals("janeiro") && (day>20)) || (mes.equals("fevereiro") && (day<18))){
            return "Aquario";
        }else if((mes.equals("fevereiro") && (day>19)) || (mes.equals("março") && (day<20))){
            return "Peixes";
        }else if((mes.equals("março") && (day>21)) || (mes.equals("abril") && (day<19))){
            return "Aries";
        }else if((mes.equals("abril") && (day>20)) || (mes.equals("maio") && (day<20))){
            return "Touro";
        }else if((mes.equals("maio") && (day>21)) || (mes.equals("junho") && (day<20))){
            return "Gemeos";
        }else if((mes.equals("junho") && (day>21)) || (mes.equals("julho") && (day<22))){
            return "Cancer";
        }else if((mes.equals("julho") && (day>23)) || (mes.equals("agosto") && (day<22))){
            return "Leao";
        }else if((mes.equals("agosto") && (day>23)) || (mes.equals("setembro") && (day<22))){
            return "Virgem";
        }else if((mes.equals("setembro") && (day>23)) || (mes.equals("outubro") && (day<22))){
            return "Libra";
        }else if((mes.equals("outubro") && (day>23)) || (mes.equals("novembro") && (day<21))){
            return "Escorpiao";
        }else if((mes.equals("novembro") && (day>22)) || (mes.equals("dezembro") && (day<21))){
            return "Sagitario";
        }else if((mes.equals("dezembro") && (day>22)) || (mes.equals("janeiro") && (day<19))){
            return "Capricornio";
        }else 
            return "Signo não encontrado";
    }
    
    
}

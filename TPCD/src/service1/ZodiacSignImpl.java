package service1;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.Month;

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
    
    public String calculateSign(int dia,Month mes) throws RemoteException{
        
        int day = dia;
//        mes = mes.toLowerCase();
        
        if((mes.equals(Month.JANUARY) && (day>20)) || (mes.equals(Month.FEBRUARY) && (day<18))){
            return "Aquario";
        }else if((mes.equals(Month.FEBRUARY) && (day>19)) || (mes.equals(Month.MARCH) && (day<20))){
            return "Peixes";
        }else if((mes.equals(Month.MARCH) && (day>21)) || (mes.equals(Month.APRIL) && (day<19))){
            return "Aries";
        }else if((mes.equals(Month.APRIL) && (day>20)) || (mes.equals(Month.MAY) && (day<20))){
            return "Touro";
        }else if((mes.equals(Month.MAY) && (day>21)) || (mes.equals(Month.JUNE) && (day<20))){
            return "Gemeos";
        }else if((mes.equals(Month.JUNE) && (day>21)) || (mes.equals(Month.JULY) && (day<22))){
            return "Cancer";
        }else if((mes.equals(Month.JULY) && (day>23)) || (mes.equals(Month.AUGUST) && (day<22))){
            return "Leao";
        }else if((mes.equals(Month.AUGUST) && (day>23)) || (mes.equals(Month.SEPTEMBER) && (day<22))){
            return "Virgem";
        }else if((mes.equals(Month.SEPTEMBER) && (day>23)) || (mes.equals(Month.OCTOBER) && (day<22))){
            return "Libra";
        }else if((mes.equals(Month.OCTOBER) && (day>23)) || (mes.equals(Month.NOVEMBER) && (day<21))){
            return "Escorpiao";
        }else if((mes.equals(Month.NOVEMBER) && (day>22)) || (mes.equals(Month.DECEMBER) && (day<21))){
            return "Sagitario";
        }else if((mes.equals(Month.DECEMBER) && (day>22)) || (mes.equals(Month.JANUARY) && (day<19))){
            return "Capricornio";
        }else 
            return "Signo não encontrado";
    }
    
    
}

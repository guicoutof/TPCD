/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.Naming;
/**
 *
 * @author Guilherme Couto
 */
public class MensageiroServer {
    
    public MensageiroServer(){
        try {
            Mensageiro m = new MensageiroImpl();
            Naming.rebind("rmi://localhost:1099/MensageiroService", m);
        } catch (Exception e) {
            System.out.println("Trouble: "+ e);
        }
    }
    
    public static void main(String[] args){
        new MensageiroServer();
    }
    
}

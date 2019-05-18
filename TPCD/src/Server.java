/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import service1.ZodiacSignImpl;
import service1.ZodiacSign;
import java.rmi.Naming;
/**
 *
 * @author Guilherme Couto
 */
public class Server {
    
    public Server(){
        try {
            ZodiacSign z = new ZodiacSignImpl();
            Naming.rebind("rmi://localhost:1099/ZodiacService", z);
        } catch (Exception e) {
            System.out.println("Trouble: "+ e);
        }
    }
    
    public static void main(String[] args){
        new Server();
    }
    
}

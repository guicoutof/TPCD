
import service1.ZodiacSign;
import java.rmi.Naming;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Guilherme Couto
 */
public class Client {
    
    public static void main(String args[]){
        try {
            ZodiacSign z = (ZodiacSign)
                Naming.lookup("rmi://localhost:1099/ZodiacService");
//            System.out.println(m.lerMensagem());
//            m.calculateSign("Hello World!");
        } catch (Exception e) {
            System.out.println();
            System.out.println("MalformedURLException: "+ e.toString());
        }
    }
    
}

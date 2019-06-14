package TCP;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Giulia & Guilherme
 */
public class Cliente {
    public static void main(String[] args) throws IOException{
        DataOutputStream outTo;
        DataInputStream inFrom;
        
        Socket clientSocket = new Socket("localhost", 10000);
        outTo = new DataOutputStream(clientSocket.getOutputStream()); 
        inFrom = new DataInputStream(clientSocket.getInputStream());
        
        Object[] selectionValues = { "Signo", "IMC", "Imposto de Renda" };
        String initialSelection = "Signo";
        
        int aux;
        do{
            String sentence = "";
            
            Object selection = JOptionPane.showInputDialog(null, "Qual servico deseja realizar ?","Trabalho CD", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);

            if(selection != null && selection.equals("Signo")){
                sentence += "1 ";
                sentence += JOptionPane.showInputDialog(null,"Insira sua data de nascimento no formato 01/01/2001 :") + " ";
                
            }else if(selection != null && selection.equals("IMC")){
                sentence += "2 ";
                sentence += JOptionPane.showInputDialog(null,"Insira sua altura em metros, ex 1.75 :") + " ";
                sentence += JOptionPane.showInputDialog(null,"Insira seu peso em kilos, ex 65.5 :") + " ";
                
            }else if(selection != null && selection.equals("Imposto de Renda")){
                sentence += "3 ";
                sentence += JOptionPane.showInputDialog(null,"Insira seu salario base, ex 3200.50 :") + " ";
                sentence += JOptionPane.showInputDialog(null,"Insira quantos dependentes voce possui, ex 2 :") + " ";
                sentence += JOptionPane.showConfirmDialog(null,"Você possui um Plano Gerador de Benefício Livre (PGBL) ou um Fundo de Aposentadoria Programada Individual (Fapi) ? ") + " ";

            }

            if(sentence.length()>1){
                outTo.writeUTF(sentence + '\n');

                sentence = inFrom.readUTF();
                JOptionPane.showMessageDialog(null, sentence);
            }
            
            aux = JOptionPane.showConfirmDialog(null,"Deseja executar novamente ?");

        }while(aux == 0);
            
        
        

        connectionSocket.close();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DecimalFormat;

/**
 *
 * @author Giulia & Guilherme
 */
public class Servicos extends UnicastRemoteObject implements InterfaceServicos{
    DecimalFormat formatter = new DecimalFormat("#.00");
    
    public Servicos () throws RemoteException{
        super();
    }
    
    
    //https://www.astrocentro.com.br/blog/astrologia/datas-cada-signo/
    @Override
    public String signo(int dia, int mes) throws RemoteException {
        
        if(dia > 31 || dia < 1 || mes < 1 || mes > 12)return "Data invalida";
        
        if((dia >= 21 && mes == 3) || (dia <= 20 && mes == 4)){
            return "Aries";
        }else if((dia >= 21 && mes == 4) || (dia <= 20 && mes == 5)){
            return "Touro";
        }else if((dia >= 21 && mes == 5) || (dia <= 20 && mes == 6)){
            return "Gêmeos";
        }else if((dia >= 21 && mes == 6) || (dia <= 22 && mes == 7)){
            return "Câncer";
        }else if((dia >= 23 && mes == 7) || (dia <= 22 && mes == 8)){
            return "Leão";
        }else if((dia >= 23 && mes == 8) || (dia <= 22 && mes == 9)){
            return "Virgem";
        }else if((dia >= 23 && mes == 9) || (dia <= 22 && mes == 10)){
            return "Libra";
        }else if((dia >= 23 && mes == 10) || (dia <= 21 && mes == 11)){
            return "Escorpião";
        }else if((dia >= 22 && mes == 11) || (dia <= 21 && mes == 12)){
            return "Sagitário";
        }else if((dia >= 22 && mes == 12) || (dia <= 20 && mes == 1)){
            return "Capricórnio";
        }else if((dia >= 21 && mes == 1) || (dia <= 18 && mes == 2)){
            return "Aquário";
        }else if((dia >= 19 && mes == 2) || (dia <= 20 && mes == 3)){
            return "Peixes";
        }else
            return "Data invalida";
        
    }

    
    //https://www.minhavida.com.br/alimentacao/tudo-sobre/32159-imc
    @Override
    public String imc(float altura,float peso) throws RemoteException {
        float imc = peso/(altura*altura);
        
        if(imc < 18.5f){
            return formatter.format(imc) + " : abaixo do peso";
        }else if(imc >= 18.5f && imc < 25){
            return formatter.format(imc) + " : peso normal";
        }else if(imc >= 25 && imc < 30){
            return formatter.format(imc) + " : sobrepeso";
        }else if(imc >= 30 && imc < 35){
            return formatter.format(imc) + " : obesidade grau 1";
        }else if(imc >= 35 && imc < 40){
            return formatter.format(imc) + " : obesidade grau 2";
        }else if(imc >= 40){
            return formatter.format(imc) + " : obesidade grau 3";
        }
        return "Dados invalidos";
    }

    
    //https://artigos.toroinvestimentos.com.br/irpf/tabela-imposto-de-renda-2019-aliquota
    @Override
    public String impostoRenda(float base,int nDp,int inss) throws RemoteException {
        float aliquota = 1f;
        float descInss;
        float deducao = 0f;
        System.out.println(base + " "+ nDp + " "+ inss);
        if(base < 1903.98f){
            return "IR retido na fonte : R$ " + 0f;
        }else{
            if(inss==0){
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
                aliquota = 0.275f;
                deducao = 869.36f;
            }
        }
        
        float IR = ((base-(nDp*2275.08f)-descInss)*aliquota)-deducao;//imposto de renda retido na fonte
        
        if(IR>=0)
            return "IR retido na fonte : R$ " + formatter.format(IR);
        else
            return "IR retido na fonte : R$ " + 0f;
        
    }
    
}

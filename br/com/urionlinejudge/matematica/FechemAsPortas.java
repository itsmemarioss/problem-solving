package br.com.urionlinejudge.matematica;

import java.util.Scanner;

/**
 * URI Online Judge | 1371
 * Fechem as Portas!
 * 
 * https://www.urionlinejudge.com.br/judge/pt/problems/view/1371
 * 
 * @author mario
 *
 */
public class FechemAsPortas {
 
    public static void main(String[] args) {
        int entrada;
        Scanner scan = new Scanner(System.in);
 
        while (true) {
            entrada = scan.nextInt();
            if (entrada == 0)
                break;
            
            String saida = "";
            
            int impar = 3;
            int valor = 1;
            
            System.out.print(1);
            
            if(entrada > 3){
              while((valor + impar) <= entrada){
                valor = valor + impar;
                
                System.out.print(" "+valor);               
                impar += 2;
              }
            }
            
            System.out.println("");
             
        }
 
    }
 
}

package strings;

import java.util.*;
import java.io.*;

/**
 * URI Online Judge | 1238
 * https://www.urionlinejudge.com.br/judge/pt/problems/view/1238
 * */
public class Combinador{

  public static void main(String... args) throws IOException{
	Scanner scan = new Scanner(System.in);
	
    while( scan.hasNext() ){
		int testes = scan.nextInt();// casos de teste
		for(int i = 0; i < testes; i++ ){
			String a = scan.next();
			String b = scan.next();
			
			System.out.println(combina(a,b));
		}		
	}	
  }
  
  public static String combina (String a, String b){
	  
	  int tamanho = a.length() + b.length();
	  boolean existeMaior = a.length() != b.length();
	  
	  int menor = a.length() >= b.length()? b.length(): a.length();
	  
	  char [] retorno = new char[tamanho];
	  
	  int pos = 0; 
	  for(int i = 0; i < menor;i++){
		 pos = i*2;
		 retorno[pos] = a.charAt(i);
		 pos++;
		 retorno[pos] = b.charAt(i);
	  }
	  
	  if(existeMaior){

		  ++pos; //incrementa pos para a prox posicao
		  
		  String maior = a.length() > b.length()? a : b;
		  
		  for(int i = pos; i < retorno.length; i++){
			  retorno[i] = maior.charAt(menor);
			  menor++;
		  }
	  }
	  
	  return new String(retorno);
  }
  
}

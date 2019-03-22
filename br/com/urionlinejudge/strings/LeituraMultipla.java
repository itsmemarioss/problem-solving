package br.com.urionlinejudge.strings;
import java.util.Scanner;
import java.io.IOException;

//URI Online Judge | 1262
public class LeituraMultipla{
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String... args) throws IOException{
		String entrada;
		int processos;
		while(scan.hasNext()){
			entrada = scan.next();
			processos = scan.nextInt();
			System.out.println(minimoCiclos(entrada, processos));
		}
	}
	
	static int minimoCiclos(String entrada, int processos){
		int retorno = 0 , count  = 0;
		char[] comandos = entrada.toCharArray();
		
		for(char c : comandos){
			if(c == 'W'){
				retorno++;
				if(count > 0) retorno++;
				count = 0;
			}else {
				count++;
				if (count == processos){
					retorno++;
					count = 0;
				}				
			}
		}
		
		if(count >0) retorno++;
		
		return retorno;
	}
}

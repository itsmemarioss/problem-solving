package adhoc;

import java.util.Scanner;

/**
 * URI Online Judge | 1087
 * Dama
 * https://www.urionlinejudge.com.br/judge/pt/problems/view/1087
 * 
 * @author mario
 *
 */
public class Dama{
	
	private static Scanner scan = new Scanner(System.in);
	private static String entrada;
	private static String[] vetor;
	
	public static void main(String[] args){
				
		while( !(entrada = scan.nextLine()).equals("0 0 0 0")){
					
			vetor = entrada.split(" ");
			
			if(vetor[0].equals(vetor[2]) && vetor[1].equals(vetor[3]) ){
				System.out.println("0");
			}else {
				System.out.println(movimentos());
			}			
		}//fim while
	}
	
	private static String movimentos(){
		String retorno = null;
		
		//rainha
		int x1 = Integer.parseInt(vetor[0]);
		int y1 = Integer.parseInt(vetor[1]);
		
		//posi?ao
		int x2 = Integer.parseInt(vetor[2]);
		int y2 = Integer.parseInt(vetor[3]);
		
		if( Math.abs(x1 - x2) == Math.abs(y1 - y2)){//diagonal
			retorno = "1";
		}else if ((x1==x2)||(y1==y2)){			
			retorno = "1";
		}else {
			retorno = "2";
		}
			
		return retorno;
	}

}

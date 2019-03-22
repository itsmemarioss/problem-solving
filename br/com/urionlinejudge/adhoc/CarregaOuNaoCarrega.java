package br.com.urionlinejudge.adhoc;

import java.util.*;
import java.io.IOException;
 
/**
 * URI Online Judge | 1026
 * Carrega ou não Carrega?
 * 
 * https://www.urionlinejudge.com.br/judge/pt/problems/view/1026
 * 
 * @author mario
 *
 */
public class CarregaOuNaoCarrega {
 
    public static void main(String[] args) throws IOException {
 
      	Scanner scan = new Scanner(System.in);
	
        while( scan.hasNext() ){
    		long a = scan.nextLong();
    		long b = scan.nextLong();
    		
    		System.out.println(a^b);
    	}

    }
 
}
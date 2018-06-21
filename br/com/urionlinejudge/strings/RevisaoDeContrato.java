package br.com.urionlinejudge.strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * URI Online Judge | 1120
 * Revisão de Contrato
 * 
 * https://www.urionlinejudge.com.br/judge/pt/problems/view/1120
 * 
 * @author mario
 *
 */
public class RevisaoDeContrato {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		while(line != null && line.charAt(0)!='0'){
			
			try{
				System.out.println(new BigInteger( line.substring(2).replace(line.charAt(0)+"", ""))  );			
			}catch(Exception e){
				System.out.println(0);
			}
			
			line = br.readLine();
		}
		
	}

}

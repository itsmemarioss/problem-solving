package br.com.urionlinejudge.matematica;

import java.util.Scanner;
import java.io.IOException;

//URI Online Judge | 1647
public class UmJogoComBolasDeGude{
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String... args) throws IOException{
		String entrada;
		while( !(entrada = scan.nextLine()).equals("0") ){			
			String[] bacias = scan.nextLine().split(" ");
			
			long total = 0;
			for(int i = bacias.length - 1; i >= 0; i--){
				total += (Integer.parseInt(bacias[i])+total);
			}
			System.out.println(total);
		}
	}
}


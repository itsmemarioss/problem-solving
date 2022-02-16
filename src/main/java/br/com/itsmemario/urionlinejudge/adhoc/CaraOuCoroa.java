package br.com.itsmemario.urionlinejudge.adhoc;

import java.util.*;
import java.io.*;

/**
 * URI Online Judge | 1329
 * */
public class CaraOuCoroa{
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException{
		int mary = 0, jhon = 0, times = 0, played = 0;

		while( scan.hasNext() ){
			
			if ( (times = scan.nextInt()) == 0 ) break;
			for( int i = 0; i < times; i++){
				played = scan.nextInt();
				
				if (played == 0) 
					mary++;
				else 
					jhon++;
			}//end for
			
			System.out.println("Mary won "+mary+" times and John won "+jhon+" times");
			mary = jhon = 0;
		}
	}
}


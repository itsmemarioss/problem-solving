package br.com.urionlinejudge.adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * URI Online Judge | 1031
 * https://www.urionlinejudge.com.br/judge/pt/problems/view/1031
 * 
 * @author mario
 *
 */
public class CriseDeEnergia {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;

		while (!(line = br.readLine()).equals("0")) {
			boolean[] array = new boolean[Integer.parseInt(line)];
			int desligadas = 0;
			int pulo = 1;

			for (int i = 0;;) {
				array[i]=true;
				desligadas++;
				
				//desligando a central por ultimo
				if(i==12){
					if(desligadas == array.length){
						System.out.println(pulo);
						break;
					}else{
						i=0;
						pulo++;
						desligadas=0;
						array = new boolean[array.length];
					}
						
				}else{
					for(int a = 0;a<pulo;a++){
						i++;
						if(i>=array.length)i=0;
						while(array[i]){//pula estações desligadas
							i++;
							if(i>=array.length)i=0;
						}
					}
				}
				
			}

		}

	}
	
}
package br.com.itsmemario.urionlinejudge.iniciante;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * URI Online Judge | 1011
 * @author mario
 *
 */
public class Esfera {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final double PI = 3.14159;
	
	public static void main(String[] args) throws IOException{
		
		String line = null;
		
		while ( (line = br.readLine()) != null) {
			calculaEImprimeVolume(line);
		}
		
	}//fim main
	
	/**
	 *  (4/3) * pi * R3
	 * @param raio
	 * @return
	 */
	private static void calculaEImprimeVolume(String raio){
		double r = Double.valueOf(raio);
		double volume = (4/3.0)*PI*(Math.pow(r, 3));
		
		System.out.printf("VOLUME = %.3f%n", volume);
	}
	
}

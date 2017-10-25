package estruturasebibliotecas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * URI Online Judge | 1022
 * TDA Racional 
 * Timelimit: 1
 * 
 * https://www.urionlinejudge.com.br/judge/pt/problems/view/1022
 * 
 * @author mario
 *
 */
public class TdaRacional {
	
	private static final int N1 = 0;
	private static final int D1 = 2;
	
	private static final int N2 = 4;
	private static final int D2 = 6;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		while( (line = br.readLine()) !=null ) {
			
			if(line.contains("/")) {
				System.out.println(realizaOperacao(line.split(" ")) );
			}
			
		}
		
	}

	private static String realizaOperacao(String[] line) {
		int n, d =0;
		//Integer.parseInt(line[0])
		switch ( line[3]) {
		case "+": 
			n = (Integer.parseInt(line[N1]) * Integer.parseInt(line[D2])) + (Integer.parseInt(line[N2]) * Integer.parseInt(line[D1]));
			d = (Integer.parseInt(line[D1]) * Integer.parseInt(line[D2]));
			return String.format("%d/%d = %s", n,d,simplificar(n,d));
		case "-": 
			n = (Integer.parseInt(line[N1]) * Integer.parseInt(line[D2])) - (Integer.parseInt(line[N2]) * Integer.parseInt(line[D1]));
			d = (Integer.parseInt(line[D1]) * Integer.parseInt(line[D2]));
			return String.format("%d/%d = %s", n,d,simplificar(n,d));
		case "*": 
			n = (Integer.parseInt(line[N1]) * Integer.parseInt(line[N2]));
			d = (Integer.parseInt(line[D1]) * Integer.parseInt(line[D2]));
			return String.format("%d/%d = %s", n,d,simplificar(n,d));
		case "/": 
			n = (Integer.parseInt(line[N1]) * Integer.parseInt(line[D2]));
			d = (Integer.parseInt(line[N2]) * Integer.parseInt(line[D1]));
			return String.format("%d/%d = %s", n,d,simplificar(n,d));
		default:
			return null;
		}
		
	}

	private static String simplificar(int n, int d) {
		int maior = n>d ? n:d;
		int fator = 1;
		
		for (int i = 1; i <= maior; i++) {
			if(n%i==0 && d%i==0 ) fator = i;
			if(i > Math.abs(n) )break;
		}
		//System.out.println("fator:"+fator);
		return (n/fator)+"/"+(d/fator);
	}
	
}

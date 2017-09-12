package adhoc;

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
			// variáveis de controle
			int entrada = Integer.parseInt(line);
			boolean[] array = new boolean[entrada];
			int desligadas = 0;
			int pulo = 1;

			// lógica
			if (entrada == 13) {
				System.out.println(1);
			} else {
				FOR: for (int i = 0;;) {
					array[i]=true;
					desligadas++;
					
					//desligando a central por ultimo
					if(i==12){
						if(desligadas == array.length){
							System.out.println(pulo);
							break FOR;
						}else{
							i=0;
							pulo++;
							desligadas=0;
							array = new boolean[entrada];
						}
							
					}else{
						for(int a = 0;a<pulo;a++){
							i++;
//							System.out.println("i:"+i);
							if(i>=array.length)i=0;
							while(array[i]){//pula estações desligadas
								i++;
								if(i>=array.length)i=0;
							}
						}
					}
					
				}

			}//fim else
		} // while end

	}
	
}
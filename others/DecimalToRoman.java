package others;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DecimalToRoman {
	
	private static Map<Integer, String> decToRoman = new TreeMap<>();
	private static Map<String, Integer> romanToDec = new HashMap<>();
	
	static{
		decToRoman.put(1, "I");
		decToRoman.put(5, "V");
		decToRoman.put(10, "X");
		decToRoman.put(50, "L");
		decToRoman.put(100, "C");
		
		romanToDec.put("I", 1);
		romanToDec.put("V", 5);
		romanToDec.put("X", 10);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true){
			
			Integer number = Integer.parseInt(scan.nextLine());
			System.out.println(convert(number));
		}
		
	}

	private static String convert(Integer number) {
		
		String result = decToRoman.get(number);
		if(result!=null){
			return result;
		}else{
			StringBuilder roman = new StringBuilder();

			int sum = 0;
			boolean add = true;
			int anterior = 0;
			
			FOR:for(Integer i : decToRoman.keySet()){
				
				sum = i;
				
				if(anterior==0)
					anterior = i;
				
				roman.append(decToRoman.get(i));
				add = sum < number;
								
				WHILE:while(!roman.toString().matches(".*I{3}$")){
					if(add){
						sum += anterior;
						roman.append(decToRoman.get(anterior));
					}else{
						sum -= anterior;
						roman.insert(0, decToRoman.get(anterior));
					}
				
					if(sum==number){
						break FOR;
					}
					
					add = sum < number;
				}
				
				roman.setLength(0);
			}
			return roman.toString();	
		}
		
		
	}

}

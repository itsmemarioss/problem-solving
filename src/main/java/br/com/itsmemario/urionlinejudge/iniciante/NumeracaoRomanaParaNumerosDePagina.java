package br.com.itsmemario.urionlinejudge.iniciante;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * URI Online Judge | 1960 Numeração Romana para Números de Página Por M.C.
 * Pinto, UNILA BR Brazil Timelimit: 1
 * 
 * https://www.urionlinejudge.com.br/judge/pt/problems/view/1960
 * 
 * @author mario
 *
 */
public class NumeracaoRomanaParaNumerosDePagina {

	public static String convert(char c, String ini, String m, String f) {
		int num = Integer.parseInt(c + "");

		String result = "";
		if (num != 0) {
			if (num <= 3) {
				for (int i = 0; i < num; i++) {
					result += ini;
				}
			} else if (num < 9) {
				int diff = num - 5;

				for (int i = 0; i < Math.abs(diff); i++) {
					result += ini;
				}

				if (diff < 0) {
					result += m;
				} else {
					result = m + result;
				}
			} else {
				result = f;
			}
		}

		return result;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String linha = br.readLine();

		Integer num = Integer.parseInt(linha);

		// var arr = ["I","V","X"read,"L","C","D","M");
		Map<Integer, String> map = new HashMap<>();

		map.put(1, "I");
		map.put(5, "V");
		map.put(10, "X");
		map.put(50, "L");
		map.put(100, "C");
		map.put(500, "D");
		map.put(1000, "M");

		String result = "";

		if (map.get(num) != null) {
			result = map.get(num);
		} else {
			String num2 = "" + num;

			switch (num2.length()) {
			case 1:
				result += convert(num2.charAt(0), "I", "V", "IX");
				break;
			case 2:
				result += convert(num2.charAt(0), "X", "L", "XC");
				result += convert(num2.charAt(1), "I", "V", "IX");
				break;
			case 3:
				result += convert(num2.charAt(0), "C", "D", "CM");
				result += convert(num2.charAt(1), "X", "L", "XC");
				result += convert(num2.charAt(2), "I", "V", "IX");
				break;
			case 4:
				result += convert(num2.charAt(0), "M", "", "");
				result += convert(num2.charAt(1), "C", "D", "CM");
				result += convert(num2.charAt(2), "X", "L", "XC");
				result += convert(num2.charAt(3), "I", "V", "IX");
				break;
			}

		}

		System.out.println(result);

	}
}

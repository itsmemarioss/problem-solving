package br.com.itsmemario.hackerrank.java.strings;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/java-string-tokens/problem
 * 
 * Difficulty: Easy
 * 
 * @author mario
 *
 */
public class StringTokens {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		// Write your code here.
		if (!s.trim().isEmpty()) {
			String[] splited = s.trim().split("[ !,?._'@]+");
			System.out.println(splited.length);
			for (int i = 0; i < splited.length; i++) {
				System.out.println(splited[i]);
			}
		}else {
			System.out.println(0);
		}
		scan.close();
	}
}

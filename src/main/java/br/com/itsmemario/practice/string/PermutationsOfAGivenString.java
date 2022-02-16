package br.com.itsmemario.practice.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0
 * @author mario
 *
 */
public class PermutationsOfAGivenString {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		
		while( (line = br.readLine())!=null ) {
			int entries = Integer.parseInt(line);
			
			for(int i = 0;i <entries;i++) {
				printPermutations(br.readLine());
			}
		}
	}

	private static void printPermutations(String word) {
		Set<String> permutations = new TreeSet<>();
		findPermutations(word, permutations);
		
		System.out.println(permutations.stream().collect(Collectors.joining(" ")));
	}

	private static void findPermutations(String word, Set<String> permutations) {
		if(permutations.contains(word)) {
			return;
		}
		permutations.add(word);
		for(int i = 1;i<word.length();i++) {
			
			char[] array = word.toCharArray();
			char aux = array[0];
			array[0] = array[i];
			array[i] = aux;
			
			findPermutations(new String(array), permutations);
		}
	}
}

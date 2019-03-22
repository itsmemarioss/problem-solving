package com.hackerrank.java.datastructures;

import java.util.*;

public class JavaStack {

	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Character> stack = new LinkedList<>();
		

		while (sc.hasNext()) {
			String input = sc.next();
			// Complete the code
			boolean balanced = true;

			if (input.length() % 2 != 0) {
				System.out.println("false");
				continue;
			} else {
				for (char c : input.toCharArray()) {
					if (c == '{' || c == '(' || c == '[') {
						stack.push(c);
					} else if (!stack.isEmpty()) {
						char aux = stack.pop();
						if (c == '{') {
							balanced = aux == '}';
						} else if (c == '(') {
							balanced = aux == ')';
						} else if (c == '[') {
							balanced = aux == ']';
						}
					}else {
						balanced = false;
						break;
					}

					if (!balanced )
						break;
				}

			}

			System.out.println(balanced);
		}

	}
}

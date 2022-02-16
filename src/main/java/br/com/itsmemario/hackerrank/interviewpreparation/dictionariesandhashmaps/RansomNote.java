package br.com.itsmemario.hackerrank.interviewpreparation.dictionariesandhashmaps;

import java.util.*;

public class RansomNote {

	// Complete the checkMagazine function below.
	static void checkMagazine(String[] magazine, String[] note) {
		boolean result = true;

		if (note.length <= magazine.length) {
			Map<String, Integer> map = new HashMap<>();

			Arrays.asList(magazine).forEach((String s) -> {
				map.merge(s, 1, (i1, i2) -> i1 + i2);
			});

			for (int i = 0; i < note.length; i++) {
				if (map.containsKey(note[i])) {
					if (map.get(note[i]) > 0) {
						map.merge(note[i], 1, (i1, i2) -> i1 - i2);
					} else {
						result = false;
						break;
					}
				} else {
					result = false;
					break;
				}
			}
		} else {
			result = false;
		}

		System.out.println(result ? "Yes" : "No");

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] mn = scanner.nextLine().split(" ");

		int m = Integer.parseInt(mn[0]);

		int n = Integer.parseInt(mn[1]);

		String[] magazine = new String[m];

		String[] magazineItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}

		String[] note = new String[n];

		String[] noteItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}

		checkMagazine(magazine, note);

		scanner.close();
	}
}

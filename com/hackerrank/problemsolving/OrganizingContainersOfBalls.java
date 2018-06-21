package com.hackerrank.problemsolving;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
 * 
 * Difficulty: Medium
 * 
 * @author mario
 *
 */
public class OrganizingContainersOfBalls {

	// Complete the organizingContainers function below.
	static String organizingContainers(int[][] container) {
		String result = "Impossible";

		boolean moveOn = false;
		int success = 0;

		for (int b = 0; b < container.length; b++) {

			CONTAINER: for (int c = 0; c < container.length; c++) {

				int ballsToSwap = 0;
				int ballsToRecieve = 0;

				// calculate balls to give away
				for (int j = 0; j < container.length; j++) {
					if (j != b) {
						ballsToSwap += container[c][j];
					}
				}

				// calculate balls to receive
				for (int j = 0; j < container.length; j++) {
					if (j != c) {
						ballsToRecieve += container[j][c];
					}
				}

				moveOn = ballsToSwap == ballsToRecieve;

				if (moveOn) {
					success++;
					break CONTAINER;
				}
			} // container loop

		} // balls loop

		if (success == container.length) {
			result = "Possible";
		}

		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[][] container = new int[n][n];

			for (int i = 0; i < n; i++) {
				String[] containerRowItems = scanner.nextLine().split(" ");
				scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

				for (int j = 0; j < n; j++) {
					int containerItem = Integer.parseInt(containerRowItems[j]);
					container[i][j] = containerItem;
				}
			}

			String result = organizingContainers(container);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}

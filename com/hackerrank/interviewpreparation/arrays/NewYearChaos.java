package com.hackerrank.interviewpreparation.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < q.length; i++) {
			list.add(q[i]);
		}
        Collections.sort(list);
        
        int count = 0;
        
        for (int i = 0; i < q.length; i++) {
			int index = list.indexOf(q[i]);
			
			int bribes = index-i;
			
			if(bribes <= 2 && bribes > 0){
				count += Math.abs(bribes);
				int element = list.remove(index);
				
				list.add(i, element);
			}else if(Math.abs(bribes)>2){
				System.out.println("Too chaotic");
				return;
			}
        	
		}
        
        System.out.println(count);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}

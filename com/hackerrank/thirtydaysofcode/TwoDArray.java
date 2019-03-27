package com.hackerrank.thirtydaysofcode;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class TwoDArray {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        int sum = 0;
        for(int a = 0; a< arr.length - 2; a++){
            
            for(int b = 0;b<arr[a].length -2;b++){

                for(int c=a;c<a+3;c++){
                    for(int d=b;d<b+3;d++){
                        if( c==a+1 && d!=b+1 ){
                            continue;
                        }
                        sum += arr[c][d];
                    }
                }
                
                if(max<sum){
                    max = sum;
                }
                sum = 0;
            }

        }

        System.out.println(max);

        scanner.close();
    }
}

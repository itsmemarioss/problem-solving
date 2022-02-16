package br.com.itsmemario.hackerrank.interviewpreparation.stringmanipulation;

import java.io.*;
import java.util.*;

public class MakingAnagrams {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int total = a.length()+b.length();
        StringBuilder smaller = a.length() <= b.length()? new StringBuilder(a):new StringBuilder(b);
        StringBuilder bigger = a.length() <= b.length()? new StringBuilder(b):new StringBuilder(a);
        
        int aux = 0;
        
        for(int i =0; i < smaller.length(); i++){
            for(int j = 0; j< bigger.length(); j++){
                if(smaller.charAt(i)== bigger.charAt(j)){
                    aux++;
                    bigger.deleteCharAt(j);
                    break;
                }
            }
        }
        
        return total - (aux*2);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

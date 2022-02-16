package br.com.itsmemario.hackerrank.interviewpreparation.arrays;

import java.util.*;

public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int count = 0;
        for(int i =0; i < q.length; i++){
            int bribes = q[i] - (i + 1);
            if( bribes > 2 ){
                count=0;
                break;
            }

            if(bribes > 0){
                count += bribes;
            }else if ( (i != q.length -1) && (q[i]>q[i+1])) {
                count++;
            }
        }
        System.out.println(count>0?count:"Too chaotic");

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
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}

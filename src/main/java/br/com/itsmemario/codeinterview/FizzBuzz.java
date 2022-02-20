package br.com.itsmemario.codeinterview;

public class FizzBuzz {
    public static void main(String[] args) {
        for (var i = 1; i<=100; i++){
            System.out.printf("%d ",i);
            if( i%3 == 0) System.out.print("fizz");
            if( i%5 == 0) System.out.print("buzz");
            System.out.println();
        }
    }
}

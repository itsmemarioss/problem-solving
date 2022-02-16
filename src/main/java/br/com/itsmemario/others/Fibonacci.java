package br.com.itsmemario.others;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(calculate(8));
        System.out.println(calculate(7));
        System.out.println(calculate(6));
        System.out.println(calculate(5));
        System.out.println(calculate(4));
        System.out.println(calculate(3));
        System.out.println(calculate(2));
        System.out.println(calculate(1));
        System.out.println(calculate(0));
    }

    private static int calculate(int position) {
        if(position < 0) throw new IllegalArgumentException("Number must be equal or bigger than 0");
        if(position == 0) return 0;
        if(position <= 2) return 1;

        var result = 0;
        var prev1 = 1;
        var prev2 = 1;
        for(var i = 3; i<=position; i++){
            result = prev1 + prev2;
            prev2 = prev1;
            prev1 = result;
        }
        return result;
    }

    /**
     * complexity O(n^2)?
     * @param position
     * @return
     */
    private static int calculateRecursively(int position) {
        if(position < 0) throw new IllegalArgumentException("Number must be equal or bigger than 0");
        if(position == 0) return 0;
        if(position <= 2) return 1;
        return calculateRecursively(position-2) + calculateRecursively(position - 1);
    }
}

package br.com.itsmemario.codeinterview;

import java.util.Map;

import static java.util.Map.entry;

public class NumberToWord {

    private String[] oneToNineteen = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    private Map<Integer, String> tens = Map.ofEntries(
            entry(20, "twenty"),
            entry(30, "thirty"),
            entry(40, "forty"),
            entry(50, "fifty"),
            entry(60, "sixty"),
            entry(70, "seventy"),
            entry(80, "eighty"),
            entry(90, "ninety"));

    private Map<Integer, String> suffix = Map.ofEntries(
            entry(3, "hundred"),
            entry(4, "thousand"));


    public static void main(String[] args) {
        var numberToWord = new NumberToWord();
        System.out.println(numberToWord.convertToWord(1));
    }

    public String convertToWord(int n) {
        if (n < 20) {
            return oneToNineteen[n];
        } else if (tens.containsKey(n)) {
            return tens.get(n);
        }
        char[] numbers = String.valueOf(n).toCharArray();
        StringBuilder word = new StringBuilder();
        var numberOfDigits = numbers.length;
        FOR:
        for (var i = 0; i < numbers.length && numberOfDigits > 0; i++, numberOfDigits--) {

            int number = Integer.parseInt(numbers[i] + "");
            if(number==0) continue;
            switch (numberOfDigits) {
                case 1:
                    word.append(oneToNineteen[number]);
                    break FOR;
                case 2:
                    if (number * 10 > oneToNineteen.length - 1) {
                        word.append(tens.get(number * 10));
                        word.append(" ");
                        break;
                    } else {
                        word.append(oneToNineteen[number]);
                        break FOR;
                    }
                default:
                    word.append(oneToNineteen[number]);
                    word.append(" ");
                    word.append(suffix.get(numberOfDigits));
                    word.append(" ");
                    break;
            }

        }
        word.append(" ");
        return word.toString().trim();
    }

    private String findSuffix(int numberOfDigits) {
        return switch (numberOfDigits) {
            case 3 -> "hundred";
            case 4 -> "thousand";
            default -> "";
        };
    }
}

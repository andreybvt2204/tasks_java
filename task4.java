import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("task 4.1");
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));

        System.out.println("\ntask 4.2");
        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));

        System.out.println("\ntask 4.3");
        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));

        System.out.println("\ntask 4.4");
        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("klmabzyxw"));

        System.out.println("\ntask 4.5");
        System.out.println(countAndSort("aaabbcdd"));
        System.out.println(countAndSort("vvvvaajaaaaa"));

        System.out.println("\ntask 4.6");
        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));

        System.out.println("\ntask 4.7");
        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));

        System.out.println("\ntask 4.8");
        int[][] matrix1 = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(shortestWay(matrix1));
        int[][] matrix2 = {
                {2, 7, 3},
                {1, 4, 8},
                {4, 5, 9}
        };
        System.out.println(shortestWay(matrix2));

        System.out.println("\ntask 4.9");
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));

        System.out.println("\ntask 4.10");
        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));
    }

    public static String nonRepeatable(String str){
        if (str.isEmpty()) {
            return str;
        }
        char currentChar = str.charAt(0);
        String remainingString = str.replaceAll(String.valueOf(currentChar), "");

        return currentChar + nonRepeatable(remainingString);
    }

    public static List<String> generateBrackets(int n){
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    private static void generate(List<String> result, String current, int open, int close, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        if (open < n) {
            generate(result, current + "(", open + 1, close, n);
        }

        if (close < open) {
            generate(result, current + ")", open, close + 1, n);
        }
    }

    public static List<String> binarySystem(int n){
        List<String> result = new ArrayList<>();
        binary(result, "", n);
        return result;
    }

    private static void binary(List<String> result, String current, int n){
        if (current.length() == n) {
            result.add(current);
            return;
        }

        if (current.length() == 0 || current.charAt(current.length() - 1) != '0') {
            binary(result, current + "0", n);
        }

        binary(result, current + "1", n);
    }

    public static String alphabeticRow(String str){
        if (str.length() == 0){
            return "";
        }
        int count = 0;
        String currentRow = Character.toString(str.charAt(0));
        String longestRow = currentRow;

        for (int i = 1; i < str.length(); i++){
            char currentChar = str.charAt(i);
            char previousChar = str.charAt(i - 1);
            int difference = currentChar - previousChar;

            if (Math.abs(difference) == 1 && (count * difference >= 0)) {
                count += difference;
                currentRow += currentChar;
            } else {
                count = 0;
                currentRow = Character.toString(currentChar);
            }

            if (currentRow.length() > longestRow.length()) {
                longestRow = currentRow;
            }
        }

        return longestRow;
    }

    public static String countAndSort(String str){
        List<String> patterns = new ArrayList<>();
        int count = 1;
        char prev = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);

            if (current == prev) {
                count++;
            } else {
                patterns.add(prev + Integer.toString(count));
                count = 1;
                prev = current;
            }
        }

        patterns.add(prev + Integer.toString(count));

        for (int i = 0; i < patterns.size() - 1; i++) {
            for (int j = 0; j < patterns.size() - 1 - i; j++) {
                int value1 = Integer.parseInt(patterns.get(j).substring(1));
                int value2 = Integer.parseInt(patterns.get(j + 1).substring(1));

                if (value1 > value2) {
                    String temp = patterns.get(j);
                    patterns.set(j, patterns.get(j + 1));
                    patterns.set(j + 1, temp);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (String pattern : patterns) {
            result.append(pattern);
        }

        return result.toString();
    }

    public static int convertToNum(String input){
        HashMap<String, Integer> wordToNum = new HashMap<>();
        wordToNum.put("zero", 0);
        wordToNum.put("one", 1);
        wordToNum.put("two", 2);
        wordToNum.put("three", 3);
        wordToNum.put("four", 4);
        wordToNum.put("five", 5);
        wordToNum.put("six", 6);
        wordToNum.put("seven", 7);
        wordToNum.put("eight", 8);
        wordToNum.put("nine", 9);
        wordToNum.put("ten", 10);
        wordToNum.put("eleven", 11);
        wordToNum.put("twelve", 12);
        wordToNum.put("thirteen", 13);
        wordToNum.put("fourteen", 14);
        wordToNum.put("fifteen", 15);
        wordToNum.put("sixteen", 16);
        wordToNum.put("seventeen", 17);
        wordToNum.put("eighteen", 18);
        wordToNum.put("nineteen", 19);
        wordToNum.put("twenty", 20);
        wordToNum.put("thirty", 30);
        wordToNum.put("forty", 40);
        wordToNum.put("fifty", 50);
        wordToNum.put("sixty", 60);
        wordToNum.put("seventy", 70);
        wordToNum.put("eighty", 80);
        wordToNum.put("ninety", 90);
        wordToNum.put("hundred", 100);

        String[] words = input.toLowerCase().split(" ");
        int result = 0;
        int currentNumber = 0;

        for (int i = 0; i < words.length; i++) {
            int value = wordToNum.get(words[i]);
            if (i < words.length - 1 && value == 100) {
                currentNumber *= value;
            } else {
                currentNumber += value;
            }
        }
        result += currentNumber;
        return result;
    }

    public static String uniqueSubstring(String str){
        if (str.length() == 0){
            return "";
        }
        int count = 0;
        String currentRow = Character.toString(str.charAt(0));
        String longestRow = currentRow;

        for (int i = 1; i < str.length(); i++){
            char currentChar = str.charAt(i);
            char previousChar = str.charAt(i - 1);
            int difference = currentChar - previousChar;

            if (Math.abs(difference) == 1 && (count * difference >= 0)) {
                count += difference;
                currentRow += currentChar;
            } else {
                count = 0;
                currentRow = Character.toString(currentChar);
            }

            if (currentRow.length() > longestRow.length()) {
                longestRow = currentRow;
            }
        }

        return longestRow;
    }

    public static int shortestWay(int[][] matrix){
        int n = matrix.length;
        int[][] dp = new int[n][n];

        dp[0][0] = matrix[0][0];

        for (int i = 1; i < n; i++){
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }

        for (int i = 1; i < n; i++){
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n - 1][n - 1];
    }

    public static String numericOrder(String input){
        String[] words = input.split(" ");
        String[] orderedWords = new String[words.length];

        for (String word : words) {
            StringBuilder wordWithoutNumbers = new StringBuilder();
            StringBuilder numbers = new StringBuilder();

            for (char c : word.toCharArray()) {
                if (Character.isDigit(c)) {
                    numbers.append(c);
                } else {
                    wordWithoutNumbers.append(c);
                }
            }
            if (numbers.length() > 0) {
                int position = Integer.parseInt(numbers.toString());
                orderedWords[position - 1] = wordWithoutNumbers.toString();
            }
        }
        return String.join(" ", orderedWords);
    }

    public static int switchNums(int num1, int num2){
        String num1Str = Integer.toString(num1);
        String num2Str = Integer.toString(num2);

        for (int i = 0; i < num1Str.length(); i++) {
            char maxDigit = '0';
            for (char digit : num1Str.toCharArray()) {
                if (digit > maxDigit) {
                    maxDigit = digit;
                }
            }

            for (int j = 0; j < num2Str.length(); j++) {
                if (num2Str.charAt(j) < maxDigit) {
                    num2Str = num2Str.substring(0, j) + maxDigit + num2Str.substring(j + 1);
                    break;
                }
            }

            num1Str = num1Str.replaceFirst(String.valueOf(maxDigit), "");
        }

        return Integer.parseInt(num2Str);
    }
}

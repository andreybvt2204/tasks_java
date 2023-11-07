import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("task 3.1");
        System.out.println(replaceVowels("apple"));
        System.out.println(replaceVowels("Even if you did this task not by yourself, you have to understand every single line of code."));

        System.out.println("\ntask 3.2");
        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));

        System.out.println("\ntask 3.3");
        System.out.println(doesBlockkFit(1, 3, 5, 4, 5));
        System.out.println(doesBlockkFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockkFit(1, 2, 2, 1, 1));

        System.out.println("\ntask 3.4");
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));

        System.out.println("\ntask 3.5");
        System.out.println(countRoots(new int[] {1, -3, 2}));
        System.out.println(countRoots(new int[] {2, 5, 2}));
        System.out.println(countRoots(new int[] {1, -6, 9}));

        System.out.println("\ntask 3.5");

        System.out.println("\ntask 3.7");
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));

        System.out.println("\ntask 3.8");
        System.out.println(waveForm(new int[] {1, 2, 3, 4, 5}));
        System.out.println(waveForm(new int[] {1, 2, -6, 10, 3}));

        System.out.println("\ntask 3.9");
        System.out.println(commonVowel("Hello world"));
        System.out.println(commonVowel("Actions speak louder than words."));

        System.out.println("\ntask 3.10");
    }

    public static String replaceVowels(String inputStr){
        StringBuilder outputStr = new StringBuilder();
        String vowels = "aeiouy";
        for (int i = 0; i < inputStr.length(); i++){
            String currentChar = "" + inputStr.charAt(i);
            if (vowels.contains(currentChar.toLowerCase())) {
                outputStr.append("*");
            } else {
                outputStr.append(currentChar);
            }
        }
        return outputStr.toString();
    }

    public static String stringTransform(String inputStr){
        StringBuilder outputStr = new StringBuilder();
        for (int i = 0; i < inputStr.length(); i++){
            String currentLetter = "" + inputStr.charAt(i);
            if (i + 1 >= inputStr.length()){
                outputStr.append(currentLetter);
                continue;
            }
            String nextLetter = "" + inputStr.charAt(i + 1);
            if (currentLetter.equals(nextLetter)){
                outputStr.append("Double");
                outputStr.append(currentLetter.toUpperCase());
                i += 1;
            } else {
                outputStr.append(currentLetter);
            }
        }
        return outputStr.toString();
    }

    public static boolean doesBlockkFit(int a, int b, int c, int w, int h){
        return a * b <= w * h || a * c <= w * h || b * c <= w * h;
    }

    public static boolean numCheck(int number) {
        String strNumber = Integer.toString(number);
        int squares = 0;
        for (int i = 0; i < strNumber.length(); i++){
            int n = Character.getNumericValue(strNumber.charAt(i));
            squares += n * n;
        }
        return number % 2 == squares % 2;
    }

    public static int countRoots(int[] coefficients){
        int a = coefficients[0];
        int b = coefficients[1];
        int c = coefficients[2];

        int discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            return 2;
        } else if (discriminant == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static boolean validSplit(String sentence){
        String[] words = sentence.split(" ");
        if (words.length <= 1) {
            return false;
        }
        for (int i = 0; i < words.length - 1; i++){
            if (words[i].charAt(words[i].length() - 1) != words[i + 1].charAt(0)){
                return false;
            }
        }
        return true;
    }

    public static boolean waveForm(int[] arr){
        if (arr.length < 3) {
            return false;
        }
        for (int i = 1; i < arr.length - 1; i++){
            if (!(arr[i - 1] > arr[i] && arr[i] < arr[i + 1] || arr[i - 1] < arr[i] && arr[i] > arr[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public static char commonVowel(String sentence){
        sentence = sentence.toLowerCase();
        int[] count = new int[6];
        String vowels = "aeiouy";
        for (int i = 0; i < sentence.length(); i++){
            int index = vowels.indexOf(sentence.charAt(i));
            if (index != -1){
                count[index] += 1;
            }
        }
        int maxCount = 0;
        char mostCommonVowel = ' ';
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                mostCommonVowel = vowels.charAt(i);
            }
        }
        return mostCommonVowel;
    }
}

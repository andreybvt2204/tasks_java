import java.util.Arrays;
import java.security.SecureRandom;

public class Main {
    public static void main(String[] args) {
    System.out.println("task 2.1");
    System.out.println(duplicateChars("Donald"));
    System.out.println(duplicateChars("orange"));

    System.out.println("\ntask 2.2");
    System.out.println(getInitials("Ryan Gosling"));
    System.out.println(getInitials("Barack Obama"));

    System.out.println("\ntask 2.3");
    System.out.println(differenceEvenOdd(new int[] {44, 32, 86, 19}));
    System.out.println(differenceEvenOdd(new int[] {22, 50, 16, 63, 31, 55}));

    System.out.println("\ntask 2.4");
    System.out.println(equalToAvg(new int[] {1, 2, 3, 4, 5}));
    System.out.println(equalToAvg(new int[] {1, 2, 3, 4, 6}));

    System.out.println("\ntask 2.5");
    System.out.println(indexMult(new int[] {1, 2, 3}));
    System.out.println(indexMult(new int[] {3, 3, -2, 408, 3, 31}));

    System.out.println("\ntask 2.6");
    System.out.println(reverse("Hello World"));
    System.out.println(reverse("The quick brown fox."));

    System.out.println("\ntask 2.7");
    System.out.println(tribonacci(7));
    System.out.println(tribonacci(11));

    System.out.println("\ntask 2.8");
    System.out.println(pseudoHash(5));
    System.out.println(pseudoHash(10));
    System.out.println(pseudoHash(0));

    System.out.println("\ntask 2.9");
    System.out.println(botHelper("Hello, I’m under the water, please help me"));
    System.out.println(botHelper("Two pepperoni pizzas please"));

    System.out.println("\ntask 2.10");
    System.out.println(isAnagram("listen", "silent"));
    System.out.println(isAnagram("eleven plus two", "twelve plus one"));
    System.out.println(isAnagram("hello", "world"));
    }

    public static boolean duplicateChars(String inputStr){
        inputStr = inputStr.toLowerCase();
        for (int i = 0; i < inputStr.length(); i++){
            for (int j = 1 + i; j < inputStr.length(); j++){
                if (inputStr.charAt(i) == inputStr.charAt(j)){
                    return true;
                }
            }
        }
        return false;
    }

    public static String getInitials(String fullName){
        StringBuilder stringOutput = new StringBuilder();
        String[] worlds = fullName.trim().split(" ");
        for (String world : worlds){
            if (!world.isEmpty()) {
                stringOutput.append(world.charAt(0));
            }
        }
        return stringOutput.toString().toUpperCase();
    }

    public static int differenceEvenOdd(int[] numbers){
        int sum = 0;
        for (int number : numbers){
            if (number % 2 == 0){
                sum += number;
            } else {
                sum -= number;
            }
        }
        return Math.abs(sum);
    }

    public static boolean equalToAvg(int[] numbers){
        int len = numbers.length;
        if (len == 0){
            return false;
        }
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        double avg = (double) sum / len;
        for (int number : numbers){
            if (number == avg){
                return true;
            }
        }
        return false;
    }

    public static String indexMult(int[] numbers){
        for (int i = 0; i < numbers.length; i++){
            numbers[i] *= i;
        }
        return Arrays.toString(numbers);
    }

    public static String reverse(String inputStr){
        StringBuilder outputStr = new StringBuilder();
        for (int i = inputStr.length() - 1; i >= 0; i--){
            outputStr.append(inputStr.charAt(i));
        }
        return outputStr.toString();
    }

    public static int tribonacci(int n){
        if (n < 2){
            return 0;
        } else if (n == 3){
            return 1;
        } else {
            return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        }
    }

    public static String pseudoHash(int length){
        if (length <= 0) {
            return "";
        }
        SecureRandom random = new SecureRandom();
        StringBuilder pseudoHash = new StringBuilder();
        String characters = "0123456789abcdef";

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            pseudoHash.append(randomChar);
        }
        return pseudoHash.toString();
    }

    public static String botHelper(String inputStr) {
        if (inputStr.toLowerCase().contains("help")) {
            return "Calling for a staff member";
        } else {
            return "Keep waiting";
        }
    }

    public static boolean isAnagram(String str1, String str2){
        char[] chars1 = str1.toLowerCase().toCharArray();
        char[] chars2 = str2.toLowerCase().toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }
}

import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("task 5.1");
        System.out.println("sameLetterPattern(\"ABAB\", \"CDCD\") -> " + sameLetterPattern("ABAB", "CDCD"));
        System.out.println("sameLetterPattern(\"ABCBA\", \"BCDCB\") -> " + sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println("sameLetterPattern(\"FFGG\", \"CDCD\") -> " + sameLetterPattern("FFGG", "CDCD"));
        System.out.println("sameLetterPattern(\"FFFF\", \"ABCD\") -> " + sameLetterPattern("FFFF", "ABCD"));

        System.out.println("\ntask 5.3");
        System.out.println("digitsCount(4666) -> " + digitsCount(4666));
        System.out.println("digitsCount(544) -> " + digitsCount(544));
        System.out.println("digitsCount(121317) -> " + digitsCount(121317));
        System.out.println("digitsCount(0) -> " + digitsCount(0));
        System.out.println("digitsCount(12345) -> " + digitsCount(12345));
        System.out.println("digitsCount(1289396387328L) -> " + digitsCount(1289396387328L));

        System.out.println("\ntask 5.4");

    }

    public static boolean sameLetterPattern(String str1, String str2) {
        return sameLetterPatternMap(str1).equals(sameLetterPatternMap(str2));
    }
    private static List<HashSet<Integer>> sameLetterPatternMap(String str){
        Map<Character, HashSet<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            map.computeIfAbsent(currentChar, k -> new HashSet<>()).add(i);
        }
        return new ArrayList<>(map.values());
    }

    public static Integer digitsCount(int number) {
        if (number == 0) {
            return 1;
        } else {
            int count = 0;
            return digitsCountParent(number, count);
        }
    }

    public static Integer digitsCount(long number) {
        if (number == 0) {
            return 1;
        } else {
            int count = 0;
            return digitsCountParent(number, count);
        }
    }

    private static Integer digitsCountParent(long number, int count) {
        if (number <= 0) {
            return count;
        } else {
            return digitsCountParent(number / 10, count + 1);
        }
    }
}

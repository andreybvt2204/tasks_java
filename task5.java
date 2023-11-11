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
        String[] data1 = {"cat", "create", "sat"};
        System.out.println("totalPoints([\"cat\", \"create\", \"sat\"], \"caster\") -> "
                + totalPoints(data1, "caster"));
        String[] data2 = {"trance", "recant"};
        System.out.println("totalPoints([\"trance\", \"recant\"], \"recant\") -> "
                + totalPoints(data2, "recant"));
        String[] data3 = {"dote", "dotes", "toes", "set", "dot", "dots", "sted"};
        System.out.println("totalPoints([\"dote\", \"dotes\", \"toes\", \"set\", \"dot\", \"dots\", \"sted\"], \"tossed\") -> "
                + totalPoints(data3, "tossed"));

        System.out.println("\ntask 5.5");
        System.out.println("sumsUp([1, 2, 3, 4, 5]) -> " + sumsUp(new int[] {1, 2, 3, 4, 5}));
        System.out.println("sumsUp([1, 2, 3, 7, 9]) -> " + sumsUp(new int[] {1, 2, 3, 7, 9}));
        System.out.println("sumsUp([10, 9, 7, 2, 8]) -> " + sumsUp(new int[] {10, 9, 7, 2, 8}));
        System.out.println("sumsUp([1, 6, 5, 4, 8, 2, 3, 7]) -> " + sumsUp(new int[] {1, 6, 5, 4, 8, 2, 3, 7}));

        System.out.println("\ntask 5.6");
        System.out.println("takeDownAverage([\"95%\", \"83%\", \"90%\", \"87%\", \"88%\", \"93%\"]) -> "
                + takeDownAverage(new String[] {"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println("takeDownAverage([\"10%\"]) -> " + takeDownAverage(new String[] {"10%"}));
        System.out.println("takeDownAverage([\"53%\", \"79%\"]) -> " + takeDownAverage(new String[] {"53%", "79%"}));

        System.out.println("\ntask 5.7");
        System.out.println("caesarCipher(\"encode\", \"hello world\", 3) -> "
                + caesarCipher("encode", "hello world", 3));
        System.out.println("caesarCipher(\"decode\", \"almost last task!\", 4 -> "
                + caesarCipher("decode", "almost last task!", 4));

        System.out.println("\ntask 5.8");
        System.out.println("setSetup(5, 3) -> " + setSetup(5, 3));
        System.out.println("setSetup(7, 3) -> " + setSetup(7, 3));

        System.out.println("\ntask 5.10");
        System.out.println("isNew(3) -> " + isNew(3));
        System.out.println("isNew(30) -> " + isNew(30));
        System.out.println("isNew(321) -> " + isNew(321));
        System.out.println("isNew(123) -> " + isNew(123));

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
        if (number == 0) return 1;
        int count = 0;
        return digitsCountParent(number, count);
    }

    public static Integer digitsCount(long number) {
        if (number == 0) return 1;
        int count = 0;
        return digitsCountParent(number, count);
    }

    private static Integer digitsCountParent(long number, int count) {
        if (number <= 0) return count;
        return digitsCountParent(number / 10, count + 1);
    }

    public static int totalPoints(String[] words, String origWord) {
        int resultPoints = 0;
        int[] points = {1, 2, 3, 4};
        if (Arrays.asList(words).contains(origWord)) points[3] = 54;

        outerLoop: for (String word : words) {
            if (word.length() < 3) continue;
            String copied = origWord;

            for (int i = 0; i < word.length(); i++) {
                String currentChar = String.valueOf(word.charAt(i));
                if (!copied.contains(currentChar)) continue outerLoop;
                copied = copied.replace(currentChar, "");
            }
            resultPoints += points[word.length() - 3];
        }
        return resultPoints;
    }

    public static String sumsUp(int[] nums) {
        List<String> result = new ArrayList<>();
        int lenArray = nums.length / 2;
        for (int i = lenArray; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] + nums[j] == 8) {
                    int minNum = Math.min(nums[i], nums[j]);
                    int maxNum = Math.max(nums[i], nums[j]);
                    result.add(Arrays.toString(new int[] {minNum, maxNum}));
                }
            }
        }
        return result.toString();
    }

    public static String takeDownAverage(String[] grades) {
        int lenArray = grades.length;
        int result = 0;
        for (String grade : grades) {
            result += Integer.parseInt(grade.substring(0, grade.length() - 1));
        }
        result = (int) Math.round((double) result / lenArray - (lenArray + 1) * 5);

        return result + "%";
    }

    public static String caesarCipher(String cryptoMode, String inputStr, int shift) {
        inputStr = inputStr.toUpperCase();
        StringBuilder outputStr = new StringBuilder();
        for (int i = 0; i < inputStr.length(); i++) {
            char currentChar = inputStr.charAt(i);
            if (!Character.isLetter(currentChar)) {
                outputStr.append(currentChar);
                continue;
            }
            if (cryptoMode.equals("encode")) {
                currentChar = (char) ((currentChar - 'A' + shift) % 26 + 'A');
            } else if (cryptoMode.equals("decode")) {
                currentChar = (char) (((currentChar - 'A' + shift) % 26 + 26) % 26 + 'A');
            } else return inputStr;

            outputStr.append(currentChar);
        }
        return "\"" + outputStr + "\"";
    }

    public static int setSetup(int n, int k){
        if (n <= 0 || k < 0 || k > n) return 0;
        return setSetupParent(n, k);
    }

    private static int setSetupParent(int n, int k){
        if (k == 0) return 1;
        return (n - (k - 1)) * setSetup(n, k - 1);
    }

    public static boolean isNew(int number) {
        if (number < 21) return true;
        String numberStr = String.valueOf(number);
        for (int i = 0; i < numberStr.length() - 1; i++) {
            char currentChar = numberStr.charAt(i);
            char nextChar = numberStr.charAt(i + 1);
            if (currentChar <= nextChar || (i == 0 && nextChar == '0')) continue;
            return false;
        }
        return true;
    }
}

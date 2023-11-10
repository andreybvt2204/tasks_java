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

    public static int totalPoints(String[] words, String origWord) {
        HashMap<Integer, Integer> points = new HashMap<>();
        points.put(3, 1);
        points.put(4, 2);
        points.put(5, 3);
        if (Arrays.asList(words).contains(origWord)) {
            points.put(6, 54);
        } else {
            points.put(6, 4);
        }

        int result = 0;

        outerLoop: for (String word : words) {
            if (word.length() < 3) continue;
            String copiedString = origWord;

            for (int i = 0; i < word.length(); i++) {
                if (!copiedString.contains(String.valueOf(word.charAt(i)))) continue outerLoop;
                copiedString = copiedString.replace(String.valueOf(word.charAt(i)), "");
            }

            result += points.get(word.length());
        }

        return result;
    }

    public static String sumsUp(int[] nums) {
        List<String> result = new ArrayList<>();
        int lenArray = nums.length / 2;
        for (int i = lenArray; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] + nums[j] == 8) {
                    result.add(Arrays.toString(new int[] {Math.min(nums[i], nums[j]), Math.max(nums[i], nums[j])}));
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

        return result + "%"; // + 32 a = 97 A = 65 z 122 Z 90
    }

    public static String caesarCipher(String type, String inputStr, int shift) {
        inputStr = inputStr.toUpperCase();
        StringBuilder outputStr = new StringBuilder();
        for (int i = 0; i < inputStr.length(); i++) {
            char currentChar = inputStr.charAt(i);
            if (type.equals("encode")) {
                if (Character.isLetter(currentChar)){
                    char encryptedChar = (char) ((currentChar - 'A' + shift) % 26 + 'A');
                    outputStr.append(encryptedChar);
                } else {
                    outputStr.append(currentChar);
                }
            } else if (type.equals("decode")) {
                if (Character.isLetter(currentChar)){
                    char encryptedChar = (char) (((currentChar - 'A' + shift) % 26 + 26) % 26 + 'A');
                    outputStr.append(encryptedChar);
                } else {
                    outputStr.append(currentChar);
                }
            } else {
                return "???";
            }
        }
        return "\"" + outputStr + "\"";
    }
}

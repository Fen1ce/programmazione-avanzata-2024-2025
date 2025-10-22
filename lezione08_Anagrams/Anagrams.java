public class Anagrams {
    private static void generateAnagrams(String w, int n) {
        if (w.isEmpty() || n == 0) {
            return;
        }
        int[] count = new int[1];
        char[] chars = w.toCharArray();
        printAnagrams(chars, 0, n, count);
    }

    private static void printAnagrams(char[] chars, int index, int n, int[] count) {
        if (index == chars.length) {
            if (count[0] < n) {
                String anagram = String.valueOf(chars);
                String firstCapital = anagram.substring(0, 1).toUpperCase();
                count[0]++;
                System.out.println(count[0] + ". " + firstCapital + anagram.substring(1).toLowerCase());
            }
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            printAnagrams(chars, index + 1, n, count);
            swap(chars, index, i);
            if (count[0] >= n) {
                break;
            }
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
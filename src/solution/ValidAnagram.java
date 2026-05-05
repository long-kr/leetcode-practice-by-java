package solution;

import java.util.Arrays;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        // return false = length

        if (s.length() != t.length())
            return false;

        int[] sortedS = sort(s);
        int[] sortedT = sort(t);

        for (int i = 0; i < sortedT.length; i++) {
            if (sortedS[i] != sortedT[i])
                return false;
        }

        return true;
    }

    private static int[] sort(String s) {
        int[] arr = new int[26];

        for (char c : s.toCharArray()) {
            int dec = (int) c - 96;
            arr[dec]++;
        }

        return arr;
    }
}

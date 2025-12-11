package solution;

import java.util.Arrays;
import java.util.Collection;

// Medium 
// Url: https://leetcode.com/problems/longest-palindromic-substring/description/
// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.

// Constraints:
// 1 <= s.length <= 1000
// s consist of only digits and English letters.

public class LongestPalindromicSubstring {

    // expand around
    // public static String longestPalindromicSubstring(String s) {
    // if (s == null || s.length() < 1)
    // return "";

    // int start = 0;
    // int end = 0;

    // for (int i = 0; i < s.length(); i++) {
    // int len1 = expandAroundCenter(s, i, i);

    // int len2 = expandAroundCenter(s, i, i + 1);

    // int len = Math.max(len1, len2);

    // if (len > end - start + 1) {
    // // mid - half length
    // int newStart = i - (len - 1) / 2;

    // // mid + half length
    // int newEnd = i + (len) / 2;

    // start = newStart;
    // end = newEnd;
    // }

    // }

    // return s.substring(start, end + 1);

    // }

    // private static int expandAroundCenter(String s, int left, int right) {
    // int l = left;
    // int r = right;

    // while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
    // l--;
    // r++;
    // }

    // // length is r -1 - (l + 1) + 1 = r - l -1
    // return r - l - 1;

    // }

    // DP
    public static String longestPalindromicSubstring(String s) {

        if (s == null || s.length() < 1)
            return "";

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int start = 0;
        int maxLen = 0;

        // check single string,
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // check for len 2 string
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }

        // check for len 3 and above
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;

                    if (len <= maxLen)
                        continue;

                    start = i;
                    maxLen = len;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}

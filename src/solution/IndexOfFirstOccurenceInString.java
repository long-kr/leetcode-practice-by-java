package solution;

// easy
// url: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

// Example 1:
// Input: haystack = "sadbutsad", needle = "sad"
// Output: 0
// Explanation: "sad" occurs at index 0 and 6.
// The first occurrence is at index 0, so we return 0.

// Constraints:
// 1 <= haystack.length, needle.length <= 104
// haystack and needle consist of only lowercase English characters.w

public class IndexOfFirstOccurenceInString {

    public static int strStr(String haystack, String needle) {
        int longLen = haystack.length();
        int shortLen = needle.length();
        int result = -1;

        if (longLen < shortLen)
            return result;

        for (int i = 0; i < longLen - shortLen; i++) {

            if (haystack.charAt(i) == needle.charAt(0)) {
                for (int j = 1; j < shortLen; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j))
                        break;

                    if (j == shortLen - 1)
                        result = i;
                }
            }

            if (result != -1)
                break;
        }

        return result;

    }
}

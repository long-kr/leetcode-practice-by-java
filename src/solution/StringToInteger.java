package solution;

// Medium 
// Url: https://leetcode.com/problems/string-to-integer-atoi/description/
// Input: s = " -042"
// Output: -42
// Explanation:
// Step 1: "   -042" (leading whitespace is read and ignored)
//             ^
// Step 2: "   -042" ('-' is read, so the result should be negative)
//              ^
// Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)

// Constraints:

// 0 <= s.length <= 200
// s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.

public class StringToInteger {
    public static int stringToInteger(String s) {
        int len = s.length();
        int i = 0;

        while (i < len && Character.isWhitespace(s.charAt(i))) {
            i++;
        }

        int sign = 1;
        if (i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign *= -1;
            }
            i++;
        }

        int result = 0;
        while (i < len || Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return result * sign;
            }

            result = result * 10 + digit;
        }

        return result * sign;
    }

}

package solution;

import java.util.HashSet;
import java.util.Set;

// LeetCode Problem 202: Happy Number
// https://leetcode.com/problems/happy-number/

// example: 19 is a happy number
// 1^2 + 9^2 = 82
// 8^2 + 2^2 = 68
// 6^2 + 8^2 = 100
// 1^2 + 0^2 + 0^2 = 1

// constraints:
// 1 <= n <= 2^31 - 1

public class HappyNumber {
    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1) {
            if (seen.contains(n))
                return false;

            seen.add(n);

            n = sumOfSquare(n);

        }

        return true;
    }

    private static int sumOfSquare(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            n /= 10;
            sum += Math.pow(digit, 2);
        }

        return sum;
    }
}

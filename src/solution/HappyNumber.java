package solution;

import java.util.HashSet;
import java.util.Set;

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

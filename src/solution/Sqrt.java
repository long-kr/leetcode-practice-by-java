package solution;

// Implement integer square root function

// The function should return the integer part of the square root of a non-negative integer x.

public class Sqrt {
    public static int mySqrt(int x) {
        // x = 8
        // 0 1 2 3 4 5 6 7

        int lo = 0;
        int hi = x / 2;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            long sq = (long) mid * mid;

            if (sq == x)
                return mid;

            if (sq > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}

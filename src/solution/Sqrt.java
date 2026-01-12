package solution;

// Implement integer square root function

// The function should return the integer part of the square root of a non-negative integer x.

public class Sqrt {
    public static int mySqrt(int x) {
        // x = 8
        // 0 1 2 3 4 5 6 7

        int lo = 0;
        int hi = x;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            System.out.println(mid);

            if (mid * mid >= x) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}

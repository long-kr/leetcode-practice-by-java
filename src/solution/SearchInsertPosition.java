package solution;

// https://leetcode.com/problems/search-insert-position/

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int hi = nums.length;

        while (low < hi) {

            int mid = low + (hi - low) / 2;

            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                hi = mid;
            }
        }

        return low;

    }
}

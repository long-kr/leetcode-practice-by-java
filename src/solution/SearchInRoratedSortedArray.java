package solution;

// Medium 
// Url: https://leetcode.com/problems/search-in-rotated-sorted-array/
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4

// Constraints:
// 1 <= nums.length <= 5000
// -104 <= nums[i] <= 104
// All values of nums are unique.
// nums is an ascending array that is possibly rotated.
// -104 <= target <= 104

import java.util.Arrays;

public class SearchInRoratedSortedArray {
    public static int search(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }

        }

        return -1;
    }

}

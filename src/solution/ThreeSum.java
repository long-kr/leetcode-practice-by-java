package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Medium 
// Url: https://leetcode.com/problems/3sum/description/
//Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation: 
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.

// Constraints:
// 3 <= nums.length <= 3000
// -105 <= nums[i] <= 105

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3)
            return result;

        // Sort to defind direction from small to big
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            // skip duplicate I
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // stop if element > 0
            if (nums[i] > 0)
                break;

            // left smaller right
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1])
                        j++;

                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }

}

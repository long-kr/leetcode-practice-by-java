package solution;

import java.util.Arrays;
import java.util.PriorityQueue;

// medium
// url: https://leetcode.com/problems/kth-largest-element-in-an-array/description/
// Example 1:
// Input: [3,2,1,5,6,4] and k =
// Output: 5
// Explanation: The 2nd largest element is 5.
// Example 2:
// Input: [3,2,3,1,2,4,5,5,6] and k = 4
// Output: 4
// Explanation: The 4th largest element is 4.

// Constraints:
// 1 <= k <= nums.length <= 10^5
// -10^4 <= nums[i] <= 10^4

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        // using min heap since min-heap will keep smallest element at the top
        // so when size exceeds k, we can remove the smallest element
        // min-heap takes O(log k) time for insertion and deletion
        // overall time complexity: O(n log k) because number of elements are n
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);

            if (minHeap.size() > k)
                minHeap.poll();
        }

        return minHeap.peek();
    }

}

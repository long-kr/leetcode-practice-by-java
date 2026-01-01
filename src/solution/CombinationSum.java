package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// medium
// url: https://leetcode.com/problems/combination-sum/

// examples
// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// examples
// Input: candidates = [2,3,5], target = 8
// Output: [[2,2,2,2],[2,3,3],[3,5]]

//constrains
// 1 <= candidates.length <= 30
// 2 <= candidates[i] <= 40
// All elements of candidates are distinct.
// 1 <= target <= 40

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, res, new ArrayList<Integer>(), 0, 0);
        return new ArrayList<>(res);

    }

    private static void dfs(
            int[] candidates, int target,
            List<List<Integer>> res,
            List<Integer> path,
            int start, // need an index to avoid duplicates
            int sum) {

        System.out.println(path.toString());
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int val = candidates[i];

            if (val + sum > target)
                break;

            path.add(val);

            dfs(candidates, target, res, path, i, sum + val);

            path.remove(path.size() - 1);
        }
    }
}

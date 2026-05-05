package solution;

import java.util.ArrayList;
import java.util.List;

// medium
// https://leetcode.com/problems/generate-parentheses/description/

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        char[] arr = new char[2 * n];

        int op = n, cl = n;

        dfs(0, op, cl, res, arr);

        System.out.println(res.toString());

        return res;
    }

    private void dfs(int idx, int op, int cl, List<String> res, char[] arr) {

        if (op == 0 && cl == 0) {
            res.add(new String(arr));
            return;
        }

        if (cl < op || op < 0 || cl < 0)
            return;

        if (op > 0) {
            arr[idx] = '(';
            dfs(idx + 1, op - 1, cl, res, arr);

        }

        if (cl > 0) {
            arr[idx] = ')';
            dfs(idx + 1, op, cl - 1, res, arr);
        }

    }
}

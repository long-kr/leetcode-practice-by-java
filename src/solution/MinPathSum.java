package solution;

// medium: https://leetcode.com/problems/minimum-path-sum/description/

// Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
// Output: 7
// Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 200
// 0 <= grid[i][j] <= 200

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        // DP programming,
        // Find smallest possilbe of every cell
        int rows = grid.length;
        int cols = grid[rows - 1].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (row == 0 && col == 0)
                    continue;

                int fromTop = row > 0 ? grid[row - 1][col] : Integer.MAX_VALUE;
                int fromLeft = col > 0 ? grid[row][col - 1] : Integer.MAX_VALUE;

                grid[row][col] = Math.min(fromLeft, fromTop) + grid[row][col];
            }
        }

        return grid[rows - 1][cols - 1];
    }
}

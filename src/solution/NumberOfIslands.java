package solution;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int count = 0;

        if (grid == null || grid.length == 0)
            return count;

        int rows = grid.length;
        int cols = grid[0].length;

        // travel throught array
        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == '1') {
                    count++;
                    depth(grid, c, r);
                }

            }
        }

        return count;

    }

    // DFS
    private static void depth(char[][] grid, int c, int r) {

        // base case
        if (c < 0 || c > grid.length - 1 || r < 0 || r > grid[0].length - 1 || grid[c][r] == '0')
            return;

        // state
        grid[c][r] = '0';

        // choices
        depth(grid, c + 1, r + 1);
        depth(grid, c + 1, r - 1);
        depth(grid, c - 1, r + 1);
        depth(grid, c - 1, r - 1);

    }
}

package solution;

// medium

// url: https://leetcode.com/problems/word-search/description/
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true

// Constraints:
// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board and word consists of only lowercase and uppercase English letters.

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0)
            return true;

        if (board == null || board.length == 0 || board[0].length == 0)
            return false;

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (dfs(board, word, r, c, 0))
                        return true;
                }
            }
        }

        return false;

    }

    private static boolean dfs(char[][] board, String word, int r, int c, int idx) {

        if (idx == word.length())
            return true;

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length)
            return false;

        char saved = board[r][c];

        if (saved != word.charAt(idx))
            return false;

        if (idx + 1 < word.length()) {
            char next = word.charAt(idx + 1);
            boolean hasNextNeighbor = (r + 1 < board.length && board[r + 1][c] == next) ||
                    (r - 1 >= 0 && board[r - 1][c] == next) ||
                    (c + 1 < board[0].length && board[r][c + 1] == next) ||
                    (c - 1 >= 0 && board[r][c - 1] == next);
            if (!hasNextNeighbor)
                return false;
        }

        board[r][c] = '#';

        int newIdx = idx + 1;

        boolean found = dfs(board, word, r + 1, c, newIdx)
                || dfs(board, word, r - 1, c, newIdx)
                || dfs(board, word, r, c + 1, newIdx)
                || dfs(board, word, r, c - 1, newIdx);

        board[r][c] = saved;

        return found;
    }

}

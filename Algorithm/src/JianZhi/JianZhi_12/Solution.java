package JianZhi.JianZhi_12;

public class Solution {
    public static boolean dfs(char[][] board, String word, int i, int j, int num) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1
                || board[i][j] == '.' || board[i][j] != word.charAt(num)) return false;
        if (num == word.length() - 1 && board[i][j] == word.charAt(num)) return true;
        char temp = board[i][j];
        board[i][j] = '.';
        boolean isMatch = dfs(board, word, i - 1, j, num + 1) ||
                dfs(board, word, i, j - 1, num + 1) ||
                dfs(board, word, i + 1, j, num + 1) ||
                dfs(board, word, i, j + 1, num + 1);
        board[i][j] = temp;
        return isMatch;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
}

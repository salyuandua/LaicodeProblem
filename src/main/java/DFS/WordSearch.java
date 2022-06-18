package DFS;

public class WordSearch {
    public boolean isWord(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int i, int j, String word, int idx) {
        if (idx == word.length()) {
            return true;
        }
        if (i <0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != word.charAt(idx)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '*';
        idx++;
        boolean found = helper(board, i + 1, j, word, idx)
                || helper(board, i - 1, j, word, idx)
                || helper(board, i, j + 1, word, idx)
                || helper(board, i, j - 1, word, idx);
        board[i][j] = temp;
        return found;

    }
}

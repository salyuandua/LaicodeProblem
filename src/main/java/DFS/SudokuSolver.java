package DFS;

public class SudokuSolver {
    public void solveSudoku(int[][] board) {
        // write your code here
        helper(board, 0, 0);
    }

    private boolean helper(int[][] board, int row, int col) {
        int m = board.length;
        int n = board[0].length;
        if(col == n) {
            return helper(board, row + 1, 0);
        }
        if(row == m) {
            return true;
        }

        if(board[row][col] != 0) return helper(board, row, col + 1);
        for(int i = 1; i <= 9; i++) {
            if(!isValid(board, row, col, i)) continue;
            board[row][col] = i;
            if(helper(board, row, col)) {
                return true;
            }
            //helper(board, row, col + 1);
            board[row][col] = 0;
        }
        return false;
    }

    private boolean isValid(int[][] board, int row, int col, int n) {
        for(int i = 0; i < board.length; i++) {
            if(board[i][col] == n) return false;
        }
        for(int i = 0; i < board[0].length; i++) {
            if(board[row][i] == n) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == n)
                return false;
        }
        return true;
    }
}

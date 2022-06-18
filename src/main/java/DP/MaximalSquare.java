package DP;

public class MaximalSquare {
    public int maximalSquare(int[][] matrix) {
        // Write your solution here
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        for (int i =0; i < m; i++) {
            if (matrix[i][0] == 1) memo[i][0] = 1;
        }
        for (int i =0; i < n; i++) {
            if (matrix[0][i] == 1) memo[0][i] = 1;
        }
        int max = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    memo[i][j] = Math.max(memo[i - 1][j - 1], Math.max(memo[i - 1][j], memo[i ][j - 1]));
                }
                max = Math.max(max, memo[i][j]);
            }
        }
        return max;
    }
}

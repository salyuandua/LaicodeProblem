package DP;

public class PossiblePathswithObstacles {
    public int possiblepath(int[][] matrix) {
        // Write your solution here
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 1) break;
            memo[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 1) break;
            memo[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                memo[i][j] = matrix[i][j] == 0 ? 0 : memo[i - 1][j] + memo[i][j - 1];
            }
        }
        return memo[m - 1][n - 1];
    }
}

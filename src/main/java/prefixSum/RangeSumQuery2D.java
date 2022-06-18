package prefixSum;

public class RangeSumQuery2D {
    public int sumRegion(int[][] matrix, int row1, int col1, int row2, int col2) {
        // Write your solution here
        int[][] memo = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < memo.length; i++) {
            for (int j = 1; j < memo[0].length; j++) {
                memo[i][j] = memo[i - 1][j] + memo[i][j - 1] - memo[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        return memo[row2 + 1][col2 + 1] - memo[row1][col2 + 1] - memo[row2 + 1][col1] + memo[row1][col1];

    }
}

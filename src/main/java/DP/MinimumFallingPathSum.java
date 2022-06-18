package DP;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] a) {
        // Write your code here
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int leftTop = j - 1 < 0 ? Integer.MAX_VALUE : a[i - 1][j -1];
                int top = a[i - 1][j];
                int rightTop = j + 1 > n -1 ? Integer.MAX_VALUE : a[i -1][j + 1];
                a[i][j] += Math.min(leftTop, Math.min(rightTop, top));
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, a[n - 1][i]);
        }
        return min;
    }
}

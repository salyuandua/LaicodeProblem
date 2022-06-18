package DP;

public class BuyStockIII {
    public int maxProfit(int[] array) {
        // Write your solution here
        int n = array.length;
        int[][][] memo = new int[n][3][2];
        memo[0][1][0] = 0;
        memo[0][1][1] = -array[0];
        memo[0][2][0] = 0;
        memo[0][2][1] = -array[0];
        for (int i = 1; i < n; i++) {
            for (int k = 2; k >= 1; k--) {
                memo[i][k][0] = Math.max(memo[i - 1][k][0], memo[i - 1][k][1] + array[i]);
                memo[i][k][1] = Math.max(memo[i - 1][k][1], memo[i - 1][k - 1][0] - array[i]);
            }
        }
        return memo[n - 1][2][0];
    }
}

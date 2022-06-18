package DP;

public class BuyStockII {
    public int maxProfit(int[] array) {
        if (array==null||array.length==0) return 0;
        int n = array.length;
        int[][] memo = new int[n][2];
        memo[0][0] = 0;
        memo[0][1] = -array[0];
        for (int i = 1; i < n; i++) {
            memo[i][0] = Math.max(memo[i - 1][0], memo[i - 1][1] + array[i]);
            memo[i][1] = Math.max(memo[i - 1][1], memo[i - 1][0] - array[i]);
        }
        return memo[n - 1][0];
    }
}

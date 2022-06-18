package DP;

import java.util.Arrays;

public class LongestPalindromeSubsequence {
    public int longestPalindrome(String input) {
        // Write your solution here
        if (input == null || input.length() == 0) return 0;
        if (input.length() == 1) return 1;
        int[][] dp = new int[input.length()][input.length()];
        for (int[] subDp : dp) {
            Arrays.fill(subDp, Integer.MIN_VALUE);
        }
        return helper(input, 0, input.length() - 1, dp);
    }

    private int helper(String input, int i, int j, int[][] dp) {
        if (i > j) return 0;
        if (i == j) return 1;
        if (dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
        if (input.charAt(i) == input.charAt(j)) {
            dp[i][j] = helper(input, i+1, j-1, dp) + 2;
        }else {
            dp[i][j] = Math.max(helper(input, i, j - 1, dp), helper(input, i + 1, j, dp));
        }
        return dp[i][j];
    }
}

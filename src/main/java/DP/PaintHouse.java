package DP;

public class PaintHouse {
    public int minCost(int[][] costs) {
        // Write your solution here
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int[][] m = new int[n][3];
        m[0][0] = costs[0][0];
        m[0][1] = costs[0][1];
        m[0][2] = costs[0][2];
        for (int i = 1; i < n; i++) {
            m[i][0] = Math.min(m[i - 1][1], m[i-1][2]) + costs[i][0];
            m[i][1] = Math.min(m[i - 1][0], m[i-1][2]) + costs[i][1];
            m[i][2] = Math.min(m[i-1][0],m[i-1][1]) + costs[i][2];
        }
        return Math.min(Math.min(m[n - 1][0], m[n-1][1]), m[n-1][2]);
    }
}

package DP;

public class Triangle {
    public int minimumTotal(int[][] triangle) {
        // write your code here
        int m = triangle.length;
        int[][] memo = new int[m + 1][m + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = i; j >=0; j--) {
                memo[i][j] = Math.min(memo[i + 1][j], memo[i + 1][j + 1]) + triangle[i][j];
            }
        }
        return memo[0][0];
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        System.out.println(triangle.minimumTotal(new int[][]{{1},{2,3}}));
    }
}

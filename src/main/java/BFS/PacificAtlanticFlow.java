package BFS;

import java.util.*;

public class PacificAtlanticFlow {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        // Write your solution here
        List<List<Integer>> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length ==0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

        boolean[][] visited1 = new boolean[m][n];
        boolean[][] visited2 = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            helper(matrix, visited1, i, 0, dirs);
            helper(matrix, visited2, i, n-1, dirs);
        }

        for (int j = 0; j < n; j++) {
            helper(matrix, visited1, 0, j, dirs);
            helper(matrix, visited2, m-1, j, dirs);
        }



        for (int x= 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (visited1[x][y] && visited2[x][y]) {
                    result.add(Arrays.asList(x, y));
                }
            }
        }

        return  result;

    }

    private void helper(int[][] matrix, boolean[][] visited,  int i, int j, int[][] dirs) {
        int m = matrix.length, n = matrix[0].length;
        visited[i][j] = true;
        for (int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];
            if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || matrix[x][y] < matrix[i][j]) continue;
            helper(matrix, visited, x, y, dirs);
        }
    }

    private void helper1(int[][] matrix, boolean[][] visited, int i, int j, int[][] dirs) {
        int m = matrix.length;
        int n = matrix[0].length;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int newi = i + dir[0];
            int newj = j + dir[1];
            if (newi >= 0 && newi < m && newj >= 0 && newj < n && !visited[newi][newj] && matrix[newi][newj] >= matrix[i][j]) {
                helper1(matrix, visited, newi, newj, dirs);
            }
        }
    }

}

package DFS;

import java.util.List;

public class NumberofIslandsII {
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<Integer> numIslands(int m, int n, int[][] positions) {
        // Write your solution here
        int[][] islands = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        return null;
    }

    private void helper(int[][] islands, boolean[][] visited, int i, int j, boolean[] isIsolated) {
        visited[i][j] = true;
        for (int k = 0; k < dirs.length; k++) {
            int x = i + dirs[k][0];
            int y = j + dirs[k][1];
            if (x < 0 || x >= islands.length || y < 0 || y >= islands[0].length || islands[x][y] == 0) {
                continue;
            }
            if (visited[x][y]) {
                isIsolated[0] = false;
            }
        }
    }
}

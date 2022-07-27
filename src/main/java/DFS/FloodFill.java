package DFS;

public class FloodFill {

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Write your code here
        boolean[][] visted = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, image[sr][sc], newColor, visted);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int sourceColor, int newColor, boolean[][] visited) {
        image[sr][sc] = newColor;
        visited[sr][sc] = true;
        for(int[] dir : dirs) {
            int x = sr + dir[0];
            int y = sc + dir[1];
            if(x >= 0 && y >= 0 && x < image.length && y < image[0].length && image[x][y] == sourceColor && !visited[x][y]) {
                dfs(image, x, y, sourceColor, newColor, visited);
            }
        }
    }
}

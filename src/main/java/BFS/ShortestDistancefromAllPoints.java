package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistancefromAllPoints {
    public int shortestDistance(int[][] grid) {
        // Write your solution here
        int[][] distance = new int[grid.length][grid[0].length];
        int[][] reach = new int[grid.length][grid[0].length];
        int buildingNum = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    buildingNum++;
                    bfs(grid, distance, reach, new int[]{i, j});
                }
            }
        } 
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0 && distance[i][j] < res && reach[i][j] == buildingNum) {
                    res = distance[i][j];
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;

      }

    private void bfs(int[][] grid, int[][] distance, int[][] reach, int[] start) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visted = new boolean[grid.length][grid[0].length];
        queue.offer(start);
        visted[start[0]][start[1]] = true;
        int dist = 0;
        while(!queue.isEmpty()) {
            dist++;
            for(int i = 0; i < queue.size(); i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                for(int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if(newX <0 || newY < 0 || newX >= grid.length || newY >= grid[0].length 
                    || grid[newX][newY] != 0 || visted[newX][newY]) {
                        continue;
                    }
                    queue.offer(new int[]{newX, newY});
                    visted[newX][newY] = true;
                    distance[newX][newY] += dist;
                    reach[newX][newY] ++;
                }
                

            }
        }
    }  
}

package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Wallsandgates {
    public int[][] wallsAndGates(int[][] rooms) {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        for(int i  =0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for(int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if(x >= 0 && y >= 0 && x < rooms.length && y < rooms[0].length && rooms[x][y] == Integer.MAX_VALUE) {
                    rooms[x][y] = rooms[cur[0]][cur[1]] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return rooms;
    }
}

package BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistancetoZero {
    public int[][] updateMatrix(int[][] matrix) {
        // Write your solution here
        int[][] result = new int[matrix.length][matrix[0].length];
        //Arrays.fill(result, Integer.MAX_VALUE);
        Queue<Entry> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                    queue.offer(new Entry(i, j));
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        while (!queue.isEmpty()) {
            Entry cur = queue.remove();
            for (int i = 0; i < dirs.length; i++) {
                int newRow = cur.x + dirs[i][0];
                int newCol = cur.y + dirs[i][1];
                if (newRow >=0 && newCol >=0 && newRow < matrix.length && newCol < matrix[0].length) {
                    if (result[newRow][newCol] > result[cur.x][cur.y] + 1) {
                        result[newRow][newCol] = result[cur.x][cur.y] + 1;
                        queue.offer(new Entry(newRow, newCol));
                    }
                }
            }
        }

        return result;
    }

    static class Entry {
        int x;
        int y;
        public Entry(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        DistancetoZero zero = new DistancetoZero();
        int[][] result = zero.updateMatrix(new int[][]{{1, 1, 1},{0,1,0},{0,0,0}});
        System.out.println(result);
    }
}

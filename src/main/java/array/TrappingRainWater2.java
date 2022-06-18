package array;

import java.util.PriorityQueue;

public class TrappingRainWater2 {
    public int maxTrapped(int[][] matrix) {
        // Write your solution here
        PriorityQueue<Point> pq = new PriorityQueue<>();
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            pq.offer(new Point(i, 0, matrix[i][0]));
            matrix[i][0] = -1;
            pq.offer(new Point(i, col - 1, matrix[i][col - 1]));
            matrix[i][col - 1] = -1;
        }

        for (int i = 1; i < col - 1; i++) {
            pq.offer(new Point(0, i, matrix[0][i]));
            matrix[0][i] = -1;
            pq.offer(new Point(row - 1, i, matrix[row - 1][i]));
            matrix[row - 1][i] = -1;
        }
        int[] idx = {-1, 1, 0, 0};
        int[] idy = {0, 0, -1, 1};
        int water = 0;

        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            for (int k = 0; k < 4; k++) {
                int newX = cur.x + idx[k];
                int newY = cur.y + idy[k];
                if (newX >= 0 && newX < row && newY >=0 && newY < col && matrix[newX][newY] != -1) {
                    water += Math.max(0, cur.h - matrix[newX][newY]);
                    pq.offer(new Point(newX, newY, Math.max(cur.h, matrix[newX][newY])));
                    matrix[newX][newY] = -1;
                }
            }
        }
        return water;
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int h;

        public Point(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(h, o.h);
        }
    }
}

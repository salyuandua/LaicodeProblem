package heap;

import java.util.PriorityQueue;

public class KthSmallestNumberInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Entry> pq = new PriorityQueue<>();
        boolean[][] visted = new boolean[matrix.length][matrix[0].length];
        pq.offer(new Entry(0 , 0, matrix[0][0]));
        visted[0][0] = true;
        for (int i = 1; i <= k-1; i++) {
            if (!pq.isEmpty()) {
                Entry cur = pq.poll();
                if (cur.x + 1 < matrix.length && !visted[cur.x + 1][cur.y]) {
                    pq.offer(new Entry(cur.x + 1, cur.y, matrix[cur.x+ 1][cur.y]));
                    visted[cur.x + 1][cur.y] = true;
                }
                if (cur.y + 1 < matrix[0].length && !visted[cur.x][cur.y + 1]) {
                    pq.offer(new Entry(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
                    visted[cur.x][cur.y+ 1] = true;
                }
            }
        }
        return pq.peek().value;
    }

    private static class Entry implements Comparable<Entry>{
        private int x;
        private int y;
        private int value;

        public Entry(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Entry o) {
            return Integer.compare(this.value, o.value);
        }
    }
}

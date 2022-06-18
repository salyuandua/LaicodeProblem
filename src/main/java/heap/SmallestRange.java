package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SmallestRange {
    public static int[] smallestRange(int[][] arrays) {
        int[] range = new int[]{0, Integer.MAX_VALUE};
        int max = Integer.MIN_VALUE;
        PriorityQueue<Entry> pq = new PriorityQueue<>();
        for (int i = 0; i < arrays.length; i++) {
            pq.offer(new Entry(i, 0, arrays[i][0]));
            max = Math.max(max, arrays[i][0]);
        }
        while (!pq.isEmpty() && pq.size() == arrays.length) {
            Entry cur = pq.poll();
            if (max - cur.value < range[1] - range[0]) {
                range[0] = cur.value;
                range[1] = max;
            }
            if (max - cur.value == range[1] - range[0] && range[0] > cur.value) {
                range[0] = cur.value;
                range[1] = max;
            }
            if (cur.col+1 < arrays[cur.row].length) {
                pq.offer(new Entry(cur.row, cur.col + 1, arrays[cur.row][cur.col + 1]));
                max = Math.max(max, arrays[cur.row][cur.col + 1]);
            }
        }
        return range;
    }

    static class Entry implements Comparable<Entry> {
        int row;
        int col;
        int value;

        public Entry(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        @Override
        public int compareTo(Entry o) {
            return Integer.compare(value, o.value);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallestRange(new int[][]{ { 1, 4, 6 },

                { 2, 5 },

                { 8, 10, 15} })));
    }
}

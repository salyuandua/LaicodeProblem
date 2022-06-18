package heap;

import java.util.PriorityQueue;

public class SuperUglyNumber {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        // Write your solution here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(1);
        for (int i = 1; i < n ; i++) {
            int cur = pq.poll();
            while (!pq.isEmpty() && cur == pq.peek()) {
                cur = pq.poll();
            }
            for (int prime : primes) {
                long multiply = (long) cur * (long) prime;
                if (multiply < Integer.MAX_VALUE) {
                    pq.offer((int) multiply);
                }
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        System.out.println(nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }
}

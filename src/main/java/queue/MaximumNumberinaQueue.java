package queue;

import java.util.Queue;

public class MaximumNumberinaQueue {
    public int maxInQueue(Queue<Integer> queue) {
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            max = Math.max(max, queue.poll());
        }
        return max;
    }
}

package heap;

import java.util.PriorityQueue;

public class MedianTracker {
    private PriorityQueue<Integer> first;
    private PriorityQueue<Integer> second;


    public MedianTracker() {
        first = new PriorityQueue<>((n1, n2) -> {
            return Integer.compare(n2, n1);
        });
        second = new PriorityQueue<>();

    }
    

    public void read(int value) {
        if(first.isEmpty()) {
            first.offer(value);
            return;
        }
        if(value > first.peek()) {
            second.offer(value);
        }else {
            first.offer(value);
        }
        if(Math.abs(first.size() - second.size()) > 1) {
            if(first.size() > second.size()) {
                second.offer(first.poll());
            }else {
                first.offer(second.poll());
            }
        }
    }

    public Double median() {
        if(first.isEmpty() && second.isEmpty()) return 0.00;
        if(first.size() == second.size()) {
            return  ((double)first.peek() / (double) second.peek()) / 2;
        }
        return  first.size() > second.size() ? (double)first.peek() : (double)second.peek();
    }
}

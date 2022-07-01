package slidingwindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaximumValuesOfSizeKSlidingWindows {
    public List<Integer> maxWindows(int[] array, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {
            int windowStartIdx = i - k + 1;
            while(!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
            while(!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if(windowStartIdx >= 0) res.add(array[deque.peekFirst()]);
        }
        return res;
    }
}

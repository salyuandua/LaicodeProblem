package string.slidingWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaximumValuesOfSizeKSlidingWindows {
    public List<Integer> maxWindows(int[] array, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            while (!deque.isEmpty() && array[deque.getLast()] <= num) {
                deque.removeLast();
            }
            deque.addLast(i);
            if (i - k + 1 >= 0) {
                result.add(array[deque.getFirst()]);
            }
            if (i - k + 1 >= deque.getFirst()) {
                deque.removeFirst();
            }
        }
        return result;
    }
}

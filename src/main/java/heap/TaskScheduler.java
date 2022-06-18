package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
//    public int leastInterval(String[] tasks, int n) {
//        // Write your solution here
//        Map<String, Integer> map = new HashMap<>();
//        PriorityQueue<Entry> pq = new PriorityQueue<>();
//        for (String task : tasks) {
//            map.put(task, map.getOrDefault(task, 0) + 1);
//        }
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            pq.offer(new Entry(entry.getKey(), entry.getValue()));
//        }
//        while (!pq.isEmpty()) {
//            for (int i = 0; i <) {
//
//            }
//
//        }
//
//
//
//    }

    static class Entry implements Comparable<Entry> {
        String c;
        int count;

        public Entry(String c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public int compareTo(Entry o) {
            return Integer.compare(o.count, count);
        }
    }

}

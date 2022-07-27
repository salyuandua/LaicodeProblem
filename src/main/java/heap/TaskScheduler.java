package heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
   public int leastInterval(String[] tasks, int n) {
       // Write your solution here
       int res = 0;
       Map<String, Integer> map = new HashMap<>();
       PriorityQueue<Entry> pq = new PriorityQueue<>();
       for (String task : tasks) {
           map.put(task, map.getOrDefault(task, 0) + 1);
       }
       for (Map.Entry<String, Integer> entry : map.entrySet()) {
           pq.offer(new Entry(entry.getKey(), entry.getValue()));
       }
       while (!pq.isEmpty()) {
        int size = Math.min(n, pq.size());
        List<Entry> temp = new ArrayList<>(); 
        for (int i = 0; i < size; i++) {
            Entry cur = pq.poll();
            cur.count--;
            if(cur.count != 0) temp.add(cur);
        }
        if(temp.isEmpty()) {
            res += size;
        }else {
            res += n;
        }
        for(Entry e : temp) {
            pq.offer(e);
        }
       }
       return res;

   }

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

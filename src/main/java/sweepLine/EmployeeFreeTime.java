package sweepLine;

import pojo.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(int[][] schedule) {
        // Write your code here
        List<Interval> res = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        for (int[] onePerson : schedule) {
            for (int i = 0; i < onePerson.length - 1; i+=2) {
                pq.offer(new Interval(onePerson[i], onePerson[i + 1]));
            }
        }
        Interval cur  = pq.poll();
        while (!pq.isEmpty()) {
            Interval next = pq.poll();
            if (cur.end >= next.start) {
                cur.end = Math.max(cur.end, next.end);
            }else {
                res.add(new Interval(cur.end, next.start));
                cur = next;
            }
        }
        return res;

    }
}

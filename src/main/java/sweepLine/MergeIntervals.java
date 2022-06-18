package sweepLine;

import pojo.Interval;

import java.util.*;

public class MergeIntervals {
    public int length(List<Interval> intervals) {
        // Write your solution here.
        if (intervals == null || intervals.size() == 0) return 0;
        List<int[]> list = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        int length = 0;
        Interval cur = intervals.get(0);
       // length = cur.end -cur.start;
        for (int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(0);
            if (cur.end <= next.start) {
                length += (cur.end - cur.start);
                cur = next;
            }else{
                cur.end = Math.max(cur.end, next.end);
            }
        }
        length += (cur.end - cur.start);

        return length;
    }
}

package sweepLine;

import pojo.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // write your code here

        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return  res;
        for (Interval in : intervals) {
            if (newInterval == null || newInterval.start > in.end){
                res.add(in);
            }else if(newInterval.end < in.start) {
                res.add(newInterval);
                res.add(in);
                newInterval = null;
            }else {
                newInterval.start = Math.min(newInterval.start, in.start);
                newInterval.end = Math.max(newInterval.end, in.end);
            }
        }
        if (newInterval != null) res.add(newInterval);
        return res;
    }
}

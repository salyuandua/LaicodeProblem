package sweepLine;

import java.util.*;

public class NumberofAirplanesintheSky {
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }
        List<Entry> entries = new ArrayList<>();
        for (Interval interval : airplanes) {
            entries.add(new Entry(interval.start, 1));
            entries.add(new Entry(interval.end, -1));
        }
        Collections.sort(entries, new Comparator<Entry>() {
            @Override
            public int compare(Entry o1, Entry o2) {
                if (o1.time == o2.time) return Integer.compare(o1.cost, o2.cost);
                return Integer.compare(o1.time, o2.time);
            }
        });
        int airPlanNumber = 0;
        int max = 0;
        for (Entry entry : entries) {
            airPlanNumber += entry.cost;
            max = Math.max(max, airPlanNumber);
        }
        return max;


    }


    static class Entry {
        int time;
        int cost;

        public Entry(int time, int cost) {
            this.time = time;
            this.cost = cost;
        }
    }

 public class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }
}

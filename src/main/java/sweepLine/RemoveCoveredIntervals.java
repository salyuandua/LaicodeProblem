package sweepLine;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o2[1], o1[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int[] cur = intervals[0];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (cur[0] <= next[0] && cur[1] >= next[1]) {
                count++;
            }else if(cur[1] >= next[0] && cur[1] <= next[1]) {
                cur[1] = next[1];
            }else {
                cur = next;
            }
        }
        return intervals.length - count;

    }
}

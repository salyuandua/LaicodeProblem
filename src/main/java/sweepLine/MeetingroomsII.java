package sweepLine;

import java.util.*;

public class MeetingroomsII {
    public int minMeetingRooms(int[][] intervals) {
        // Write your solution here
        if (intervals == null || intervals.length == 0) return 0;
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(new int[]{interval[0], 1});
            list.add(new int[]{interval[1], -1});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int res = 0;
        int max = 0;
        for (int[] l : list) {
            res += l[1];
            max = Math.max(max, res);
        }
        return max;
    }
}

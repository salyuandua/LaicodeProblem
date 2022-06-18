package sweepLine;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingSchedule {
    public int maximumMeetings(int[][] intervals) {
        // Write your solution here
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int[] cur = intervals[0];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (next[0] > cur[0] && next[1] < cur[0]) {
                cur = next;
            }
            if (next[0] > cur[1]) {
                count++;
                cur[0] = Math.min(cur[0], next[0]);
                cur[1] = Math.max(cur[1], next[1]);
            }

        }
        return count;

    }

    public static void main(String[] args) {
        MeetingSchedule schedule = new MeetingSchedule();
        System.out.println(schedule.maximumMeetings(new int[][]{{14,16},{2,17},{13,15},{15,16},{14,18},{9,13},{12,15},{10,14},{5,14},{16,17},{1,18},{12,18},{16,17},{3,15}}));
    }
}

package math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        // Write your solution here
        if(grid == null || grid.length == 0) return 0;
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }   
        Collections.sort(rows);
        Collections.sort(cols);
        return getMinDistance(rows) + getMinDistance(cols);

    }

    private int getMinDistance(List<Integer> array) {
        int median = array.get(array.size()/2);
        int distance = 0;
        for(int num : array) {
            distance += Math.abs(num - median);
        }
        return distance;
    }


}

package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededtoInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Queue<Integer> queue = new LinkedList<>();
        // for(int i = 0; i < manager.length; i++) {
        //     if(manager[i] == headID) queue.offer(i);
        // }
        queue.offer(headID);
        int costTime = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int cur = queue.poll();
                costTime += informTime[cur];
                for(int k = 0; k < manager.length; k++) {
                    if(manager[k] == cur) queue.offer(k);
                }
            }
        }
        return costTime;
    }
}

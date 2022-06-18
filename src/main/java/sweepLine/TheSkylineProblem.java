package sweepLine;

import java.util.*;

public class TheSkylineProblem {
    public int[][] getSkyline(int[][] buildings) {
        // Write your solution here
        List<int[]> list = new ArrayList<>();
        List<int[]> res = new ArrayList<>();
        for (int[] building : buildings) {
            list.add(new int[]{building[0], -building[2]});
            list.add(new int[]{building[1], building[2]});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return Integer.compare(o1[0], o2[0]);
                }
                return Integer.compare(o2[1], o1[1]);
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        pq.offer(0);
        int prevHeight = Integer.MIN_VALUE;
        for (int[] building : list) {
            int x = building[0];
            int height = building[1];
            if (height < 0) {
                pq.offer(-height);
            }else {
                pq.remove(height);
            }
            int peekHeight = pq.peek();
            if (peekHeight != prevHeight) {
                res.add(new int[]{x, peekHeight});
                prevHeight = peekHeight;
            }
        }
        int[][] finalRes = new int[res.size()][2];
        for (int i = 0; i < finalRes.length; i++) {
            finalRes[i] = res.get(i);
        }
        return finalRes;
    }
}

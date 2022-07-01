package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FlightswithLowestPriceStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Write your solution here
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] flight : flights) {
            List<int[]> edges = graph.getOrDefault(flight[0], new ArrayList<>());
            edges.add(new int[]{flight[1], flight[2]});
            graph.put(flight[0], edges);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                return Integer.compare(o1[1], o2[1]);;
            }
            
        });
        int[] distanceTo = new int[n];
        Arrays.fill(distanceTo, Integer.MAX_VALUE);
        distanceTo[src] = 0;
        pq.offer(new int[]{src, 0});
        int count = 0;
        while(!pq.isEmpty()) {
            if(count > k) return -1;
            int[] cur = pq.poll();
            if(cur[0] == dst) return distanceTo[dst];
            if(cur[1] > distanceTo[cur[0]]) continue;
            List<int[]> edges = graph.get(cur[0]);
            if(edges == null) continue;
            for(int[] edge : edges) {
                int distanceToNext = distanceTo[cur[0]] + edge[1];
                if(distanceToNext < distanceTo[edge[0]]) {
                    distanceTo[edge[0]] = distanceToNext;
                    pq.offer(new int[]{edge[0], distanceToNext});
                    count++;
                }
            }


        }
        return -1;
    
      }
}

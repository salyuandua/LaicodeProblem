package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Write your code here
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for(int[] time : times) {
            List<Edge> edges = graph.getOrDefault(time[0], new ArrayList<>());
            edges.add(new Edge(time[0], time[1], time[2]));
            graph.put(time[0], edges);
            edges = graph.getOrDefault(time[1], new ArrayList<>());
            edges.add(new Edge(time[1], time[0], time[2]));
            graph.put(time[1], edges);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> {
            return Integer.compare(e1[1], e2[1]);
        });
        int time = 0;
        int[] distanceTo = new int[n + 1];
        Arrays.fill(distanceTo, Integer.MAX_VALUE);
        distanceTo[k] = 0;
        pq.offer(new int[]{k, 0});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(cur[1] > distanceTo[cur[0]]) {
                continue;
            }
            List<Edge> edges  =  graph.get(cur[0]);
            if(edges == null) continue;
            for(Edge edge : edges) {
                int distanceToNext = edge.distance + distanceTo[cur[0]];
                if(distanceToNext < distanceTo[edge.target]) {
                    distanceTo[edge.target] = distanceToNext;
                    pq.offer(new int[]{edge.target, distanceToNext});
                }
            }
        }
        for(int i = 1; i <= n; i++) {
            if(distanceTo[i] == Integer.MAX_VALUE) return -1;
            time = Math.max(time, distanceTo[i]);
        }
        return time;

    }

    private static class Edge {
        int source;
        int target;
        int distance;
        public Edge(int source, int target, int distance) {
            this.source = source;
            this.target = target;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        NetworkDelayTime delayTime  = new NetworkDelayTime();
        System.out.println(delayTime.networkDelayTime(new int[][]{{1,2,1}}, 2, 1));
    }
}

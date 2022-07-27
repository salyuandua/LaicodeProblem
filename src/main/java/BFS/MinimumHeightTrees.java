package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MinimumHeightTrees {
    // public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    //     // Write your solution here
    //     Map<Integer, List<Integer>> graph = new HashMap<>();
    //     int[] degree = new int[n];
    //     for(int[] edge : edges) {
    //         int from = edge[0];
    //         int to = edge[1];
    //         List<Integer> list = graph.getOrDefault(from, new ArrayList<>());
    //         list.add(to);
    //         graph.put(from, list);
    //         list = graph.getOrDefault(to, new ArrayList<>());
    //         list.add(from);
    //         graph.put(to, list);
    //         degree[from]++;
    //         degree[to]++;
    //     }
    

    //     Queue<Integer> queue  = new LinkedList<>();
    //     for(int i = 0; i < degree.length; i++) {
    //         if(degree[i] == 1) queue.offer(i);
    //     }
    //     List<Integer> res = new ArrayList<>();
    //     while(!queue.isEmpty()) {
    //         int size = queue.size();
    //         List<Integer> localRes = new ArrayList<>();
    //         for(int i = 0; i < size; i++) {
    //             int cur = queue.poll();
    //             localRes.add(cur);
    //             List<Integer> list = graph.get(cur);
    //             for() {

    //             }


    //         }


    //     }


    //   }
}

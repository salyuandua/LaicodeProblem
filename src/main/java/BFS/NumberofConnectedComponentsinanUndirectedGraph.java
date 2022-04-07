package BFS;

import java.util.*;

public class NumberofConnectedComponentsinanUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n ; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            int from = entry.getKey();
            if (!visited[from]) {
                count++;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(from);
                while (!queue.isEmpty()) {
                    int cur = queue.remove();
                    visited[cur] = true;
                    List<Integer> nodes = graph.get(cur);
                    for (int node : nodes) {
                        if (!visited[node]) {
                            queue.add(node);
                        }

                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberofConnectedComponentsinanUndirectedGraph undirectedGraph = new NumberofConnectedComponentsinanUndirectedGraph();
        System.out.println(undirectedGraph.countComponents(11, new int[][]{{4,7},{1,8},{0,3},{8,9},{3,9},{3,7}}));
    }
}

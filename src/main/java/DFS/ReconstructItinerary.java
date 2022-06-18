package DFS;

import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        // Write your solution here
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (String[] ticket : tickets) {
            PriorityQueue<String> pq = graph.getOrDefault(ticket[0], new PriorityQueue<>());
            pq.offer(ticket[1]);
            graph.put(ticket[0], pq);
        }
        List<String> result = new ArrayList<>();
        dfs(graph, "JFK", result);
        Collections.reverse(result);
        return result;

    }

    private void dfs(Map<String, PriorityQueue<String>> graph, String cur, List<String> result) {
        PriorityQueue<String> pq = graph.get(cur);
        if (pq != null && !pq.isEmpty()) {
            while (!pq.isEmpty()) {
                dfs(graph, pq.poll(), result);
            }
        }
        result.add(cur);
    }

}

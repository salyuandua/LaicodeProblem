package DFS;

import java.util.*;

public class KeysandRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // Write your code here
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < rooms.size(); i++) {
            List<Integer> keys = graph.getOrDefault(i , new ArrayList<>());
            keys.addAll(rooms.get(i));
            graph.put(i, keys);
        }
        Set<Integer> visted = new HashSet<>();
        dfs(graph, visted, 0);
        return visted.size() == rooms.size();

    }

    private void dfs(Map<Integer, List<Integer>> graph, Set<Integer> visted, int cur) {
        visted.add(cur);
        List<Integer> keys = graph.get(cur);
        if (keys != null && !keys.isEmpty()) {
            for (Integer key : keys) {
                if (!visted.contains(key)) {
                    dfs(graph, visted, key);
                }
            }
        }
    }
}

package BFS;

import java.util.*;

public class PossibleBipartition {

    private static final String GROUP_ONE_NAME = "group1";
    private static final String GROUP_TWO_NAME = "group2";

    public boolean possibleBipartition(int n, int[][] dislikes) {
        // Write your code here.
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, List<Integer>> disLikeMap = new HashMap<>();
        for (int[] dislike : dislikes) {
            List<Integer> dislikeArray = disLikeMap.getOrDefault(dislike[0], new ArrayList<>());
            dislikeArray.add(dislike[1]);
            disLikeMap.put(dislike[0], dislikeArray);
            dislikeArray = disLikeMap.getOrDefault(dislike[1], new ArrayList<>());
            dislikeArray.add(dislike[0]);
            disLikeMap.put(dislike[1], dislikeArray);
        }
        for (int i = 1; i <= n; i++) {
            if (map.containsKey(i)) continue;
            queue.offer(i);
            map.put(i, GROUP_ONE_NAME);
            while (!queue.isEmpty()) {
                int cur = queue.remove();
                for (int dislike : disLikeMap.get(cur)) {
                    if (map.containsKey(dislike) && map.get(dislike).equals(map.get(cur))) {
                        return false;
                    }
                    if (map.containsKey(dislike)) continue;
                    String group = map.get(cur).equals(GROUP_ONE_NAME) ? GROUP_TWO_NAME : GROUP_ONE_NAME;
                    map.put(dislike, group);
                    queue.offer(dislike);
                }
            }
        }
        return true;

    }
}

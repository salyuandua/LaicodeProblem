package BFS;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Write your solution here
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            inDegree[to]++;
            if (graph.containsKey(from)) {
                graph.get(from).add(to);
                continue;
            }
            List<Integer> nodes = new ArrayList<>();
            nodes.add(to);
            graph.put(from, nodes);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i< inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int from = queue.remove();
            List<Integer> nodes = graph.get(from);
            if (nodes == null) {
                continue;
            }
            for (int i = 0; i < nodes.size(); i++) {
                int to = nodes.get(i);
                inDegree[to]--;
                if (inDegree[to] == 0) {
                    queue.offer(to);
                }
            }
        }
        for (int n : inDegree) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }
}

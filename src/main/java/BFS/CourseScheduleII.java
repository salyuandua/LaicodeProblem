package BFS;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
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
        for (int i =0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            result.add(cur);
            List<Integer> nodes = graph.get(cur);
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
        int[] finalResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }
}

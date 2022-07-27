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

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            indegrees[to]++;
            List<Integer> edges = graph.getOrDefault(from, new ArrayList<>());
            edges.add(to);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegrees.length; i++) {
            if(indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            List<Integer> edges = graph.get(cur);
            if(edges == null) continue;
            
            for(int edge : edges) {
                indegrees[edge]--;
                if(indegrees[edge] == 0) {
                    queue.offer(edge);
                }
            }

        }
        for(int i : indegrees) {
            if(i != 0) {
                return false;
            }
        }
        return true;



    }



}

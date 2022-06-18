package DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class AllPathsFromSourcetoTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        helper(graph, 0, new ArrayList<>(), result);
        return result;

    }

    private void helper(int[][] graph, int cur, List<Integer> curResult, List<List<Integer>> result) {
        if (cur == graph.length - 1) {
            result.add(new ArrayList<>(curResult));
            return;
        }

        for (int nei : graph[cur]) {
            curResult.add(cur);
            helper(graph, nei, curResult, result);
            curResult.remove(curResult.size() - 1);
        }

    }

    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        atomicBoolean.compareAndSet(true, false);
        System.out.println(atomicBoolean.get());
    }
}

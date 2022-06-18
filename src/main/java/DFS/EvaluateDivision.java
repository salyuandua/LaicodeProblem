package DFS;

import java.util.*;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // write your code here

        Map<String, List<Entry>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String firstNum = equations.get(i).get(0);
            String secondNum = equations.get(i).get(1);
            List<Entry> entries = graph.getOrDefault(firstNum, new ArrayList<>());
            entries.add(new Entry(secondNum, values[i]));
            graph.put(firstNum, entries);
            entries = graph.getOrDefault(secondNum, new ArrayList<>());
            entries.add(new Entry(firstNum, 1.0 / values[i]));
            graph.put(secondNum, entries);
        }
        double[] finalResult = new double[queries.size()];
        Arrays.fill(finalResult, -1.0);

        for (int i = 0; i < queries.size(); i++) {
            dfs(queries.get(i).get(0), queries.get(i).get(1), 1.0, graph, new HashSet<>(), finalResult, i);
        }
        return finalResult;

    }

    private void dfs(String from, String to, double cur, Map<String, List<Entry>> graph, Set<String> visited, double[] finalResult, int idx) {
        if (visited.contains(from)) return;
        visited.add(from);
        if (!graph.containsKey(from)) return;
        if (from.equals(to)) {
            finalResult[idx] = cur;
            return;
        }
        for (Entry entry : graph.get(from)) {
            dfs(entry.val, to, cur * entry.result, graph, visited, finalResult, idx);
        }
    }


    static class Entry {
        String val;
        double result;
        public Entry(String val, double result) {
            this.val  =val;
            this.result = result;
        }
    }

}

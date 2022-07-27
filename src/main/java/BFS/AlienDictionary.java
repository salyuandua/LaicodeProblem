package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        // Write your solution here
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegrees = new HashMap<>();
        boolean[] valid = new boolean[]{true};
        build(graph, inDegrees, words, valid);
        if(!valid[0]) return "";
        Queue<Character> queue = new LinkedList<>();
        for(char c : inDegrees.keySet()) {
            if(inDegrees.get(c) == 0) queue.offer(c);
        }
        StringBuilder res = new StringBuilder();
        while(!queue.isEmpty()) {
            char cur = queue.poll();
            res.append(cur);
            List<Character> edges = graph.get(cur);
            if(edges == null) continue;
            for(char edge : edges) {
                inDegrees.put(edge, inDegrees.get(edge) - 1);
                if(inDegrees.get(edge) == 0) {
                    queue.offer(edge);
                }
            }
        }
        return res.length() < inDegrees.size() ? "" : res.toString();

    }

    private void build(Map<Character, List<Character>> graph, Map<Character, Integer> inDegrees, 
        String[] words, boolean[] valid) {
            for(String word : words) {
                for(int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    graph.putIfAbsent(c, new ArrayList<>());
                    inDegrees.putIfAbsent(c, 0);
                }
            }

            for(int i = 0; i < words.length - 1; i++) {
                String word = words[i];
                String next = words[i + 1];
                if(word.length() > next.length() && word.startsWith(next)) valid[0] = false;
                for(int j = 0; j < Math.min(word.length(), word.length()); j++) {
                    char c1 = word.charAt(j);
                    char c2 = next.charAt(j);
                    if(c1 != c2) {
                        graph.get(c1).add(c2);
                        inDegrees.put(c2, inDegrees.get(c2) + 1);
                    }
                }

            }
    }
}

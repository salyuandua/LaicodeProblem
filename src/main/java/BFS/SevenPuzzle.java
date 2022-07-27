package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SevenPuzzle {
    public int numOfSteps(int[] values) {
        // Write your solution here
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < values.length; i++) {
            sb.append(String.valueOf(values[i]));
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visted = new HashSet<>();
        queue.offer(sb.toString());
        visted.add(sb.toString());
        int[][] neighbors = {{1, 4}, {0, 2, 5}, {1 , 3, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        return 0;
      }
}

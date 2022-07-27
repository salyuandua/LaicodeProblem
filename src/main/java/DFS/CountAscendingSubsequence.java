package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountAscendingSubsequence {
    public int numIncreasingSubsequences(int[] a) {
        // Write your solution here
        Set<List<Integer>> res = new HashSet<>();
        helper(a, 0, new ArrayList<>(), res);
        return res.size();
      }
    
    private void helper(int[] a, int layer, List<Integer> cur, Set<List<Integer>> res) {
        if(!cur.isEmpty()) {
            res.add(cur);
        }
        int prevNum = cur.isEmpty() ? Integer.MIN_VALUE : cur.get(cur.size() - 1);
        for(int i = layer; i < a.length; i++) {
            if(a[i] >= prevNum) {
                cur.add(a[i]);
                helper(a, i + 1, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
}

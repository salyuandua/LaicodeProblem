package DFS;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
    public List<List<Integer>> combinations(int target) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(2, target, cur, res);
        return res;
    }

    private void helper(int start, int target, List<Integer> cur, List<List<Integer>> res) {
        if(target == 1 && cur.size() > 1) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = start; i <= target; i++) {
            if(i % target == 0) {
                cur.add(i);
                helper(i, target/i, cur, res);
                cur.remove(cur.size() - 1);
            }  
        }
    }
}

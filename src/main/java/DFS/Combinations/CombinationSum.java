package DFS.Combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> curRes = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, 0, 0, curRes, res);
        return res;

    }

    private void helper(int[] candidates, int target, int layer, int sum, LinkedList<Integer> curRes, List<List<Integer>> res) {
        if(sum == target) {
            res.add(new ArrayList<>(curRes));
            return;
        }
        if(sum > target) {
            return;
        }
        for(int i = layer; i < candidates.length; i++) {
            sum += candidates[i];
            curRes.add(candidates[i]);
            helper(candidates, target, i, sum, curRes, res);
            sum-= candidates[i];
            curRes.removeLast();
        }
    }
}

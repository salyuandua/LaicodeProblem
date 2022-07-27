package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        // Write your code here
        Set<List<Integer>> res = new HashSet<>();
        helper(nums, 0, new ArrayList<>(), res);
        return new ArrayList<>(res);
    }

    private void helper(int[] nums, int layer, List<Integer> cur, Set<List<Integer>> res) {
        if(layer >= nums.length) return;
        if(cur.size() > 1) {
            res.add(new ArrayList<>(cur));
        }
        for(int i = layer; i < nums.length; i++) {
            if(cur.isEmpty() || cur.get(cur.size() - 1) <= nums[i]) {
                cur.add(nums[i]);
                helper(nums, layer + 1, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
}

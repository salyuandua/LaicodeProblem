package DFS.Combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> curRes = new LinkedList<>();
        Arrays.sort(num);
        helper(num, target, 0, 0, curRes, res);
        return res;
    }

    private void helper(int[] num, int target, int layer, int sum, LinkedList<Integer> curRes, List<List<Integer>> res) {
        if(target == sum) {
            res.add(new ArrayList<>(curRes));
            return;
        }
        if(sum > target) {
            return;
        }

        for(int i = layer; i < num.length; i++) {
            if(i > layer && num[i] == num[i - 1]) {
                continue;
            }
            sum += num[i];
            curRes.add(num[i]);
            helper(num, target, layer + 1, sum, curRes, res);
            sum -= num[i];
            curRes.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSumII cIi = new CombinationSumII();
        //System.out.println(cIi.combinationSum2(new int[]{}, target));
    }
}
//expected:<[[4, 14], [7, 11], [1, 6, 11], [1, 8, 9], [2, 5, 11], [2, 7, 9], [4, 5, 9], [4, 6, 8], [4, 7, 7], [5, 5, 8], [5, 6, 7], [1, 1, 2, 14], [1, 1, 5, 11], [1, 1, 7, 9], [1, 2, 4, 11], [1, 2, 6, 9], [1, 2, 7, 8], [1, 4, 5, 8], [1, 4, 6, 7], [1, 5, 5, 7], [2, 4, 5, 7], [2, 5, 5, 6], [1, 1, 2, 5, 9], [1, 1, 2, 6, 8], [1, 1, 2, 7, 7], [1, 1, 4, 5, 7], [1, 1, 5, 5, 6], [1, 2, 4, 5, 6], [1, 2, 5, 5, 5], [1, 1, 2, 4, 5, 5]]> 
//but was:<[[4, 14], [4, 14], [7, 11], [7, 11], [9, 9], [1, 6, 11], [1, 6, 11], [1, 6, 11], [1, 6, 11], [1, 8, 9], [1, 8, 9], [1, 8, 9], [1, 8, 9], [2, 2, 14], [2, 2, 14], [2, 2, 14], [2, 5, 11], [2, 5, 11], [2, 5, 11], [2, 5, 11], [2, 5, 11], [2, 5, 11], [2, 7, 9], [2, 7, 9], [2, 7, 9], [2, 7, 9], [2, 7, 9], [2, 7, 9], [2, 8, 8], [2, 8, 8], [2, 8, 8], [4, 5, 9], [4, 5, 9], [4, 5, 9], [4, 5, 9], [4, 5, 9], [4, 5, 9], [4, 6, 8], [4, 6, 8], [4, 6, 8], [4, 6, 8], [4, 6, 8], [4, 6, 8], [4, 7, 7], [4, 7, 7], [4, 7, 7], [5, 5, 8], [5, 5, 8], [5, 5, 8], [5, 6, 7], [5, 6, 7], [5, 6, 7], [5, 6, 7], [5, 6, 7], [5, 6, 7], [6, 6, 6], [1, 1, 2, 14], [1, 1, 5, 11], [1, 1, 5, 11], [1, 1, 7, 9], [1, 1, 7, 9], [1, 1, 8, 8], [1, 2, 4, 11], [1, 2, 4, 11], [1, 2, 4, 11], [1, 2, 4, 11], [1, 2, 4, 11], [1, 2, 4, 11], [1, 2, 4, 11], [1, 2, 4, 11], [1, 2, 6, 9], [1, 2, 6, 9], [1, 2, 6, 9], [1, 2, 6, 9], [1, 2, 6, 9], [1, 2, 6, 9], [1, 2, 6, 9], [1, 2, 6, 9], [1, 2, 7, 8], [1, 2, 7, 8], [1, 2, 7, 8], [1, 2, 7, 8], [1, 2, 7, 8], [1, 2, 7, 8], [1, 2, 7, 8], [1, 2, 7, 8], [1, 4, 4, 9], [1, 4, 4, 9], [1, 4, 4, 9], [1, 4, 4, 9], [1, 4, 4, 9], [1, 4, 4, 9], [1, 4, 5, 8], [1, 4, 5, 8], [1, 4, 5, 8], [1, 4, 5, 8], [1, 4, 5, 8], [1, 4, 5, 8], [1, 4, 5, 8], [1, 4, 5, 8], [1, 4, 5, 8], [1, 4, 5, 8], [1, 4, 5, 8], [1, 4, 5, 8], [1, 4, 6, 7], [1, 4, 6, 7], [1, 4, 6, 7], [1, 4, 6, 7], [1, 4, 6, 7], [1, 4, 6, 7], [1, 4, 6, 7], [1, 4, 6, 7], [1, 4, 6, 7], [1, 4, 6, 7], [1, 4, 6, 7], [1, 4, 6, 7], [1, 5, 5, 7], [1, 5, 5, 7], [1, 5, 5, 7], [1, 5, 5, 7], [1, 5, 5, 7], [1, 5, 5, 7], [1, 5, 6, 6], [1, 5, 6, 6], [1, 5, 6, 6], [1, 5, 6, 6], [1, 5, 6, 6], [1, 5, 6, 6], [2, 2, 5, 9], [2, 2, 5, 9], [2, 2, 5, 9], [2, 2, 5, 9], [2, 2, 5, 9], [2, 2, 5, 9], [2, 2, 6, 8], [2, 2, 6, 8], [2, 2, 6, 8], [2, 2, 6, 8], [2, 2, 6, 8], [2, 2, 6, 8], [2, 2, 7, 7], [2, 2, 7, 7], [2, 2, 7, 7], [2, 4, 4, 8], [2, 4, 4, 8], [2, 4, 4, 8], [2, 4, 4, 8], [2, 4, 4, 8], [2, 4, 4, 8], [2, 4, 4, 8], [2, 4, 4, 8], [2, 4, 4, 8], [2, 4, 5, 7], [2, 4, 5, 7], [2, 4, 5, 7], [2, 4, 5, 7], [2, 4, 5, 7], [2, 4, 5, 7], [2, 4, 5, 7], [2, 4, 5, 7], [2, 4, 5, 7], [2, 4, 5, 7], [2, 4, 5, 7], [2, 4, 5, 7], [2, 4, 5, 7], [2, 4, 5, 7], [2, 4, 5, 7], [2, 4, 5, 7], [2, 4, 5, 7], [2, 4, 5, 7], [2, 4, 6, 6], [2, 4, 6, 6], [2, 4, 6, 6], [2, 4, 6, 6], [2, 4, 6, 6], [2, 4, 6, 6], [2, 4, 6, 6], [2, 4, 6, 6], [2, 4, 6, 6], [2, 5, 5, 6], [2, 5, 5, 6], [2, 5, 5, 6], [2, 5, 5, 6], [2, 5, 5, 6], [2, 5, 5, 6], [2, 5, 5, 6], [2, 5, 5, 6], [2, 5, 5, 6], [4, 4, 4, 6], [4, 4, 4, 6], [4, 4, 4, 6], [4, 4, 4, 6], [4, 4, 5, 5], [4, 4, 5, 5], [4, 4, 5, 5], [4, 4, 5, 5], [4, 4, 5, 5], [4, 4, 5, 5], [1, 1, 2, 5, 9], [1, 1, 2, 5, 9], [1, 1, 2, 6, 8], [1, 1, 2, 6, 8], [1, 1, 2, 7, 7], [1, 1, 4, 4, 8], [1, 1, 4, 5, 7], [1, 1, 4, 5, 7], [1, 1, 4, 5, 7], [1, 1, 4, 5, 7], [1, 1, 4, 6, 6], [1, 1, 4, 6, 6], [1, 1, 5, 5, 6], [1, 1, 5, 5, 6], [1, 1, 5, 5, 6], [1, 2, 2, 4, 9], [1, 2, 2, 4, 9], [1, 2, 2, 5, 8], [1, 2, 2, 5, 8], [1, 2, 2, 5, 8], [1, 2, 2, 5, 8], [1, 2, 2, 6, 7], [1, 2, 2, 6, 7], [1, 2, 2, 6, 7], [1, 2, 2, 6, 7], [1, 2, 4, 4, 7], [1, 2, 4, 4, 7], [1, 2, 4, 4, 7], [1, 2, 4, 4, 7], [1, 2, 4, 5, 6], [1, 2, 4, 5, 6], [1, 2, 4, 5, 6], [1, 2, 4, 5, 6], [1, 2, 4, 5, 6], [1, 2, 4, 5, 6], [1, 2, 4, 5, 6], [1, 2, 4, 5, 6], [1, 2, 4, 5, 6], [1, 2, 4, 5, 6], [1, 2, 4, 5, 6], [1, 2, 4, 5, 6], [1, 2, 4, 5, 6], [1, 2, 4, 5, 6], [1, 2, 4, 5, 6], [1, 2, 4, 5, 6], [1, 2, 5, 5, 5], [1, 2, 5, 5, 5], [1, 2, 5, 5, 5], [1, 2, 5, 5, 5], [1, 4, 4, 4, 5], [1, 4, 4, 4, 5], [2, 2, 2, 4, 8], [2, 2, 2, 5, 7], [2, 2, 2, 5, 7], [2, 2, 2, 6, 6], [2, 2, 4, 4, 6], [2, 2, 4, 4, 6], [2, 2, 4, 4, 6], [2, 2, 4, 5, 5], [2, 2, 4, 5, 5], [2, 2, 4, 5, 5], [2, 2, 4, 5, 5], [2, 2, 4, 5, 5], [2, 2, 4, 5, 5], [1, 1, 2, 4, 5, 5]]
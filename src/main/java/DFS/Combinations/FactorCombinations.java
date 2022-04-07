package DFS.Combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactorCombinations {
    public List<List<Integer>> combinations(int target) {
        // Write your solution here
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= target/2; i++) {
            if (target % i == 0) {
                factors.add(i);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        helper(factors, 0, target, new int[factors.size()], res);
        return res;
    }

    private void helper(List<Integer> factors, int layer, int rem, int[] cur,
                        List<List<Integer>> ans) {
        if (layer == factors.size()) {
            if (rem <= 1) {
                System.out.println(cur);
               // ans.add(Arrays.asList(cur));
            }
            return;
        }

        for (int i = 0; Math.pow(factors.get(layer), i) < rem; i++) {
            cur[layer] = i;
            helper(factors, layer + 1, (int) (rem / Math.pow(factors.get(layer), i)), cur, ans);
        }
    }

    public static void main(String[] args) {
        FactorCombinations factorCombinations = new FactorCombinations();
        factorCombinations.combinations(24);
    }

}

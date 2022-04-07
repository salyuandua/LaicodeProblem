package DFS.Combinations;

import java.util.ArrayList;
import java.util.List;

public class CombinationsOfCoins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> res = new ArrayList<>();
        int[] cur = new int[coins.length];
        helper(coins, cur, 0, target, res);
        return res;
    }

    private void helper(int[] coins, int[] cur, int layer, int rem, List<List<Integer>> res) {
        if (layer == coins.length) {
            if (rem == 0) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < cur.length; i++) {
                    list.add(cur[i]);
                }
                res.add(list);
            }
            return;
        }

        for (int i = 0; i * coins[layer] <= rem; i++) {
            cur[layer] = i;
            helper(coins, cur, layer + 1, rem - i * coins[layer], res);
        }
    }
}

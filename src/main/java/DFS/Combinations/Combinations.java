package DFS.Combinations;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    private void helper(int n, int k, int layer, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == k) {
            res.add(cur);
            return;
        }
        for (int i = layer; i <= n; i++) {
            cur.add(i);
            helper(n, k, layer + 1, new ArrayList<>(cur), res);
            cur.remove(cur.size() - 1);
        }
    }
}

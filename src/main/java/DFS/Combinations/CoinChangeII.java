package DFS.Combinations;

public class CoinChangeII {
    public int coinChange(int amount, int[] coins) {
        // Write your solution here
        int[] res = new int[1];
        helper(coins, 0, amount, new int[coins.length], res);
        return res[0];
    }

    private void helper(int[] coins, int layer, int rem, int[] cur, int[] res) {
        if (layer == coins.length) {
            if (rem == 0){
                res[0] ++;
            }
            return;
        }
        for (int i = 0; i * coins[layer] <= rem; i++) {
            cur[layer] = i;
            helper(coins, layer + 1, rem - i * coins[layer], cur, res);
        }
    }
}

package DP;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // Write your solution here
        int[] m = new int[amount + 1];
        Arrays.fill(m, amount + 1);
        m[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                m[i] = Math.min(m[i], m[i - coin] + 1);

            }
        }
        return m[amount] == amount + 1 ? -1 : m[amount];
    }
}

import java.util.*;
// 377. Combination Sum IV: https://leetcode.com/problems/combination-sum-iv/

class Memoization {
    // Time - O(Amount * Coins), Space - O(Amount): 1D DP + RCS
    public int memo(int amount, int[] coins, int[] dp) {
        if (amount < 0)
            return 0;
        if (amount == 0)
            return 1;
        if (dp[amount] != -1)
            return dp[amount];

        int perm = 0;
        for (int i = 0; i < coins.length; i++) {
            perm += memo(amount - coins[i], coins, dp);
        }

        return dp[amount] = perm;
    }

    public int combinationSum4(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        return memo(amount, coins, dp);
    }
}

class Tabulation {
    // Time - O(Amount * Coins), Space - O(Amount): 1D DP + RCS
    public int combinationSum4(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // Ways to reach dest when src = dest is 1. (Empty String)

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}
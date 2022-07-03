// 518. Coin Change 2: https://leetcode.com/problems/coin-change-2/

class Memoization {
    // Time - O(Amount * Coins), Space - O(Amount * Coins): 2D DP + RCS
    public int memo(int amount, int lastCoin, int[] coins, int[][] dp) {
        if (amount < 0)
            return 0;
        if (amount == 0)
            return 1;
        if (dp[amount][lastCoin] != -1)
            return dp[amount][lastCoin];

        int perm = 0;
        for (int coin = lastCoin; coin < coins.length; coin++) {
            perm += memo(amount - coins[coin], coin, coins, dp);
        }

        return dp[amount][lastCoin] = perm;
    }

    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j <= coins.length; j++) {
                dp[i][j] = -1;
            }
        }

        return memo(amount, 0, coins, dp);
    }
}

class Tabulation {
    // Time - O(Amount * Coins), Space - O(Amount)
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // Ways to reach dest when src = dest is 1. (Empty String)

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
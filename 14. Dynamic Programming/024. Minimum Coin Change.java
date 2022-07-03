import java.util.*;

// 322. Coin Change: https://leetcode.com/problems/coin-change/

// Memoization - Approach 1
// Time - O(Amount * Coins), Space - O(Amount) for DP Table 
// Recursion Call Stack -> O(Amount) Height, O(Coins) Calls/Breadth
class Solution1 {
    public int memo(int amount, int[] coins, int[] dp) {
        if (amount == 0)
            return 0;
        if (dp[amount] != -1)
            return dp[amount];

        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                minCoins = Math.min(minCoins, memo(amount - coins[i], coins, dp));
            }
        }

        if (minCoins < Integer.MAX_VALUE)
            minCoins += 1;
        return dp[amount] = minCoins;
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        int ans = memo(amount, coins, dp);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}

// Memoization - Approach 2
// Time - O(Amount * Coins), Space - O(Amount * Coins) for DP table
// Recursion Call Stack -> O(Coins) Height, O(Amount) Calls/Breadth
class Solution2 {
    public int memo(int amount, int idx, int[] coins, int[][] dp) {
        if (amount == 0)
            return 0;
        if (idx == coins.length)
            return Integer.MAX_VALUE;
        if (dp[amount][idx] != -1)
            return dp[amount][idx];

        int minCoins = Integer.MAX_VALUE;
        for (int coin = 0; amount >= coins[idx] * coin; coin++) {
            int ans = memo(amount - coins[idx] * coin, idx + 1, coins, dp);
            if (ans < Integer.MAX_VALUE)
                ans += coin;
            minCoins = Math.min(minCoins, ans);
        }

        return dp[amount][idx] = minCoins;
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[amount + 1][coins.length];
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = memo(amount, 0, coins, dp);
        if (ans == Integer.MAX_VALUE)
            return -1;
        return ans;
    }
}

// Memoization - Approach 3
// Time - O(Amount * Coins), Space - O(Amount * Coins) for DP table
// Recursion Call Stack -> O(Amount) Height, Exactly 2 Calls/Breadth
class Solution3 {
    public int memo(int amount, int idx, int[] coins, int[][] dp) {
        if (amount < 0)
            return Integer.MAX_VALUE;
        if (amount == 0)
            return 0;
        if (idx == coins.length)
            return Integer.MAX_VALUE;
        if (dp[amount][idx] != -1)
            return dp[amount][idx];

        int yes = memo(amount - coins[idx], idx, coins, dp);
        if (yes != Integer.MAX_VALUE)
            yes += 1;

        int no = memo(amount, idx + 1, coins, dp);

        return dp[amount][idx] = Math.min(yes, no);
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[amount + 1][coins.length];
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = memo(amount, 0, coins, dp);
        if (ans == Integer.MAX_VALUE)
            return -1;
        return ans;
    }
}

// Tabulation
// Time - O(Amount * Coins), Space - O(Amount) 1D DP Array
class Solution4 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }
}

// Space Optimization for Above Tabulation is Not Possible, because
// we have already reduced 2D to 1D. It cannot be Constant.
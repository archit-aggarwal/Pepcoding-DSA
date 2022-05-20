// Leetcode 188. https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

// Recursion - Memoization
class Greedy {
    // Time - O(N * 2 * K), Space - O(N * 2 * K)
    public int memo(int idx, int state, int count, int[] prices, int[][][] dp) {
        if (idx == prices.length || count == 0)
            return 0;
        if (dp[idx][state][count] != -1)
            return dp[idx][state][count];

        if (state == 1) // BUY
            return dp[idx][state][count] = Math.max(memo(idx + 1, 1, count, prices, dp),
                    memo(idx + 1, 0, count, prices, dp) - prices[idx]);

        // SELL
        return dp[idx][state][count] = Math.max(memo(idx + 1, 0, count, prices, dp),
                memo(idx + 1, 1, count - 1, prices, dp) + prices[idx]);
    }

    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][k + 1];
        for (int i = 0; i <= prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][0][j] = dp[i][1][j] = -1;
            }
        }

        return memo(0, 1, k, prices, dp);
    }
}

// Tabulation
class Tabulation {
    // Time - O(N * N * K), Space - O(N * K)
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0)
            return 0;

        int[][] dp = new int[k + 1][prices.length];

        for (int t = 1; t <= k; t++) {
            for (int i = 0; i < prices.length; i++) {
                dp[t][i] = (i - 1 >= 0) ? dp[t][i - 1] : 0;

                for (int j = i - 1; j >= 0; j--) {
                    // Last Transaction is between j and i, and remaining (t - 1)
                    // transactions are before the jth day (Non-overlapping).

                    dp[t][i] = Math.max(dp[t][i], (prices[i] - prices[j]) + dp[t - 1][j]);
                }
            }
        }

        return dp[k][prices.length - 1];
    }
}
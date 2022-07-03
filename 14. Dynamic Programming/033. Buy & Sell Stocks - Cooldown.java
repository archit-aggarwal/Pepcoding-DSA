// Leetcode 309. https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

// Recursion - Memoization
class Memoization {
    // Time - O(N * 2), Space - O(N * 2) DP Table + O(N) RCS
    public int memo(int idx, int state, int[] prices, int[][] dp) {
        if (idx == prices.length)
            return 0;
        if (dp[idx][state] != -1)
            return dp[idx][state];

        if (state == 1) // BUY
            return dp[idx][state] = Math.max(memo(idx + 1, 1, prices, dp),
                    memo(idx + 1, 0, prices, dp) - prices[idx]);

        // SELL
        return dp[idx][state] = Math.max(memo(idx + 1, 0, prices, dp),
                memo(idx + 2, 1, prices, dp) + prices[idx]);
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 2][2];
        for (int i = 0; i <= prices.length; i++) {
            dp[i][0] = dp[i][1] = -1;
        }

        return memo(0, 1, prices, dp);
    }
}

// Tabulation Without Space Optimization
class Tabulation {
    // Time - O(N), Space - O(N * 2)
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;

        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];

        buy[0] = -prices[0];
        sell[0] = 0;
        buy[1] = Math.max(-prices[0], -prices[1]); // Either buy 0th stock or 1st stock
        sell[1] = Math.max(0, prices[1] - prices[0]); // Either do nothing or Buy 0 Sell 1

        for (int i = 2; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }

        return sell[prices.length - 1];
    }
}

// Tabulation With Space Optimization
class SpaceOptimization {
    // Time - O(N), Space - O(1), Constant (4 Pointers)
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;

        int buy0 = -prices[0];
        int sell0 = 0;
        int buy1 = Math.max(-prices[0], -prices[1]); // Either buy 0th stock or 1st stock
        int sell1 = Math.max(0, prices[1] - prices[0]); // Either do nothing or Buy 0 Sell 1

        for (int i = 2; i < prices.length; i++) {
            int newbuy = Math.max(buy1, sell0 - prices[i]);
            int newsell = Math.max(sell1, buy1 + prices[i]);

            buy0 = buy1;
            sell0 = sell1;
            buy1 = newbuy;
            sell1 = newsell;
        }

        return sell1;
    }
}
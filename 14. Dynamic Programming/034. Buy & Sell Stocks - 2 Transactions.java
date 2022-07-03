// Leetcode 123. https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

// Recursion - Memoization
class DP {
    // Time - O(N), Space - O(N * 2)
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

    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][3];
        for (int i = 0; i <= prices.length; i++) {
            for (int j = 1; j <= 2; j++) {
                dp[i][0][j] = dp[i][1][j] = -1;
            }
        }

        return memo(0, 1, 2, prices, dp);
    }
}

// Prefix & Suffix Approach
class Greedy {
    // Time - O(N * 2) = O(N), Space - O(N * 2)
    public int maxProfit(int[] prices) {
        int[] selling = new int[prices.length];

        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);

            if (i - 1 >= 0)
                selling[i] = Math.max(selling[i - 1], prices[i] - min);
            else
                selling[i] = prices[i] - min;
        }

        int[] buying = new int[prices.length];

        int max = prices[prices.length - 1];
        for (int i = prices.length - 1; i >= 0; i--) {
            max = Math.max(prices[i], max);

            if (i != prices.length - 1)
                buying[i] = Math.max(buying[i + 1], max - prices[i]);

            else
                buying[i] = max - prices[i];
        }

        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            ans = Math.max(ans, buying[i] + selling[i]);
        }
        return ans;
    }
}

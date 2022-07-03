import java.util.*;
// 122: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

class Greedy1 {
    // Greedy Approach with Extra Space
    // Time - O(N), Space - O(N)
    public int maxProfit(int[] prices) {
        Stack<Integer> stk = new Stack<>();
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (stk.size() > 0 && stk.peek() < prices[i]) {
                profit += prices[i] - stk.pop();
            }

            stk.push(prices[i]);
        }

        return profit;
    }
}

class Greedy2 {
    // Greedy Approach without Extra Space
    // Time - O(N), Space - O(1)
    public int maxProfit(int[] prices) {
        int buying = prices[0];
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (buying < prices[i]) {
                profit += prices[i] - buying;
            }

            buying = prices[i];
        }

        return profit;
    }
}

class Greedy3 {
    // Time - O(N), Space - O(1)

    public int maxProfit(int[] prices) {
        int valley = 0, profit = 0;
        while (valley < prices.length) {
            int peak = valley;
            while (peak + 1 < prices.length && prices[peak + 1] >= prices[peak]) {
                peak++;
            }

            profit = profit + (prices[peak] - prices[valley]);
            valley = peak + 1;
        }
        return profit;
    }
}

class DP1 {
    // Memoization (Recursion) - O(N * 2) Time, O(N * 2) Space
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
                memo(idx + 1, 1, prices, dp) + prices[idx]);
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        for (int i = 0; i <= prices.length; i++) {
            dp[i][0] = dp[i][1] = -1;
        }

        return memo(0, 1, prices, dp);
    }
}

class DP2 {
    // Tabulation with Exta Space
    // Time - O(N), Space - O(2 * N) = O(N)
    public int maxProfit(int[] prices) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];

        buy[0] = -prices[0];
        sell[0] = 0;

        for (int i = 1; i < prices.length; i++) {

            // Treat today as Buying Day
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);

            // Treat today as Selling Day
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }

        return sell[prices.length - 1];
    }
}

class DP3 {
    // Tabulation without Exta Space - Space Optimization
    // Time - O(N), Space - O(1)
    public int maxProfit(int[] prices) {
        int buy = -prices[0];
        int sell = 0;

        for (int i = 1; i < prices.length; i++) {

            // Treat today as Buying Day
            int newBuy = Math.max(buy, sell - prices[i]);

            // Treat today as Selling Day
            int newSell = Math.max(sell, buy + prices[i]);

            buy = newBuy;
            sell = newSell;
        }

        return sell;
    }
}

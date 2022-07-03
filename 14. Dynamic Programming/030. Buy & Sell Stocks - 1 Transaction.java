// 121: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Greedy1 {
    // Greedy Approach 1: Take Each Day as Potential Buying Day
    // O(N) Time, O(1) Space

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int selling = prices[n - 1], profit = 0;

        for (int i = n - 1; i >= 0; i--) {
            selling = Math.max(selling, prices[i]);

            int buying = prices[i]; // Today - Potential Buying Day

            profit = Math.max(profit, selling - buying);
        }

        return profit;
    }
}

class Greedy2 {
    // Greedy Approach 2: Take Each Day as Potential Selling Day
    // Time - O(N), Space - O(1)

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int buying = prices[0], profit = 0;

        for (int i = 0; i < n; i++) {
            buying = Math.min(buying, prices[i]);

            int selling = prices[i]; // Today - Potential Selling Day

            profit = Math.max(profit, selling - buying);
        }

        return profit;
    }
}
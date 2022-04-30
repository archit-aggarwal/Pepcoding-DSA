// 515 Lintcode: https://www.lintcode.com/problem/515/

// Approach 1: Memoization -> O(N * 3) = O(N) Time, O(N * 3) Space 
// Run Time Error due to Stack Overflow for N > 10^5
class Memoization {
    public int helper(int[][] costs, int idx, int prev, int[][] dp) {
        if (idx == costs.length)
            return 0;
        if (prev >= 0 && dp[idx][prev] != -1)
            return dp[idx][prev];

        int ansR = (prev == 0) ? Integer.MAX_VALUE
                : helper(costs, idx + 1, 0, dp) + costs[idx][0];
        int ansB = (prev == 1) ? Integer.MAX_VALUE
                : helper(costs, idx + 1, 1, dp) + costs[idx][1];
        int ansG = (prev == 2) ? Integer.MAX_VALUE
                : helper(costs, idx + 1, 2, dp) + costs[idx][2];

        if (prev == -1)
            return Math.min(ansR, Math.min(ansB, ansG));
        return dp[idx][prev] = Math.min(ansR, Math.min(ansB, ansG));
    }

    public int minCost(int[][] costs) {
        if (costs.length == 0)
            return 0;

        int[][] dp = new int[costs.length + 1][3];
        for (int i = 0; i <= costs.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
            dp[i][2] = -1;
        }

        return helper(costs, 0, -1, dp);
    }
}

// Tabulation -> O(N * 3) = O(N) Time, O(N * 3) = O(N) Space
class Tabulation {
    public int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0)
            return 0;

        int[][] dp = new int[n + 1][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < n; i++) {
            // (0 - i houses) -> ith House Red
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);

            // (0 - i houses) -> ith House Blue
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);

            // (0 - i houses) -> ith House Green
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}

// Space Optimization -> O(N * 3) = O(N) Time, O(1) Constant Extra Space
class SpaceOptimization {
    public int minCost(int[][] costs) {
        int n = costs.length;
        if (costs.length == 0)
            return 0;

        int prev0 = costs[0][0];
        int prev1 = costs[0][1];
        int prev2 = costs[0][2];

        for (int i = 1; i < n; i++) {
            // (0 - i houses) -> ith House Red
            int curr0 = costs[i][0] + Math.min(prev1, prev2);

            // (0 - i houses) -> ith House Blue
            int curr1 = costs[i][1] + Math.min(prev0, prev2);

            // (0 - i houses) -> ith House Green
            int curr2 = costs[i][2] + Math.min(prev0, prev1);

            prev0 = curr0;
            prev1 = curr1;
            prev2 = curr2;
        }

        return Math.min(prev0, Math.min(prev1, prev2));
    }
}
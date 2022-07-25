// GfG - https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1/

class Memoization {
    // Time - O(Capacity * Items), Space - O(Capacity * Items) 2D DP
    static int memo(int cap, int item, int[] wt, int[] cost, int[][] dp) {
        if (item == cost.length)
            return 0; // No Item No Profit
        if (dp[cap][item] != -1)
            return dp[cap][item];

        int yes = (cap >= wt[item]) ? memo(cap - wt[item], item + 1, wt, cost, dp) + cost[item] : -1;
        int no = memo(cap, item + 1, wt, cost, dp);

        return dp[cap][item] = Math.max(yes, no);
    }

    static int knapSack(int cap, int wt[], int cost[], int n) {
        int[][] dp = new int[cap + 1][cost.length];
        for (int i = 0; i <= cap; i++) {
            for (int j = 0; j < cost.length; j++) {
                dp[i][j] = -1;
            }
        }

        return memo(cap, 0, wt, cost, dp);
    }
}

class Tabulation {
    // Time - O(Capacity * Items), Space - O(Capacity * Items) 2d DP
    static int knapSack(int caps, int wt[], int cost[], int n) {
        int[][] dp = new int[caps + 1][cost.length + 1];

        for (int item = 1; item <= cost.length; item++) {
            for (int cap = 1; cap <= caps; cap++) {

                int no = dp[cap][item - 1];
                int yes = (cap >= wt[item - 1])
                        ? cost[item - 1] + dp[cap - wt[item - 1]][item - 1]
                        : -1;

                dp[cap][item] = Math.max(yes, no);
            }
        }

        return dp[caps][cost.length];
    }
}

class SpaceOptimization {
    // Time - O(Capacity * Items), Space - O(Capacity) 1D DP
    static int knapSack(int caps, int wt[], int cost[], int n) {
        int[] dp = new int[caps + 1];

        for (int item = 1; item <= cost.length; item++) {
            int[] newDp = new int[caps + 1];

            for (int cap = 1; cap <= caps; cap++) {

                int no = dp[cap];
                int yes = (cap >= wt[item - 1])
                        ? cost[item - 1] + dp[cap - wt[item - 1]]
                        : -1;

                newDp[cap] = Math.max(yes, no);
            }

            dp = newDp;
        }

        return dp[caps];
    }
}
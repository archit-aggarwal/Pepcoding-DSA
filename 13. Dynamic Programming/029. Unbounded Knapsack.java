// GfG: https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1

class App1 {
    // Memoization Approach 1: Time - O(Cap * N * Cap), Space - O(Cap * N)
    // Since Time is Cubic, It is Giving Time Limit Exceeded (TLE)
    static int memo(int index, int cap, int cost[], int wt[], int N, int[][] dp) {
        if (index == N || cap == 0)
            return 0;
        if (dp[index][cap] != -1)
            return dp[index][cap];

        int ans = -1;
        for (int freq = 0; cap >= freq * wt[index]; freq++) {
            int temp = memo(index + 1, cap - freq * wt[index], cost, wt, N, dp)
                    + freq * cost[index];
            ans = Math.max(ans, temp);
        }
        return dp[index][cap] = ans;
    }

    static int knapSack(int N, int cap, int cost[], int wt[]) {
        int[][] dp = new int[N + 1][cap + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= cap; j++) {
                dp[i][j] = -1;
            }
        }

        return memo(0, cap, cost, wt, N, dp);
    }
}

class App2 {
    // Memoization Approach 2: Time - O(Cap * N), Space - O(Cap * N)
    // Now, It is Quadratic, hence giving Accepted
    static int memo(int index, int cap, int cost[], int wt[], int N, int[][] dp) {
        if (index == N || cap == 0)
            return 0;
        if (dp[index][cap] != -1)
            return dp[index][cap];

        int no = memo(index + 1, cap, cost, wt, N, dp);
        int yes = (cap >= wt[index])
                ? cost[index] + memo(index, cap - wt[index], cost, wt, N, dp)
                : -1;

        return dp[index][cap] = Math.max(yes, no);
    }

    static int knapSack(int N, int cap, int cost[], int wt[]) {
        int[][] dp = new int[N + 1][cap + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= cap; j++) {
                dp[i][j] = -1;
            }
        }

        return memo(0, cap, cost, wt, N, dp);
    }
}

class App3 {
    // Tabulation 2D DP: Time - O(Cap * N), Space - O(Cap * N)
    static int knapSack(int N, int caps, int cost[], int wt[]) {
        int[][] dp = new int[N + 1][caps + 1];

        for (int item = 1; item <= N; item++) {
            for (int cap = 1; cap <= caps; cap++) {
                int no = dp[item - 1][cap];
                int yes = (cap >= wt[item - 1])
                        ? dp[item][cap - wt[item - 1]] + cost[item - 1]
                        : -1;

                dp[item][cap] = Math.max(no, yes);
            }
        }

        return dp[N][caps];
    }
}

class App4 {
    // Tabulation 1D DP: Time - O(Cap * N), Space - O(Cap)
    static int knapSack(int N, int caps, int cost[], int wt[]) {
        int[] dp = new int[caps + 1];

        for (int item = 1; item <= N; item++) {
            for (int cap = 1; cap <= caps; cap++) {
                int no = dp[cap];
                int yes = (cap >= wt[item - 1])
                        ? dp[cap - wt[item - 1]] + cost[item - 1]
                        : -1;

                dp[cap] = Math.max(no, yes);
            }
        }

        return dp[caps];
    }
}
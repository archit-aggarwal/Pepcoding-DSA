import java.util.*;

// GfG Link: https://practice.geeksforgeeks.org/problems/count-the-number-of-ways-to-tile-the-floor-of-size-n-x-m-using-1-x-m-size-tiles0509/1

class Solution {
    int mod = 1000000007;

    // Memoization -> O(n) Time, O(n) Space
    public int memo(int n, int m, int[] dp) {
        if (n < m)
            return 1;
        if (n == m)
            return 2;
        if (dp[n] != -1)
            return dp[n];

        int ans1 = memo(n - 1, m, dp);
        int ans2 = memo(n - m, m, dp);
        return dp[n] = (ans1 + ans2) % mod;
    }

    // Tabulation (with Sliding Window Space Optimization)
    // O(N) Time, O(M) Space
    // Note: Space cannot be Constant or O(1),
    // i.e. Two Pointers Technique is not possible
    public int spaceOpt(int n, int m) {
        if (n < m)
            return 1;
        if (n == m)
            return 2;

        Deque<Integer> dp = new ArrayDeque<>();
        for (int i = 1; i < m; i++) {
            dp.add(1); // DP[N < M]
        }
        dp.add(2); // DP[N == M]

        for (int i = m + 1; i <= n; i++) {
            int ans = (dp.getFirst() + dp.getLast()) % mod;
            dp.removeFirst();
            dp.addLast(ans);
        }

        return dp.getLast();
    }

    public int countWays(int n, int m) {
        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);
        // return memo(n, m, dp);

        return spaceOpt(n, m);
    }
}

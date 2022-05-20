// Leetcode 62: https://leetcode.com/problems/unique-paths/

// Memoization - O(N * M) Time, O(N * M) Space
class Solution {
    public int memo(int sr, int sc, int dr, int dc, int[][] dp) {
        if (sr > dr || sc > dc)
            return 0;
        if (sr == dr && sc == dc)
            return 1;
        if (dp[sr][sc] != -1)
            return dp[sr][sc];

        return dp[sr][sc] = (memo(sr + 1, sc, dr, dc, dp)
                + memo(sr, sc + 1, dr, dc, dp));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                dp[i][j] = -1;

        return memo(0, 0, m - 1, n - 1, dp);
    }
}
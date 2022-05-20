// Leetcode 63: https://leetcode.com/problems/unique-paths-ii/

class Solution {
    // Memoization - O(N * M) Time, O(N * M) Space
    public int memo(int sr, int sc, int dr, int dc, int[][] grid, int[][] dp) {
        if (sr > dr || sc > dc)
            return 0;
        if (grid[sr][sc] == 1)
            return 0;
        if (sr == dr && sc == dc)
            return 1;
        if (dp[sr][sc] != -1)
            return dp[sr][sc];

        return dp[sr][sc] = (memo(sr + 1, sc, dr, dc, grid, dp)
                + memo(sr, sc + 1, dr, dc, grid, dp));
    }

    public int uniquePathsWithObstacles(int[][] grid) {
        // Source is blocked
        if (grid[0][0] == 1)
            return 0;

        int m = grid.length, n = grid[0].length;
        // Destination is blocked
        if (grid[m - 1][n - 1] == 1)
            return 0;

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                dp[i][j] = -1;

        return memo(0, 0, m - 1, n - 1, grid, dp);
    }
}
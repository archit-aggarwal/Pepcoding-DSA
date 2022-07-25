// Leetcode 931 : https://leetcode.com/problems/minimum-falling-path-sum/

// Memoization: Time - O(N * M), Space - O(N * M)
class Solution {
    public int memo(int row, int col, int[][] grid, int[][] dp) {
        if (col < 0 || col >= grid[0].length) {
            // Out of Matrix: Negative Base Case
            return Integer.MAX_VALUE;
        }

        if (row == grid.length - 1) {
            // Entire last row is the destination
            return grid[row][col];
        }

        if (dp[row][col] != -1)
            return dp[row][col];

        int leftDown = memo(row + 1, col - 1, grid, dp);
        int down = memo(row + 1, col, grid, dp);
        int rightDown = memo(row + 1, col + 1, grid, dp);

        return dp[row][col] = Math.min(down, Math.min(leftDown, rightDown)) + grid[row][col];
    }

    public int minFallingPathSum(int[][] grid) {
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        int min = Integer.MAX_VALUE;

        // Call for Each Element of the first row as the source node
        // DP table is going to be filled only once: Overall Time: O(N * M)
        for (int src = 0; src < grid[0].length; src++) {
            int path = memo(0, src, grid, dp);
            min = Math.min(min, path);
        }

        return min;
    }
}
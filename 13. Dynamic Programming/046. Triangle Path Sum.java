// Leetcode 120: https://leetcode.com/problems/triangle/

import java.util.*;

class Solution {
    // Time - O(N * M) Time, O(N * M) Space
    public int helper(List<List<Integer>> triangle, int row, int col, Integer[][] dp) {
        if (row == triangle.size() - 1) {
            // Entire Last Row is the Destination
            return triangle.get(row).get(col);
        }

        if (dp[row][col] != null)
            return dp[row][col];

        int down = helper(triangle, row + 1, col, dp);
        int rightdown = helper(triangle, row + 1, col + 1, dp);

        return dp[row][col] = (triangle.get(row).get(col) + Math.min(down, rightdown));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n + 1][n + 1];
        return helper(triangle, 0, 0, dp);
    }
}
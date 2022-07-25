// GfG: https://practice.geeksforgeeks.org/problems/word-wrap1646/1
// Time - O(N ^ 2), Space - O(N * K) 2D DP

class Solution {
    public int helper(int idx, int rem, int len, int[] nums, int[][] dp) {
        if (idx == nums.length)
            return 0;
        if (dp[idx][rem] != -1)
            return dp[idx][rem];

        int newRem = (rem == len) ? rem - nums[idx] : rem - nums[idx] - 1;
        int sameLine = (nums[idx] < rem) ? helper(idx + 1, newRem, len, nums, dp)
                : Integer.MAX_VALUE;

        int diffLine = (rem * rem) + helper(idx + 1, len - nums[idx], len, nums, dp);
        return dp[idx][rem] = Math.min(sameLine, diffLine);
    }

    public int solveWordWrap(int[] nums, int k) {
        int[][] dp = new int[nums.length + 1][k + 1];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;

        return helper(0, k, k, nums, dp);
    }
}
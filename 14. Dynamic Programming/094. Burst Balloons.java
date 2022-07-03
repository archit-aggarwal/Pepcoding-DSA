// LC 312: https://leetcode.com/problems/burst-balloons/
// Time: O(N ^ 3), Space - O(N ^ 2) 2D DP

class Solution {
    public int helper(int l, int r, int[] nums, int[][] dp) {
        if (l > r)
            return 0; // No Balloons -> 0 Score
        if (dp[l][r] != -1)
            return dp[l][r];

        int maxCost = 0;
        for (int k = l; k <= r; k++) {
            int left = helper(l, k - 1, nums, dp);
            int right = helper(k + 1, r, nums, dp);
            int cost = ((l == 0) ? 1 : nums[l - 1]) * nums[k] * ((r == nums.length - 1) ? 1 : nums[r + 1]);
            maxCost = Math.max(maxCost, left + cost + right);
        }

        return dp[l][r] = maxCost;
    }

    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for (int i = 0; i <= nums.length; i++)
            for (int j = 0; j <= nums.length; j++)
                dp[i][j] = -1;

        return helper(0, nums.length - 1, nums, dp);
    }
}
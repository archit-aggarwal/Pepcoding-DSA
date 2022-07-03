// 213. House Robber - II: https://leetcode.com/problems/house-robber-ii/

class Solution {
    // Memoization
    public int memo(int[] nums, int idx, int n, int prev, int[][] dp) {
        if (idx == n + 1)
            return 0;
        if (dp[idx][prev] != -1)
            return dp[idx][prev];

        int yes = (prev == 0) ? (memo(nums, idx + 1, n, 1, dp) + nums[idx]) : 0;
        int no = memo(nums, idx + 1, n, 0, dp);

        return dp[idx][prev] = Math.max(yes, no);
    }

    public int rob(int[] nums, int start, int end) {
        int n = nums.length;

        int[][] dp = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        return memo(nums, start, end, 0, dp);
    }

    // Time - O(2 * (2 * N)) = O(N), Space - O(2 * (2 * N)) = O(N)
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
}
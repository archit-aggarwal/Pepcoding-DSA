// 198. House Robber - I : https://leetcode.com/problems/house-robber/

class Solution {
    // Memoization -> Time - O(N * 2) = O(N), Space - O(N * 2) = O(N)

    public int memo(int[] nums, int idx, int prev, int[][] dp) {
        if (idx == nums.length)
            return 0;
        if (dp[idx][prev] != -1)
            return dp[idx][prev];

        int yes = (prev == 0) ? (memo(nums, idx + 1, 1, dp) + nums[idx]) : 0;
        int no = memo(nums, idx + 1, 0, dp);

        return dp[idx][prev] = Math.max(yes, no);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        return memo(nums, 0, 0, dp);
    }
}
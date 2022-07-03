// Leetcode 416: https://leetcode.com/problems/partition-equal-subset-sum/

// Time - O(N * Target), Space - O(Target) DP Table
class Solution {
    public boolean checkTargetSumSubset(int[] arr, int target) {
        int n = arr.length;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Empty Subset to form 0 Target

        for (int i = 1; i <= n; i++) {
            boolean[] newdp = new boolean[target + 1];

            for (int j = 0; j <= target; j++) {
                boolean no = dp[j]; // No Call
                boolean yes = (j >= arr[i - 1]) ? dp[j - arr[i - 1]] : false;

                newdp[j] = no || yes;
            }

            dp = newdp;
        }

        return dp[target];
    }

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int val : nums)
            total += val;

        if (total % 2 == 1)
            return false; // No Division Possible
        return checkTargetSumSubset(nums, total / 2);
    }
}
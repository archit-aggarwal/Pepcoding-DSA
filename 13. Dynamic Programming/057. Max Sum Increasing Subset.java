// GfG: https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1

class Solution {
    // Time - O(N * N), Space - O(N) 1D DP
    public int maxSumIS(int nums[], int n) {
        int[] dp = new int[n];
        int maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i]; // If Prev Does not Exist, then current element can have yes

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                }
            }

            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}
// Leetcode 494: https://leetcode.com/problems/target-sum/

// Time - O(N * Target), Space - O(Target)
class Solution {
    public int countTargetSumSubset(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[target + 1];
        dp[0] = 1; // Empty Subset to form 0 Target

        for (int i = 1; i <= n; i++) {
            int[] newdp = new int[target + 1];

            for (int j = 0; j <= target; j++) {
                int no = dp[j]; // No Call
                int yes = (j >= arr[i - 1]) ? dp[j - arr[i - 1]] : 0;

                newdp[j] = no + yes;
            }

            dp = newdp;
        }

        return dp[target];
    }

    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int val : nums)
            total += val;

        if (target > total)
            return 0; // Even if every element is +ve, S1 - S2 = total

        if ((total - target) % 2 == 1)
            return 0;

        return countTargetSumSubset(nums, (total - target) / 2);
    }
}
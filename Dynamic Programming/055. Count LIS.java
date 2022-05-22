import java.util.*;

// Leetcode: 673: https://leetcode.com/problems/number-of-longest-increasing-subsequence/

class Solution {
    // Time - O(N * N), Space - O(N * 2)
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // Length of LIS ending at index i
        Arrays.fill(dp, 1);

        int[] count = new int[n]; // Count of LIS ending at index i
        Arrays.fill(count, 1);

        int maxLIS = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[i] <= dp[j] + 1) {
                    if (dp[i] < dp[j] + 1)
                        count[i] = 0;

                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    count[i] += count[j];
                }
            }

            maxLIS = Math.max(maxLIS, dp[i]);
        }

        int countLIS = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLIS)
                countLIS += count[i];
        }

        return countLIS;
    }
}
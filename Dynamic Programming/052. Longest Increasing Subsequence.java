import java.util.*;
// Leetcode 300: https://leetcode.com/problems/longest-increasing-subsequence/

class Memoization {
    // Time - O(N * N), Space - O(N * N)
    public int memo(int curr, int prev, int[] nums, int[][] dp) {
        if (curr == nums.length)
            return 0;
        if (dp[curr][prev + 1] != -1)
            return dp[curr][prev + 1];

        int yes = (prev == -1 || nums[prev] < nums[curr])
                ? memo(curr + 1, curr, nums, dp) + 1
                : 0;

        int no = memo(curr + 1, prev, nums, dp);

        return dp[curr][prev + 1] = Math.max(yes, no);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return memo(0, -1, nums, dp);
    }
}

class Tabulation {
    // Time - O(N * N), Space - O(N)
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLIS = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1; // If Prev Does not Exist, then current element can have yes

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLIS = Math.max(maxLIS, dp[i]);
        }

        return maxLIS;
    }
}

class BinarySearch {
    // Time - O(N * Log2N), Space - O(N)
    public int lowerBound(ArrayList<Integer> nums, int target) {
        int low = 0, high = nums.size() - 1;
        int idx = nums.size();

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
                idx = mid;
            }
        }

        return idx;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> sorted = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int lb = lowerBound(sorted, nums[i]);
            if (lb == sorted.size()) {
                sorted.add(nums[i]);
                // Current Element larger than the largest
                // LIS of one length more
            } else {
                sorted.set(lb, nums[i]);
            }
        }

        return sorted.size(); // This Sorted Array has same size as LIS
    }
}
// LC 918: https://leetcode.com/problems/maximum-sum-circular-subarray/

class Solution1 {
    // Using Prefix and Suffix Array
    // Time - O(N), Space - O(N)

    public int maxSubarraySumCircular(int[] nums) {
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currSum = Math.max(currSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        int prefSum = nums[0];
        int[] prefix = new int[nums.length];
        prefix[0] = prefSum;

        for (int i = 1; i < nums.length; i++) {
            prefSum += nums[i];
            prefix[i] = Math.max(prefix[i - 1], prefSum);
        }

        int suffixSum = nums[nums.length - 1];
        int[] suffix = new int[nums.length];
        suffix[nums.length - 1] = suffixSum;

        for (int i = nums.length - 2; i >= 0; i--) {
            suffixSum += nums[i];
            suffix[i] = Math.max(suffixSum, suffix[i + 1]);
        }

        for (int i = 0; i < nums.length; i++) {
            suffixSum = (i + 1 < nums.length) ? suffix[i + 1] : 0;
            maxSum = Math.max(maxSum, prefix[i] + suffixSum);
        }

        return maxSum;
    }
}

class Solution2 {
    // Using Max Sum Subarray and Min Sum Subarray
    // Time - O(N), Space - O(1)

    public int maxSubarraySumCircular(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int currMin = 0, currMax = 0;
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            currMin = Math.min(currMin + nums[i], nums[i]);
            currMax = Math.max(currMax + nums[i], nums[i]);

            minSum = Math.min(minSum, currMin);
            maxSum = Math.max(maxSum, currMax);
            total = total + nums[i];
        }

        if (maxSum < 0)
            return maxSum;
        return Math.max(maxSum, total - minSum);
    }
}
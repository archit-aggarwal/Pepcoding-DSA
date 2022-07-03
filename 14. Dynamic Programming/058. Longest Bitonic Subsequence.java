// 1671. Minimum Number of Removals to Make Mountain Array
// https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/

class Solution {
    // Time - O(N^2 + N^2 + N), Space - O(N + N)
    public int minimumMountainRemovals(int[] nums) {
        int[] left = new int[nums.length];
        // Longest Increasing Subsequence ending at index i

        for (int i = 0; i < nums.length; i++) {
            left[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }

        int[] right = new int[nums.length];
        // Longest Decreasing Subsequence starting at index i

        for (int i = nums.length - 1; i >= 0; i--) {
            right[i] = 1;

            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }

        // Longest Bitonic Subsequence with peak at index i
        // = LIS ending at i + LDS starting at i - 1
        // -1 represents the peak element occuring in both LIS and LDS
        // Constraint: LIS > 1 && LDS > 1 (Alteast 1 element to the left of peak
        // and atleast 1 element to the right of peak)
        int maxBitonic = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = left[i] + right[i] - 1;
            if (left[i] > 1 && right[i] > 1) {
                maxBitonic = Math.max(maxBitonic, curr);
            }
        }

        return nums.length - maxBitonic;
    }
}
import java.util.*;

// Leetcode 376: https://leetcode.com/problems/wiggle-subsequence/

class Solution {
    // Time - O(N), Space - O(2 * N) = O(N)
    public int wiggleMaxLength(int[] nums) {
        int[] inc = new int[nums.length];
        Arrays.fill(inc, 1);

        int[] dec = new int[nums.length];
        Arrays.fill(dec, 1);

        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // We are Increasing
                    inc[i] = Math.max(inc[i], dec[j] + 1);
                } else if (nums[i] < nums[j]) {
                    // We are Decreasing
                    dec[i] = Math.max(dec[i], inc[j] + 1);
                }
            }

            maxLength = Math.max(maxLength, Math.max(inc[i], dec[i]));
        }

        return maxLength;
    }
}
// Leetcode 845: Longest Mountain in Array
// https://leetcode.com/problems/longest-mountain-in-array/

import java.util.*;

class DP {
    // Time - O(N), Space - O(N)
    public int longestMountain(int[] nums) {
        int[] left = new int[nums.length];
        // Longest increasing subarray ending at index i
        Arrays.fill(left, 1);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                left[i] = left[i - 1] + 1;
            }
        }

        int[] right = new int[nums.length];
        // Longest decreasing subarray starting at index i
        Arrays.fill(right, 1);

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }

        // Longest Bitonic Subarray = LIS + LDS - 1
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (left[i] > 1 && right[i] > 1) {
                max = Math.max(max, left[i] + right[i] - 1);
            }
        }

        return max;
    }
}

class Greedy {
    // Time - O(N), Space - O(1)
    public int longestMountain(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {

            // Potential Peak Element
            if (i > 0 && i < nums.length - 1 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {

                int curr = 1;

                int left = i - 1;
                while (left >= 0 && nums[left] < nums[left + 1]) {
                    left--;
                    curr++;
                }

                int right = i + 1;
                while (right < nums.length && nums[right] < nums[right - 1]) {
                    right++;
                    curr++;
                }

                max = Math.max(max, curr);
            }

        }

        return max;
    }
}
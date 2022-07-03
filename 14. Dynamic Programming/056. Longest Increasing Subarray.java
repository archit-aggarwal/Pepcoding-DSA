class Solution {
    // Time - O(N), Space - O(1)
    public int findLengthOfLCIS(int[] nums) {
        int curr = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i - 1] < nums[i]) {
                curr++; // Extend the Previous Subarray
            } else {
                curr = 1; // Start New Increasing Subarray
            }

            max = Math.max(max, curr);
        }

        return max;
    }
}
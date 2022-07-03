// leetcode 413: https://leetcode.com/problems/arithmetic-slices/

class Solution {
    // Time - O(N), Space - O(1)
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3)
            return 0;

        int count = 0;
        int currLength = 2;
        int diff = nums[1] - nums[0];

        for (int i = 2; i < nums.length; i++) {
            int newdiff = nums[i] - nums[i - 1];

            if (newdiff == diff) {
                currLength++;
            } else {
                currLength = 2;
                diff = newdiff;
            }

            if (currLength >= 3)
                count = count + (currLength - 2);
        }

        return count;
    }
}
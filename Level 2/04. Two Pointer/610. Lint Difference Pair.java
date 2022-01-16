public class Solution {
    /**
     * @param nums:   an array of Integer
     * @param target: an integer
     * @return: [num1, num2] (num1 < num2)
     */
    public int[] twoSum7(int[] nums, int target) {
        int left = 0, right = 1;
        while (left != nums.length && right != nums.length) {
            if (left == right) {
                if (target < 0) {
                    left++;
                } else {
                    right++;
                }
                continue;
            }

            int diff = nums[right] - nums[left];

            if (diff == target) {
                int min = Math.min(nums[left], nums[right]);
                int max = Math.max(nums[left], nums[right]);
                return new int[] { min, max };
            } else if (diff < target) {
                right++;
            } else {
                left++;
            }
        }
        return null;
    }
}
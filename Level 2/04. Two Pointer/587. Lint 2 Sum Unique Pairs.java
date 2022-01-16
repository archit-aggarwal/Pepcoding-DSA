public class Solution {
    /**
     * @param nums:   an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int count = 0;
        while (left < right) {
            if (left > 0 && nums[left - 1] == nums[left]) {
                left++;
                continue;
            }

            int sum = nums[left] + nums[right];
            if (sum == target) {
                count++;
                left++;
                right--;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return count;
    }
}
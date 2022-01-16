public class Solution {
    public int twoSum2(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;

        int count = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum <= target) {
                left++;
            } else {
                count += right - left;
                right--;
            }
        }

        return count;
    }
}
public class Solution {
    /**
     * @param nums:   an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int abs = Integer.MAX_VALUE;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return 0;
            } else if (sum > target) {
                abs = Math.min(abs, sum - target);
                right--;
            } else {
                abs = Math.min(abs, target - sum);
                left++;
            }
        }

        return abs;
    }
}
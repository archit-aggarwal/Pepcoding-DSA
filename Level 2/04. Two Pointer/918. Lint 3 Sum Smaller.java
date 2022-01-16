public class Solution {
    public int twoSumSmaller(int[] nums, int left, int target) {
        int right = nums.length - 1;

        int count = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum < target) {
                count += right - left;
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        for (int f = 0; f < nums.length; f++) {
            ans += twoSumSmaller(nums, f + 1, target - nums[f]);
        }
        return ans;
    }
}
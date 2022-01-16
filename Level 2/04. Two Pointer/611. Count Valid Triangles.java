class Solution {
    public int twoSumGreater(int[] nums, int right, int target) {
        int left = 0;

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

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;

        for (int c = nums.length - 1; c > 1; c--) {
            ans += twoSumGreater(nums, c - 1, nums[c]);
        }

        return ans;
    }
}
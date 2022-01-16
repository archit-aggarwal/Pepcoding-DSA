class Solution {
    public int twoSumClosest(int[] nums, int left, int target) {
        int right = nums.length - 1;
        int abs = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return target;
            } else if (sum > target) {
                if (sum - target < abs) {
                    abs = sum - target;
                    ans = sum;
                }
                right--;
            } else {
                if (target - sum < abs) {
                    abs = target - sum;
                    ans = sum;
                }
                left++;
            }
        }

        return ans;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        int abs = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int curr = twoSumClosest(nums, i + 1, target - nums[i]) + nums[i];
            if (Math.abs(curr - target) < abs) {
                abs = Math.abs(curr - target);
                ans = curr;
            }
        }
        return ans;
    }
}
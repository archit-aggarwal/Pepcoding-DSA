class Solution {
    public int diffPair(int[] nums, int target) {
        int left = 0, right = 1, count = 0;
        while (left < nums.length && right < nums.length) {
            if (left > 0 && nums[left - 1] == nums[left]) {
                left++;
                continue;
            }
            if (left == right) {
                right++;
                continue;
            }

            int diff = nums[right] - nums[left];

            if (diff == target) {
                count++;
                left++;
            } else if (diff < target) {
                right++;
            } else {
                left++;
            }
        }

        return count;
    }

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        return diffPair(nums, k);
    }
}
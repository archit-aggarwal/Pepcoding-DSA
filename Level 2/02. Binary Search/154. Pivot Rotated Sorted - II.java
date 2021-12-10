class Solution {
    // Time Complexity will be O(log n) in average case, but O(n) in worst case
    // Worst case: All elements equal: We have to linearly reduce the search space
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[high]) {
                high = mid;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high--;
            }
        }

        return nums[low];
    }
}
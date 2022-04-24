class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length >= 10000) return -1;
        
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
          pivot = left + (right - left) / 2;
          if (nums[pivot] == target) return pivot;
          if (target < nums[pivot]) right = pivot - 1;
          else left = pivot + 1;
        }
        return left;
  }
}
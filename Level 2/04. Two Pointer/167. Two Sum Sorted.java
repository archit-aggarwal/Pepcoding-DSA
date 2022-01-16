class Solution {
    public int[] twoSum(int[] nums, int target) {
        // brute force
        // for(int i=0; i<nums.length; i++){
        // for(int j=i+1; j<nums.length; j++){
        // if(nums[i] + nums[j] == target){
        // return new int[]{i + 1, j + 1};
        // }
        // }
        // }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 };
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return null;
    }
}
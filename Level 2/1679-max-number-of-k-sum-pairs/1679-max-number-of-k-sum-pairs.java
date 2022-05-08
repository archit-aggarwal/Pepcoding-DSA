class Solution {
    public int maxOperations(int[] nums, int target) {
        Arrays.sort(nums);
        
        int left = 0, right = nums.length - 1;
        int count = 0;
        
        while(left < right){
            if(nums[left] + nums[right] == target){
                count++; 
                left++; right--;
            } else if(nums[left] + nums[right] < target){
                left++;
            } else {
                right--;
            }
        }
        
        return count;
    }
}
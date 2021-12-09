class Solution {
    
    public boolean isMinimum(int[] nums, int mid){
        int lval = (mid - 1 < 0) 
                            ? Integer.MAX_VALUE : nums[mid - 1]; 
        int rval = (mid + 1 >= nums.length) 
                            ? Integer.MAX_VALUE : nums[mid + 1];
            
        if(nums[mid] < lval && nums[mid] < rval) return true;
        return false;
    }
    
    public boolean isMaximum(int[] nums, int mid){
        int lval = (mid - 1 < 0) 
                            ? Integer.MIN_VALUE : nums[mid - 1];
        
        int rval = (mid + 1 >= nums.length) 
                            ? Integer.MIN_VALUE : nums[mid + 1];
            
        if(nums[mid] > lval && nums[mid] > rval) return true;
        return false;
    }
    
    public int findMin(int[] nums) {
        // entire array is sorted
        if(nums[0] < nums[nums.length - 1]){
            return nums[0];    
        }
        
        int left = 0, right = nums.length - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            // mid is minimum / pivot
            if(isMinimum(nums, mid)){
                return nums[mid];
            }
            
            // mid is maximum -> next Element will be minimum
            else if(isMaximum(nums, mid)){
                return nums[mid + 1];
            }
            
            // left range sorted -> discard left
            else if(nums[left] < nums[mid]){
                left = mid + 1;
            }
            
            // right range sorted -> discard right
            else if(nums[mid] < nums[right]){
                right = mid - 1;
            }
            
        }
        
        return 0;
    }
}

class Solution {
    public int pivotIndex(int[] nums) {
        int[] pref = new int[nums.length];
        pref[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            pref[i] = pref[i - 1] + nums[i];
        }
        
        
        for(int i=0; i<nums.length; i++){
            int leftSum = (i == 0) ? 0 : pref[i - 1];
            int rightSum = (i == nums.length - 1) ? 0 : (pref[nums.length - 1] - pref[i]);
            
            if(leftSum == rightSum) return i;
        }
        
        return -1;
    }
}
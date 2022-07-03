class Solution {
    
    public int change(int target, int[] nums) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for(int j=0; j<nums.length; j++)
        {
            for(int currtarget=1; currtarget<=target; currtarget++)
            {
                int remVal = currtarget - nums[j];
                if(remVal >= 0)
                    dp[currtarget] += dp[remVal];
            }
        }
        
        return dp[target];
    }
}

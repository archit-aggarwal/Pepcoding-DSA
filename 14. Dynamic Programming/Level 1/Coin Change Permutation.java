class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for(int currtarget=1; currtarget<=target; currtarget++)
        {
            for(int j=0; j<nums.length; j++)
            {
                int remVal = currtarget - nums[j];
                if(remVal >= 0)
                    dp[currtarget] += dp[remVal];
            }
        }
        
        return dp[target];
    }
}

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // Ways to reach dest when src = dest is 1. (Empty String)
        
        // Time - O(Amount * Coins), Space - O(Amount)
        for(int coin: coins){
            for(int i=1; i<= amount; i++){
                if(i >= coin){
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}
class Solution {
    public int memo(int amount, int[] coins, int[] dp){
        if(amount == 0) return 0;
        if(dp[amount] != -1) return dp[amount];
        
        int minCoins = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++){
            if(amount - coins[i] >= 0){
                minCoins = Math.min(minCoins, memo(amount - coins[i], coins, dp));
            }
        }
        
        if(minCoins < Integer.MAX_VALUE) minCoins += 1;
        return dp[amount]  = minCoins;
    }
    
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        
        int ans = memo(amount, coins, dp);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}
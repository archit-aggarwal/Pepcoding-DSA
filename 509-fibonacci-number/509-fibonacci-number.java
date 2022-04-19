class Solution {
    public int fib(int n, int[] dp){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(dp[n] != -1) return dp[n]; 
        // Already Calculated Value should be returned
        
        int prev1 = fib(n - 1, dp);
        int prev2 = fib(n - 2, dp);
        
        dp[n] = prev1 + prev2;
        // Before returning the calculated value, store it somewhere
        return prev1 + prev2;
    }
    
    public int fib(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return fib(n, dp);
    }
}
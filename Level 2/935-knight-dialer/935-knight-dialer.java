class Solution {
    int[][] jumps = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, 
                     {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
    
    int[][] dp = new int[11][5001];
    int mod = 1000000007;
    
    public int helper(int cell, int moves){
        if(moves <= 1) return moves;
        if(dp[cell][moves] != -1) return dp[cell][moves];
        
        int ans = 0;
        for(int nbr: jumps[cell])
            ans = (ans + helper(nbr, moves - 1)) % mod;
        
        return dp[cell][moves] = ans;
    }
    
    public int knightDialer(int n) {
        for(int i=0; i<=10; i++)
            for(int j=0; j<=5000; j++)
                dp[i][j] = -1;
        
        int ans = 0;
        for(int i=0; i<10; i++)
            ans = (ans + helper(i, n)) % mod;
        return ans;
    }
}
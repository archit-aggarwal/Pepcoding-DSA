class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] jumps = new int[n + 1];
        for(int i=0; i<=n; i++){
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            jumps[left] =  Math.max(jumps[left], right - left);
        }
        
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;
        
        for(int i=n-1; i>=0; i--){
            for(int j=1; j<=jumps[i]; j++)
                dp[i] = Math.min(dp[i], dp[i + j] + 1l);
        }
        
        return (dp[0] != Integer.MAX_VALUE) ? (int)dp[0] : -1;
    }
}
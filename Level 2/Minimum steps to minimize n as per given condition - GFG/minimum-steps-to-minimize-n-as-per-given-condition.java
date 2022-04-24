// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minSteps(n));
                    
                }
        }
}    // } Driver Code Ends


class Solution{
    public int memo(int N, int[] dp){
        if(N == 1) return 0;
        if(dp[N] != -1) return dp[N];
        
        int ans1 = (N % 2 == 0) ? memo(N/2, dp) : Integer.MAX_VALUE;
        int ans2 = (N % 3 == 0) ? memo(N/3, dp) : Integer.MAX_VALUE;
        int ans3 = memo(N - 1, dp);
        
        return dp[N] = Math.min(ans1, Math.min(ans2, ans3)) + 1;
    }
    
	public int minSteps(int N) {
	   int[] dp = new int[N + 1];
	   Arrays.fill(dp, -1);
	   
	   return memo(N, dp);
	} 
}

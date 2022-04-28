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
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
    public int mod = 1000000007;
    public long countFriendsPairing(int n, long[] dp){
        if(n == 0 || n == 1) return 1l;
        if(dp[n] != -1) return dp[n];
        
        long single = countFriendsPairing(n - 1, dp);
        long pair = ((n - 1l) * countFriendsPairing(n - 2, dp)) % mod;
        
        return dp[n] = (single + pair) % mod;
    }
    public long countFriendsPairings(int n) 
    {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        return countFriendsPairing(n, dp);
    }
}    
 
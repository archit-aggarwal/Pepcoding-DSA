// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int memo(int index, int cap, int cost[], int wt[], int N, int[][] dp){
        if(index == N || cap == 0) return 0;
        if(dp[index][cap] != -1) return dp[index][cap];
        
        int no = memo(index + 1, cap, cost, wt, N, dp);
        int yes = (cap >= wt[index]) 
            ? cost[index] + memo(index, cap - wt[index], cost, wt, N, dp) : -1;
        
        return dp[index][cap] = Math.max(yes, no);
    }
    
    static int knapSack(int N, int cap, int cost[], int wt[])
    {
        int[][] dp = new int[N + 1][cap + 1];
        for(int i=0; i<=N; i++){
            for(int j=0; j<=cap; j++){
                dp[i][j] = -1;
            }
        }
        
        return memo(0, cap, cost, wt, N, dp);
    }
}
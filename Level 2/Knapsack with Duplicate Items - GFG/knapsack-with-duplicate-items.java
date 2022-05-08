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
    static int knapSack(int N, int caps, int cost[], int wt[])
    {
        int[] dp = new int[caps + 1];
        
        for(int item=1; item<=N; item++){
            for(int cap=1; cap<=caps; cap++){
                int no = dp[cap];
                int yes = (cap >= wt[item - 1]) 
                    ? dp[cap - wt[item - 1]] + cost[item - 1] 
                    : -1;
                    
                dp[cap] = Math.max(no, yes);
            }
        }
        
        return dp[caps];
    }
}
	import java.io.*;
	import java.util.*;

	public class Main {

	    public static void main(String[] args) throws Exception {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int[] profits = new int[n];
            for(int i=0; i<n; i++)
                profits[i] = scn.nextInt();
                
            int[] weights = new int[n];
            for(int i=0; i<n; i++)
                weights[i] = scn.nextInt();
                
            int cap = scn.nextInt();
            
            // Unbounded Knapsack Tabulation
            // i -> Current Capacity
            int[] dp = new int[cap + 1];
            for(int i=1; i<=cap; i++)
            {
                // Loop for items: Options Explore
                for(int j=0; j<n; j++)
                {
                    int remCap = i - weights[j];
                    if(remCap >= 0)
                    {
                        int remProfit = dp[remCap];
                        int totalProfit = profits[j] + remProfit;
                        dp[i] = Math.max(dp[i], totalProfit); 
                    }
                }
            }
            
            System.out.println(dp[cap]);
            
            // Unbounded Knapsack Recursion
            // System.out.println(ubk(cap, profits, weights));
	    }
	    
	    public static int ubk(int cap, int[] profits, int[] weights){
	        if(cap == 0) return 0;
	        
	        int ans = 0;
	        for(int  i=0; i<weights.length; i++){
	            if(cap >= weights[i])
	                ans = Math.max(ans, profits[i] + ubk(cap - weights[i], profits, weights));
	        }
	        return ans;
	    }
	}

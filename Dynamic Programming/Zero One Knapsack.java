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
        
        // Zero One Knapsack Recursion
        System.out.println(zok(0, cap, profits, weights));
    }
    
    public static int zok(int idx, int cap, int[] profits, int[] weights){
        if(idx == profits.length){
            return 0;
        }
        
        int yes = 0;
        if(cap - weights[i] >= 0)
            yes = profits[idx] + zok(idx + 1, cap - weights[idx], profits, weights));
            
        int no = zok(idx + 1, cap, profits, weights);
        
        return Math.max(yes, no);
    }
    
}

// Zero One Knapsack Tabulation
public class Solution {
    public int solve(int[] profit, int[] weight, int cap) {
        int n = profit.length;
        int[][] dp = new int[n + 1][cap + 1];

        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=cap; j++)
            {
                int no = dp[i - 1][j];
                int yes = (j - weight[i - 1] < 0) ? 0 
                           : dp[i - 1][j - weight[i - 1]] + profit[i - 1];
                dp[i][j] = Math.max(yes, no);
            }
        }

        return dp[n][cap];
    }
}

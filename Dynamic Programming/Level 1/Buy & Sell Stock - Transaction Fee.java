import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] cost = new int[n];
        for(int i=0; i<n; i++){
            cost[i] = scn.nextInt();
        }
        int fee = scn.nextInt();
        
        int[][] dp = new int[n][2];
        // 0th Column -> Extra Buy, 1st Column -> Complete Sell
        
        dp[0][0] = -cost[0]; 
        dp[0][1] = 0;
        
        
        for(int i=1; i<n; i++)
        {
            // Extra Buy
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - cost[i]);
            
            // Complete Sell
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + cost[i] - fee);
        }
        
        System.out.println(dp[n-1][1]);
    }

}

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[][] cost = new int[n][3];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<3; j++)
                cost[i][j] = scn.nextInt();
        }
        
        
        int[][] dp = new int[n][3];
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];
        
        for(int house=1; house<n; house++)
        {
            // red
            dp[house][0] = Math.min(dp[house - 1][1], dp[house - 1][2]) + cost[house][0];
            
            // green
            dp[house][1] = Math.min(dp[house - 1][0], dp[house - 1][2]) + cost[house][1];
            
            // blue
            dp[house][2] = Math.min(dp[house - 1][0], dp[house - 1][1]) + cost[house][2];
        }
        
        System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
    }
}

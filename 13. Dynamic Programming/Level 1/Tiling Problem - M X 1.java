import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        
        System.out.println(tiling(n, m, dp));
    }
    
    // O(N) Time
    public static int tiling(int n, int m, int[] dp){
        if(n < 0) return 0;
        if(n == 0 || n == 1) return 1;
        
        // Memoization
        if(dp[n] != -1) return dp[n];
        
        int ans = tiling(n - 1, m, dp) + tiling(n - m, m, dp);
        dp[n] = ans;
        
        return ans;
    }
}

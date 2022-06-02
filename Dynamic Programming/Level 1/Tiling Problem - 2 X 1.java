import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        
        System.out.println(tiling(n, dp));
    }
    
    public static int tiling(int n, int[] dp){
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        
        if(dp[n] != -1) return dp[n];
        
        int ans = tiling(n - 1, dp) + tiling(n - 2, dp);
        dp[n] = ans;
        
        return ans;
    }
    
    
}

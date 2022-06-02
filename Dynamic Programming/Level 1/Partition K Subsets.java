import java.io.*;
import java.util.*;

public class Main {
        
    public static long partitionKSubset(int n, int k, long[][] dp) {
        if(n == 0 || k == 0 || n < k){
            return 0l;
        }
        
        if(k == 1 || n == k){
            return 1l;
        }
        
        if(dp[n][k] != -1) return dp[n][k];
        
        long x = partitionKSubset(n - 1, k, dp);
        long y = partitionKSubset(n - 1, k - 1, dp);
        
        long ans = x * k + y;
        dp[n][k] = ans;
        return ans;
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        long[][] dp = new long[n + 1][k + 1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=k; j++)
                dp[i][j] = -1;
        }
        long res = partitionKSubset(n, k, dp);
        System.out.println(res);
    }
}

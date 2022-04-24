import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        
        System.out.println(friends(n, dp));
    }
    
    public static int friends(int n, int[] dp){
        if(n == 0) return 1;
        if(n == 1) return 1;
        
        if(dp[n] != -1) 
            return dp[n];
        
        int ans = friends(n - 1, dp) 
                + (n - 1) * friends(n - 2, dp);
        dp[n] = ans;
        return dp[n];
    }

}

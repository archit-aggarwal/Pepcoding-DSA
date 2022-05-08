// { Driver Code Starts


import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution{
    public int memo(int n, int price[], int[] dp){
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];
        
        int ans = 0;
        for(int cut=1; cut<=n; cut++){
            ans = Math.max(ans, price[cut - 1] + memo(n - cut, price, dp));
        }
        
        return dp[n] = ans;
    }
    public int cutRod(int price[], int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return memo(n, price, dp);
    }
    
}
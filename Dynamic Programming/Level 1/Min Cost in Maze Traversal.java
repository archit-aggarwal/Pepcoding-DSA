import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                arr[i][j] = scn.nextInt();
        
        // int[][] dp = new int[n][m];
        
        // for(int i=0; i<n; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        
        // System.out.println(minCostMemo(0, 0, n-1, m-1, arr, dp));
        System.out.println(minCostTab(arr));
    }
    
    
    public static int minCostMemo(int sr, int sc, int dr, int dc, int[][] arr, int[][] dp){
        if(sr > dr || sc > dc) return Integer.MAX_VALUE;
        if(sr == dr && sc == dc) return arr[dr][dc];
        
        if(dp[sr][sc] != -1){
            return dp[sr][sc];
        }
        
        // horizontal
        int x = minCostMemo(sr, sc + 1, dr, dc, arr, dp);
        // vertical
        int y = minCostMemo(sr + 1, sc, dr, dc, arr, dp);
        
        int ans = arr[sr][sc] + Math.min(x, y);
            
        dp[sr][sc] = ans;
        return dp[sr][sc];
    }
    
    public static int minCostTab(int[][] arr){
        int n = arr.length, m = arr[0].length;
        int[][] dp = new int[n][m];
        
        for(int i=n-1; i>=0; i--)
        {
            for(int j=m-1; j>=0; j--)
            {
                if(i + 1 < n && j + 1 < m) {
                    dp[i][j] = arr[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
                } else if(i == n - 1 && j == m - 1){
                    dp[i][j] = arr[i][j];
                } else if(j + 1 == m){
                    dp[i][j] = arr[i][j] + dp[i + 1][j];
                } else if(i + 1 == n){
                    dp[i][j] = arr[i][j] + dp[i][j + 1];                    
                }
            }
        }
        
        return dp[0][0];
    }
}

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = scn.nextInt();
        
        // destination is (n-1)th point
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        System.out.println(csmmMemo(0, n - 1, arr, dp));
    }
    
    public static int csmmMemo(int src, int dest, int[] arr, int[] dp){
        if(src > dest) return Integer.MAX_VALUE;
        if(src == dest) return 0;
        
        if(dp[src] != -1){
            return dp[src];    
        }
        
        int minMoves = Integer.MAX_VALUE;
        for(int jumps = 1; jumps <= arr[src]; jumps++){
            int ans = csmmMemo(src + jumps, dest, arr, dp);
            if(ans != Integer.MAX_VALUE)
                minMoves = Math.min(minMoves, ans + 1);
        }
        
        dp[src] = minMoves;
        return dp[src];
    }

}

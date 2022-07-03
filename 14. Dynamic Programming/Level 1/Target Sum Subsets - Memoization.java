// import java.io.*;
// import java.util.*;

// public class Main {

//     public static void main(String[] args) throws Exception {
//         Scanner scn = new Scanner(System.in);
//         int n = scn.nextInt();
//         int[] arr = new int[n];
//         for(int i=0; i<n; i++)
//             arr[i] = scn.nextInt();
        
//         int target = scn.nextInt();
        
//         boolean[][] dp = new boolean[n + 1][target + 1];
        
//         System.out.println(targetSum(arr, 0, 0, target, dp));
//     }
    
//     public static boolean targetSum(int[] arr, int idx, int sum, int target, boolean[][] dp)
//     {
//         if(idx == arr.length)
//         {
//             if(target == sum) return true;
//             return false;
//         }
        
//         if(sum > target) return false;
//         if(dp[idx][sum] != false) {
//             return true;
//             // return (dp[idx][sum] == 1) ? true : false;
//         }
        
//         // yes
//         boolean yes = targetSum(arr, idx + 1, sum + arr[idx], target, dp);
        
//         // no
//         boolean no = targetSum(arr, idx + 1, sum, target, dp);
        
        
//         if(yes == true || no == true){
//             dp[idx][sum] = true;
//             return true;
//         }else{
//             dp[idx][sum] = false;
//             return false;
//         }
//     }
// }

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = scn.nextInt();
        
        int target = scn.nextInt();
        
        int[][] dp = new int[n + 1][target + 1];
        
        for(int i=0; i<=n; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(targetSum(arr, 0, 0, target, dp));
    }
    
    public static boolean targetSum(int[] arr, int idx, int sum, int target, int[][] dp)
    {
        if(idx == arr.length)
        {
            if(target == sum) return true;
            return false;
        }
        
        if(sum > target) return false;
        if(dp[idx][sum] != -1) {
            return (dp[idx][sum] == 1) ? true : false;
        }
        
        // yes
        boolean yes = targetSum(arr, idx + 1, sum + arr[idx], target, dp);
        
        // no
        boolean no = targetSum(arr, idx + 1, sum, target, dp);
        
        
        if(yes == true || no == true){
            dp[idx][sum] = 1;
            return true;
        }else{
            dp[idx][sum] = 0;
            return false;
        }
    }
}

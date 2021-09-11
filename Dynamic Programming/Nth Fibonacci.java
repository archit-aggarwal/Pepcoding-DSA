import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    
    System.out.println(fibRec(n));
    
    
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    System.out.println(fibMem(n, dp));
    
    
    System.out.println(fibTab(n));
 }
 
 // recursion
 public static int fibRec(int n){
    if(n == 0 || n == 1){
        return n;
    }
    
    int fibn1 = fibRec(n - 1);
    int fibn2 = fibRec(n - 2);
    
    int finb = fibn1 + fibn2;
    return finb;
 }

 // memoization
 public static int fibMem(int n, int[] dp){
    if(n == 0 || n == 1){
        return n;
    }
    
    // Calls lagne se pehle
    if(dp[n] != -1){
        return dp[n];    
    }
    
    int fibn1 = fibMem(n - 1, dp);
    int fibn2 = fibMem(n - 2, dp);
    
    // calculate karne ke bad return karne se pehle
    dp[n] = fibn1 + fibn2;
    return dp[n];
 }
 
 // tabulation
 public static int fibTab(int n){
    int[] dp = new int[n + 1];
    dp[0] = 0; dp[1] = 1;
    
    for(int i=2; i<=n; i++){
        dp[i] = dp[i - 1] + dp[i - 2]; 
    }
    
    return dp[n];
 }
 
}

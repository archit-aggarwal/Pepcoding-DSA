// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}



// } Driver Code Ends


class Solution 
{ 
    // static int memo(int cap, int item, int[] wt, int[] cost, int[][] dp){
    //     if(item == cost.length) return 0; // No Item No Profit
    //     if(dp[cap][item] != -1) return dp[cap][item];
        
    //     int yes = (cap >= wt[item]) ?
    //         memo(cap - wt[item], item+1, wt, cost, dp) + cost[item]: -1; 
    //     int no = memo(cap, item+1, wt, cost, dp);
        
    //     return dp[cap][item] = Math.max(yes, no);
    // }
    
    static int knapSack(int caps, int wt[], int cost[], int n) 
    { 
        int[][] dp = new int[2][caps + 1];
        
        for(int item=1; item<=cost.length; item++){
            for(int cap=1; cap<=caps; cap++){
                
                int no = dp[0][cap];
                int yes = (cap >= wt[item - 1]) 
                        ? cost[item - 1] + dp[0][cap - wt[item - 1]]
                        : -1;
                        
                dp[1][cap] = Math.max(yes, no);
            }   
            
            for(int i=0; i<=caps; i++){
                dp[0][i] = dp[1][i];
            }
        }
        
        return dp[0][caps];
    } 
}



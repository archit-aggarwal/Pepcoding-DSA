// { Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j]  =Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortest_distance(matrix);
            for(int i = 0; i < n; i++){
                for(int j  = 0; j < n; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    public void shortest_distance(int[][] mat)
    {
        int n = mat.length;
        for(int mid=0; mid<n; mid++){
            for(int src=0; src<n; src++){
                for(int dest=0; dest<n; dest++){
                    if(src == mid || dest == mid || mat[src][mid] == -1 || mat[mid][dest] == -1)
                        continue;
                        
                    if(mat[src][dest] == -1) mat[src][dest] = Integer.MAX_VALUE;
                    mat[src][dest] = Math.min(mat[src][dest], mat[src][mid] + mat[mid][dest]);        
                }
            }
        }
    }
}
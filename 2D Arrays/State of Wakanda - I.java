import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    
    // Declaration & Initialization
    int n = scn.nextInt();
    int m = scn.nextInt();
    int[][] arr = new int[n][m];
    
    // INPUT
    for(int rows = 0; rows <= n-1; rows++)
    {
        for(int cols = 0; cols <= m-1; cols++) {
            arr[rows][cols] = scn.nextInt();
        }
    }
    
    // Wave Traversal
    for(int col = 0; col < m; col++)
    {
        if(col % 2 == 0) // even col
        {
            // Top to Bottom
            for(int row = 0; row < n; row++)
            {
                System.out.println(arr[row][col]);      
            }
        }
        else // odd col
        {
            // Bottom to Top
            for(int row = n-1; row >=0; row--)
            {
                System.out.println(arr[row][col]);
            }
        }
    }
 }

}
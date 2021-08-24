import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    
    // Declaration & Initialization
    int n1 = scn.nextInt();
    int m1 = scn.nextInt();
    int[][] arr1 = new int[n1][m1];
    
    // INPUT: 1st
    for(int rows = 0; rows <= n1-1; rows++)
    {
        for(int cols = 0; cols <= m1-1; cols++)
        {
            arr1[rows][cols] = scn.nextInt();
        }
    }
    
    int n2 = scn.nextInt();
    int m2 = scn.nextInt();
    int[][] arr2 = new int[n2][m2];
    
    // INPUT: 2nd
    for(int rows = 0; rows <= n2-1; rows++)
    {
        for(int cols = 0; cols <= m2-1; cols++)
        {
            arr2[rows][cols] = scn.nextInt();
        }
    }

    if(m1 == n2)
    {
        int[][] res = new int[n1][m2];
        for(int row=0; row<n1; row++)
        {
            for(int col=0; col<m2; col++)
            {
                // C[row][col]
                // First matrix -> row, Second matrix -> col
                int ans = 0;
                for(int k = 0; k < m1; k++) // or for(int k=0; k<n2; k++)
                {
                    ans = ans + 
                     arr1[row][k] * arr2[k][col]; 
                }
                res[row][col] = ans;
                System.out.print(ans + " ");
            }
            System.out.println();
        }
        
    }
    else
    {
        // Matrix Multiplication not possible
        System.out.println("Invalid input");
    }
 }

}

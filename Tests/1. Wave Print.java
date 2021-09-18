import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++)
                arr[i][j] = scn.nextInt();
        }
        
        // row-wise
        for(int i=0; i<n; i++)
        {
            if(i % 2 == 0) // l to r
            {
                for(int j=0; j<m; j++)
                    System.out.print(arr[i][j] + " ");
            }
            else // r to l
            {
                for(int j=m-1; j>=0; j--)
                    System.out.print(arr[i][j] + " ");
            }
        }
        System.out.println();
        
        // column-wise
        for(int j=0; j<m; j++)
        {
            if(j%2 == 0) // t to b
            {
                for(int i=0; i<n; i++)
                    System.out.print(arr[i][j] + " ");
            }
            else // b to t
            {
                for(int i=n-1; i>=0; i--)
                    System.out.print(arr[i][j] + " ");
            }
        }
    }
}

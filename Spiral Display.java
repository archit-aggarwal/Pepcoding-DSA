import java.io.*;
import java.util.*;

public class Main {

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
        
        int frow = 0, lrow = n-1, fcol = 0, lcol = m-1;
        int counter = 0;
        
        while(counter < n*m)
        {
            // left wall
            for(int i = frow; i <= lrow; i++)
            {
                int j = fcol;
                System.out.println(arr[i][j]);
                counter++;
                if(counter == n*m) return;
            }
            
            // Bottom - Left Element -> Duplicate
            fcol++;
            
            // bottom wall
            for(int j=fcol; j<=lcol; j++)
            {
                int i = lrow;
                System.out.println(arr[i][j]);
                counter++;
                if(counter >= n*m) return;
            }
            
            // Bottom - right Element -> Duplicate
            lrow--;
            
            // right wall
            for(int i = lrow; i>=frow; i--)
            {
                int j = lcol;
                System.out.println(arr[i][j]);
                counter++;
                if(counter >= n*m) return;                
            }
            
            // Top - right Element -> Duplicate
            lcol--;
            
            // top wall
            for(int j=lcol; j>=fcol; j--)
            {
                int i = frow;
                System.out.println(arr[i][j]);
                counter++;
                if(counter >= n*m) return;                
            }
            
            // Updation Condition? - for next shell
            frow++;
        }
        
        return;
    }

}
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        int frow = 0, lrow = n-1, fcol = 0, lcol = m-1;
        int counter = 0;
        
        while(counter < n*m)
        {
            
            // top wall
            for(int j=fcol; j<=lcol; j++)
            {
                int i = frow;
                System.out.print(arr[i][j] + " ");
                counter++;
                if(counter >= n*m) break;                
            }
            
            // Updation Condition? - for next shell
            frow++;

            // right wall
            for(int i = frow; i<=lrow; i++)
            {
                int j = lcol;
                System.out.print(arr[i][j] + " ");
                counter++;
                if(counter >= n*m) break;                
            }
            
            // Top - right Element -> Duplicate
            lcol--;

            // bottom wall
            for(int j=lcol; j>=fcol; j--)
            {
                int i = lrow;
                System.out.print(arr[i][j] + " ");
                counter++;
                if(counter >= n*m) break;
            }
            
            // Bottom - right Element -> Duplicate
            lrow--;
            
            // left wall
            for(int i = lrow; i >= frow; i--)
            {
                int j = fcol;
                System.out.print(arr[i][j] + " ");
                counter++;
                if(counter == n*m) break;
            }
            
            // Bottom - Left Element -> Duplicate
            fcol++;
            

        }
        
        System.out.println();
        frow = 0; fcol = 0; lrow = n-1; lcol = m-1;
        counter = 0;
        
        while(counter < n*m)
        {
            // left wall
            for(int i = frow; i <= lrow; i++)
            {
                int j = fcol;
                System.out.print(arr[i][j] + " ");
                counter++;
                if(counter == n*m) break;
            }
            
            // Bottom - Left Element -> Duplicate
            fcol++;
            
            // bottom wall
            for(int j=fcol; j<=lcol; j++)
            {
                int i = lrow;
                System.out.print(arr[i][j] + " ");
                counter++;
                if(counter >= n*m) break;
            }
            
            // Bottom - right Element -> Duplicate
            lrow--;
            
            // right wall
            for(int i = lrow; i>=frow; i--)
            {
                int j = lcol;
                System.out.print(arr[i][j] + " ");
                counter++;
                if(counter >= n*m) break;                
            }
            
            // Top - right Element -> Duplicate
            lcol--;
            
            // top wall
            for(int j=lcol; j>=fcol; j--)
            {
                int i = frow;
                System.out.print(arr[i][j] + " ");
                counter++;
                if(counter >= n*m) break;                
            }
            
            // Updation Condition? - for next shell
            frow++;
        }
    }
}

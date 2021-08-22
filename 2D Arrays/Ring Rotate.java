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
        for (int rows = 0; rows <= n - 1; rows++)
        {
          for (int cols = 0; cols <= m - 1; cols++)
          {
            arr[rows][cols] = scn.nextInt();
          }
        }
        
        int s = scn.nextInt();
        int r = scn.nextInt();
        
        int[] oneD = getShell(arr, s);
        rotate(oneD, r);
        fillShell(arr, oneD, s);
        display(arr);
    }
    
    public static int[] getShell(int[][] arr, int s)
    {
        int n = arr.length, m = arr[0].length;
        int frow = s - 1, fcol = s - 1;
        int lrow = n - s, lcol = m - s;
        int size = 2 * (lcol - fcol) + 
                    2 * (lrow - frow);
        
        int[] oneD = new int[size];
        
        int counter = 0;
        while(counter < size)
        {
            // left wall
            for(int i = frow; i <= lrow; i++)
            {
                int j = fcol;
                oneD[counter] = arr[i][j];
                counter++;
                if(counter >= size) return oneD;
            }
            
            // Bottom - Left Element -> Duplicate
            fcol++;
            
            // bottom wall
            for(int j=fcol; j<=lcol; j++)
            {
                int i = lrow;
                oneD[counter] = arr[i][j];
                counter++;
                if(counter >= size) return oneD;
            }
            
            // Bottom - right Element -> Duplicate
            lrow--;
            
            // right wall
            for(int i = lrow; i>=frow; i--)
            {
                int j = lcol;
                oneD[counter] = arr[i][j];
                counter++;
                if(counter >= size) return oneD;                
            }
            
            // Top - right Element -> Duplicate
            lcol--;
            
            // top wall
            for(int j=lcol; j>=fcol; j--)
            {
                int i = frow;
                oneD[counter] = arr[i][j];
                counter++;
                if(counter >= size) return oneD;                
            }
        }
        
        return oneD;
    }
    
      public static void swap(int[] arr, int left, int right)
  {
      int temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
  }
  
  public static void reverse(int[] arr, 
         int left, int right){
    while(left < right)
    {
        swap(arr, left, right);
        left++; right--;
    }
  }
  
  public static void rotate(int[] a, int k){
    // write your code here
    int n = a.length;
    k = ((k % n + n) % n);
    reverse(a, 0, n-k-1); // First n-k elements
    reverse(a, n-k, n-1); // Last k elements
    reverse(a, 0, n-1); // Whole array
  }
  
  public static void fillShell(int[][] arr, int[] oneD, int s)
  {
      int n = arr.length, m = arr[0].length;
        int frow = s - 1, fcol = s - 1;
        int lrow = n - s, lcol = m - s;
        int size = 2 * (lcol - fcol) + 
                    2 * (lrow - frow);
        
        int counter = 0;
        while(counter < size)
        {
            // left wall
            for(int i = frow; i <= lrow; i++)
            {
                int j = fcol;
                arr[i][j] = oneD[counter];
                counter++;
                if(counter >= size) return;
            }
            
            // Bottom - Left Element -> Duplicate
            fcol++;
            
            // bottom wall
            for(int j=fcol; j<=lcol; j++)
            {
                int i = lrow;
                arr[i][j] = oneD[counter];
                counter++;
                if(counter >= size) return;
            }
            
            // Bottom - right Element -> Duplicate
            lrow--;
            
            // right wall
            for(int i = lrow; i>=frow; i--)
            {
                int j = lcol;
                arr[i][j] = oneD[counter];
                counter++;
                if(counter >= size) return;                
            }
            
            // Top - right Element -> Duplicate
            lcol--;
            
            // top wall
            for(int j=lcol; j>=fcol; j--)
            {
                int i = frow;
                arr[i][j] = oneD[counter];
                counter++;
                if(counter >= size) return;                
            }
        }
  }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
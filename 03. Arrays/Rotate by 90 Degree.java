import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception     {
    // write your code here
    Scanner scn = new Scanner(System.in);

    // Declaration & Initialization
    int n = scn.nextInt();
    int[][] arr = new int[n][n];

    // INPUT
    for (int rows = 0; rows <= n - 1; rows++)
    {
      for (int cols = 0; cols <= n - 1; cols++)
      {
        arr[rows][cols] = scn.nextInt();
      }
    }
    
    // Transpose
    for(int rows = 0; rows < n; rows++)
    {
        for(int cols = rows + 1; cols < n; cols++)
        {
            // Swap (cols, rows) & (rows, cols)
            int temp = arr[rows][cols];
            arr[rows][cols] = arr[cols][rows];
            arr[cols][rows] = temp;
        }
    }
    
    // Row by Row Reverse
    for(int rows = 0; rows < n; rows++)
    { reverse(arr, rows); }
    
    display(arr);
  }
  
  public static void reverse(int[][] arr, int row)
  {
      int left = 0, right = arr[row].length - 1;
      while(left < right)
      {
          // (row, left) & (row, right) Swap
          int temp = arr[row][left];
          arr[row][left] = arr[row][right];
          arr[row][right] = temp;
          
          left++; right--;
      }
  }

  public static void display(int[][] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

}

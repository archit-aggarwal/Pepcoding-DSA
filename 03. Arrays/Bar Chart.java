import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<=n-1; i++)
    {
        arr[i] = scn.nextInt();
    }
    
    int cols = arr.length;
    int max = Integer.MIN_VALUE;
    for(int i=0; i<n; i++)
    {
        if(arr[i] > max) max = arr[i]; 
    }
    
    int rows = max;
    for(int i=rows; i>0; i--)
    {
        for(int j=0; j<cols; j++)
        {
            if(i <= arr[j]) // condition
                { System.out.print("*	"); }
            else System.out.print("	");
        }
        System.out.println();
    }
 }

}
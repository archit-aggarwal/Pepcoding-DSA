import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) {
	    Scanner scn = new Scanner(System.in);
	    int testCases =  scn.nextInt();
        for(int test=1; test<=testCases; test++){
            int n = scn.nextInt();
        
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = scn.nextInt();
            }
            
            // Reversing Algorithm
            int start = 0, end = n - 1;
            while(start < end){
                
                // Swapping Start and End Index
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                
                start++; end--;
            }
            
            for(int i=0; i<n; i++){
                System.out.print(arr[i] + " ");
            }
            
            System.out.println();
        }
	}
}
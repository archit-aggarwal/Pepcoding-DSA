import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = scn.nextInt();
            
        int max = maxOfArray(arr, 0);
        System.out.println(max);
    }

    public static int maxOfArray(int[] arr, int idx){
        // Base Case
        if(idx == arr.length)
        { return Integer.MIN_VALUE; }
        
        // 1. Maximum of Remaining Array
        int k1 = maxOfArray(arr, idx + 1);
        
        // 2. Max of k1 & arr[idx]
        int max = Math.max(k1, arr[idx]);
        return max;
    }

}

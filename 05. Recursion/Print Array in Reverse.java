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
        
        displayArrReverse(arr, 0);
    }

    public static void displayArrReverse(int[] arr, int idx) {
        // Base Case
        if(idx == arr.length) return;
        
        // 1. Faith
        displayArrReverse(arr, idx + 1);
        
        // 2. Print arr of idx
        System.out.println(arr[idx]);
        
    }

}

import java.io.*;
import java.util.*;

public class Main{

// Combination of ceil and first occurence
public static int lowerBound(int[] arr, int target){
    int left = 0, right = arr.length - 1;
    int ans = arr.length;
    
    while(left <= right){
        int mid = left + (right - left) / 2;
        
        if(arr[mid] >= target){
            ans = mid;
            right = mid - 1;
        }
        else {
            left = mid + 1;
        }
    }
    return ans;
}

// This is nothing but ceil
public static int upperBound(int[] arr, int target){
    int left = 0, right = arr.length - 1;
    while(left <= right){
        int mid = left + (right - left) / 2;
        
        if(arr[mid] <= target) 
            left = mid + 1;
        else right = mid - 1;
    }
    return left;
}

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<n; i++){
        arr[i] = scn.nextInt();
    }
    
    int target = scn.nextInt();
    System.out.println(lowerBound(arr, target));
    System.out.println(upperBound(arr, target));  
 }

}

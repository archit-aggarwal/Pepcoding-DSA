import java.io.*;
import java.util.*;

public class Main {

  public static void radixSort(int[] arr) {
    int Max = Integer.MIN_VALUE;
    for(int i=0; i<arr.length; i++){
        if(Max < arr[i])
            Max = arr[i];
    }
    
    for(int exp = 1; exp <= Max; exp *= 10){
        countSort(arr, exp);
    }
    
  }

  public static void countSort(int[] arr, int exp) {
    int[] freq = new int[10];
    for(int i=0; i<arr.length; i++)
    {
        int dig = (arr[i] / exp) % 10;
        freq[dig]++;
    }
    
    int[] pref = new int[10];
    for(int i=0; i<freq.length; i++) {
        if(i == 0){
            pref[i] = freq[i];
        } else {
            pref[i] = freq[i] + pref[i - 1];
        }
    }
    
    int[] ans = new int[arr.length];
    for(int i=arr.length - 1; i>=0; i--)
    {
        int idx = (arr[i] / exp) % 10;
        int lastOcc = pref[idx] - 1;
        ans[lastOcc] = arr[i];
        pref[idx] -= 1;
    }
    
    for(int i=0; i<arr.length; i++)
        arr[i] = ans[i];
        
    System.out.print("After sorting on ");
    System.out.print(exp + " place -> ");
    print(arr);
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    radixSort(arr);
    print(arr);
  }

}

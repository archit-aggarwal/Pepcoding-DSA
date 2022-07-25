import java.io.*;
import java.util.*;

public class Main {

  public static void countSort(int[] arr, int min, int max) {
       // Create Frequency of size equal to range of elements
       int[] freq = new int[max - min + 1];
       for(int i=0; i<arr.length; i++)
       {
           int idx = arr[i] - min;
           freq[idx]++;
       }
       
       // Build Prefix Sum Array using Frequency Array
       // prefix[i] = freq[0] + freq[1] + freq[2] + ... freq[i]
       // prefix[i] = prefix[i - 1] + freq[i]
       // But if i == 0, then prefix[i - 1] does not exists
    
       int[] prefixSum = new int[max - min + 1];
       for(int i=0; i<freq.length; i++)
       {
           if(i == 0) prefixSum[i] = freq[i];
           else prefixSum[i] = prefixSum[i - 1] + freq[i];
       }
       // We are processing input array in reverse order because prefix sum array contains the last index
       // of that element. Hence, last element should be processed first
    
       // Form New Answer Array (To not modify input array while traversing the input array)
       // Answer array will store all the elemnents in sorted order
      
       int[] ans = new int[arr.length];
       for(int i=arr.length - 1; i>=0; i--)
       {
           // This idx is index of element in prefixSum array (or frequency array)
           int idx = arr[i] - min;
         
           // If 2 occurs 4 times, then last index of 2 is (4 - 1) = 3.
           // Hence prefixSum[idx] - 1 = 4 - 1 = 3 is taken
           ans[prefixSum[idx] - 1] = arr[i];
         
           // PrefixSum is updated to store the value of last occurence of next element
           prefixSum[idx]--;
       }
       
       // Now, we needed to sort the input array, hence storing the answer array back to input array.
       for(int i=0; i<arr.length; i++)
        arr[i] = ans[i];
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    countSort(arr,min,max);
    print(arr);
  }

}

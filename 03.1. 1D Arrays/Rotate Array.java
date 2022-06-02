import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.println(sb);
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

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    rotate(a, k);
    display(a);
 }

}
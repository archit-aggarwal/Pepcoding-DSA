import java.io.*;
import java.util.*;

public class Main {

  public static void sort01(int[] arr) {
    int unexploredFirst = 0, greaterFirst = 0;
    while (unexploredFirst < arr.length)
    {
      // unexplored region : i to n-1
      // 0s region : 0 to j - 1
      // 1s region : j to i - 1

      if (arr[unexploredFirst] == 0)
      {
        // add unexplored element in smaller or equal region
        swap(arr, unexploredFirst, greaterFirst);
        greaterFirst++;
        unexploredFirst++;
      }
      else
      {
        // add unexplored element in greater region
        unexploredFirst++;
      }
    }
  }

// used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping index " + i + " and index " + j);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr) {
    for (int i = 0 ; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0 ; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    sort01(arr);
    print(arr);
  }

}

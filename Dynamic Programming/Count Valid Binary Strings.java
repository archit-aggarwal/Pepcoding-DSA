import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    // Count Binary Strings - Tabulation - O(n)
    int[] endWith0 = new int[n + 1];
    int[] endWith1 = new int[n + 1];
    endWith0[1] = endWith1[1] = 1;
    
    for(int i=2; i<=n; i++)
    {
        endWith0[i] = endWith1[i - 1];
        endWith1[i] = endWith0[i - 1] + endWith1[i - 1];
    }
    
    System.out.println(endWith0[n] + endWith1[n]);
    
    // Count Binary Strings - Tabulation - O(1)
    int prev0 = 1, prev1 = 1;
    for(int i=2; i<=n; i++)
    {
        int curr0 = prev1;
        int curr1 = prev0 + prev1;
        prev0 = curr0; prev1 = curr1;
    }

    System.out.println(prev0 + prev1);
    
    // Count Binary Strings - Recursion
    Pair ans = helper(n);
    System.out.println(ans.endWith0 + ans.endWith1);
  }

  static class Pair {
    int endWith0 = 0;
    int endWith1 = 0;
    Pair(int x, int y) {
      endWith0 = x;
      endWith1 = y;
    }
  }

  public static Pair helper(int n) {
    if (n == 0) return new Pair(0, 0);
    if (n == 1) return new Pair(1, 1);

    Pair smallProb = helper(n - 1);
    int prev0 = smallProb.endWith0;
    int prev1 = smallProb.endWith1;

    int curr0 = prev1;
    int curr1 = prev0 + prev1;
    return new Pair(curr0, curr1);
  }
}

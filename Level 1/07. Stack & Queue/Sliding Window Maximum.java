import java.io.*;
import java.util.*;

public class Main {

  public static int[] solve(int[] arr) {
    int n = arr.length;
    int[] nge = new int[n];

    Stack<Integer> stk = new Stack<>();
    for (int i = n - 1; i >= 0; i--) {

      // Pop Smaller Elements
      while (stk.size() > 0 && arr[stk.peek()] < arr[i]) {
        stk.pop();
      }

      // Answer -> Stack's top
      if (stk.size() == 0) {
        nge[i] = arr.length;
      } else {
        nge[i] = stk.peek();
      }

      // Push Yourself
      stk.push(i);
    }

    return nge;
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    // code
    int[] nge = solve(arr);

    int prevWinMax = 0;
    for (int st = 0; st <= n-k; st++)
    {
      int curr;
      if (prevWinMax >= st && prevWinMax < st + k) // prevWinMax in current Window
        curr = prevWinMax;
      else curr = st;

      while (nge[curr] >= st && nge[curr] < st + k) // exists in current window
        curr = nge[curr];
      
      prevWinMax = curr;
      System.out.println(arr[curr]);
    }
  }
}

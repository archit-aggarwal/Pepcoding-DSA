import java.io.*;
import java.util.*;

public class Main {
  public static void display(int[] a) {
    StringBuilder sb = new StringBuilder();

    for (int val : a) {
      sb.append(val + "
");
    }
    System.out.println(sb);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }

    int[] ngl = solve(a);
    display(ngl);
  }

  public static int[] solve(int[] arr) {
    int n = arr.length;
    int[] nge = new int[n];
    
    Stack<Integer> stk = new Stack<>();
    for(int i=0; i<n; i++){
        
        // Pop Smaller Elements
        while(stk.size() > 0 && stk.peek() < arr[i]){
            stk.pop();
        }
        
        // Answer -> Stack's top
        if(stk.size() == 0){
            nge[i] = -1;
        } else {
            nge[i] = stk.peek();
        }
        
        // Push Yourself
        stk.push(arr[i]);
    }
    
    return nge;
  }

}

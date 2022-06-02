import java.io.*;
import java.util.*;

public class Main{
  
public static int[] nsl(int[] arr){
    int n = arr.length;
    int[] left = new int[n];
    
    Stack<Integer> stk = new Stack<>();
    for(int i=0; i<n; i++){
        
        // Pop Smaller Elements
        while(stk.size() > 0 && arr[stk.peek()] >= arr[i]){
            stk.pop();
        }
        
        // Answer -> Stack's top
        if(stk.size() == 0){
            left[i] = -1;
        } else {
            left[i] = stk.peek();
        }
        
        // Push Yourself
        stk.push(i);
        
    }
    
    return left;
}

public static int[] nsr(int[] arr){
    int n = arr.length;
    int[] right = new int[n];
    
    Stack<Integer> stk = new Stack<>();
    for(int i=n-1; i>=0; i--){
        
        // Pop Smaller Elements
        while(stk.size() > 0 && arr[stk.peek()] >= arr[i]){
            stk.pop();
        }
        
        // Answer -> Stack's top
        if(stk.size() == 0){
            right[i] = arr.length;
        } else {
            right[i] = stk.peek();
        }
        
        // Push Yourself
        stk.push(i);
    }
    
    return right;
}

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }

    // code
    int[] left = nsl(arr);
    int[] right = nsr(arr);
    
    int maxArea = 0;
    for(int i=0; i<n; i++)
    {
        int length = right[i] - left[i] - 1;
        int height = arr[i];
        
        int currArea = length * height;
        
        maxArea = Math.max(maxArea, currArea);
    }
    
    System.out.println(maxArea);
 }
}

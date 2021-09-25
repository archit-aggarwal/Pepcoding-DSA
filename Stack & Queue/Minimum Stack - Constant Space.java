import java.io.*;
import java.util.*;

public class Main {

  public static class MinStack {
    Stack<Integer> stk;
    int min;

    public MinStack() {
      stk = new Stack<>();
      min = Integer.MAX_VALUE;
    }


    int size() {
        return stk.size();
    }

    void push(int val) {
        
        if(val > min){
            stk.push(val);
        } else {
            int currMin = val;
            int encodedVal = 2 * currMin - min;
            min = currMin;
            stk.push(encodedVal);
        }
        
    }

    int pop() {
        if(stk.size() == 0){
            System.out.println("Stack underflow");
            return -1;   
        }
        
        if(stk.peek() >= min){
            // it is actual value
            int val = stk.pop();
            return val;
        }
        
        // encoded value
        int encodedVal = stk.pop();
        int actualVal = min;
        int prevMin = 2 * actualVal - encodedVal;
        min = prevMin;
        return actualVal;
    }

    int top() {
        if(stk.size() == 0){
            System.out.println("Stack underflow");
            return -1;   
        }
        
        if(stk.peek() >= min)
        {
            // actual val
            return stk.peek();
        }
        
        int actualVal = min;
        return actualVal;
    }

    int min(){
        if(stk.size() == 0){
            System.out.println("Stack underflow");
            return -1;   
        }
        
        return min;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MinStack st = new MinStack();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      } else if (str.startsWith("min")) {
        int val = st.min();
        if (val != -1) {
          System.out.println(val);
        }
      }
      str = br.readLine();
    }
  }
}

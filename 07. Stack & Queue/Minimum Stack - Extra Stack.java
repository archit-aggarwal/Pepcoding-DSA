import java.io.*;
import java.util.*;

public class Main {

  public static class MinStack {
    Stack<Integer> stk;
    Stack<Integer> min;

    public MinStack() {
      stk = new Stack<>();
      min = new Stack<>();
    }


    int size() {
        return stk.size();
    }

    void push(int val) {
        
        stk.push(val);
        
        if(min.isEmpty() || min.peek() >= val)
            min.push(val);
        
    }

    int pop() {
        if(stk.size() == 0){
            System.out.println("Stack underflow");
            return -1;   
        }
        
        int ele = stk.pop(); 
        
        if(ele == min.peek())
            min.pop();
            
        return ele;
    }

    int top() {
        if(stk.size() == 0){
            System.out.println("Stack underflow");
            return -1;   
        }
        return stk.peek();
    }

    int min(){
        if(stk.size() == 0){
            System.out.println("Stack underflow");
            return -1;   
        }
        
        return min.peek();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MinStack st = new MinStack();

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("push")){
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if(str.startsWith("pop")){
        int val = st.pop();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("top")){
        int val = st.top();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("size")){
        System.out.println(st.size());
      } else if(str.startsWith("min")){
        int val = st.min();
        if(val != -1){
          System.out.println(val);
        }
      }
      str = br.readLine();
    }
  }
}

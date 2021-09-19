import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    Stack<Character> stk = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);


      if (ch == '[' || ch == '{' || ch == '(') {
        stk.push(ch);
      } else if (ch == ']') {

        if (stk.isEmpty() == true || stk.peek() != '[')
        {
          System.out.println(false);
          return;
        }
        
        stk.pop();
        
      } else if (ch == ')') {
        if (stk.isEmpty() == true || stk.peek() != '(')
        {
          System.out.println(false);
          return;
        }
        
        stk.pop();      
          
      } else if (ch == '}') {
        if (stk.isEmpty() == true || stk.peek() != '{')
        {
          System.out.println(false);
          return;
        }
        
        stk.pop();      
      }
    }
    
    if(stk.size() > 0){
        System.out.println(false);
        return;
    }
    
    System.out.println(true);
  }

}

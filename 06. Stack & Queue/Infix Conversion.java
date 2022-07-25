import java.io.*;
import java.util.*;

public class Main{
  
public static int precedence(char op){
    if(op == '+' || op == '-') return 1;
    if(op == '/' || op == '*') return 2;
    return 0;
}

public static void performOp(Stack<String> prefix, Stack<String> postfix, char op){
    
    String prev2 = prefix.pop();
    String prev1 = prefix.pop();
    
    
    String postv2 = postfix.pop();
    String postv1 = postfix.pop();
    
    
    prefix.push(op + prev1 + prev2);
    postfix.push(postv1 + postv2 + op);
}

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    
    Stack<String> prefix = new Stack<>();
    Stack<String> postfix = new Stack<>();
    Stack<Character> operator = new Stack<>();
    
    for(int i=0; i<exp.length(); i++)
    {
        char ch = exp.charAt(i);
        
        if(ch == '('){
            
            operator.push(ch);
            
        } else if(ch == ')'){
            
            while(operator.peek() != '(') {
                char op = operator.pop();
                performOp(prefix, postfix, op);
            }
            
            operator.pop();
            
        } else if(ch == '+' || ch == '-' || ch == '/' || ch == '*'){
            
            while(operator.size() > 0 && operator.peek() != '(' && precedence(operator.peek()) >= precedence(ch))
            {
                char op = operator.pop();
                performOp(prefix, postfix, op);                
            }
            
            operator.push(ch);
            
        } else {
            
            // operand
            prefix.push(ch + "");
            postfix.push(ch + "");
            
        }
    }
    
    while(operator.size() > 0) {
        char op = operator.pop();
        performOp(prefix, postfix, op);
    }
    
    System.out.println(postfix.peek());
    System.out.println(prefix.peek());
    
 }
}

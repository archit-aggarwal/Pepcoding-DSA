import java.io.*;
import java.util.*;

public class Main{
  
public static int precedence(char op){
    if(op == '+' || op == '-') return 1;
    if(op == '/' || op == '*') return 2;
    return 0;
}
public static int performOp(int val1, char op, int val2){
    if(op == '+')
        return val1 + val2;
    
    if(op == '-')
        return val1 - val2;
        
    if(op == '/')
        return val1 / val2;
        
    return val1 * val2;
}


public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    
    Stack<Character> operatorStk = new Stack<>();
    Stack<Integer> operandStk = new Stack<>();
    
    
    for(int i=0; i<exp.length(); i++)
    {
        char ch = exp.charAt(i);
        if(ch >= '0' && ch <= '9')
        {
            // operand -> Push in operand stack
            operandStk.push(ch - '0');
        }
        else
        {
            if(ch == '('){
                operatorStk.push(ch);
                
            } else if(ch == ')'){
                
                while(operatorStk.peek() != '(')
                {
                    int val2 = operandStk.pop();
                    int val1 = operandStk.pop();
                    char op = operatorStk.pop();
                    int res = performOp(val1, op, val2);
                    operandStk.push(res);
                }
                
                operatorStk.pop(); // ( pop
                
            } else if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                
                
                while(operatorStk.size() > 0 && operatorStk.peek() != '(' && precedence(operatorStk.peek()) >= precedence(ch))
                {
                    int val2 = operandStk.pop();
                    int val1 = operandStk.pop();
                    char op = operatorStk.pop();
                    int res = performOp(val1, op, val2);
                    operandStk.push(res);                    
                }
                
                operatorStk.push(ch);
            }
        }
    }
    
    // perform operations remaining in stack after traversal
    while(operatorStk.size() > 0)
    {
        int val2 = operandStk.pop();
        int val1 = operandStk.pop();
        char op = operatorStk.pop();
        int res = performOp(val1, op, val2);
        operandStk.push(res);
    }
    
    // our answer is the only element present in operand
    System.out.println(operandStk.peek());
 }
}

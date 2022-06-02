import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        Stack<Character> stk = new Stack<>();
        
        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            
            if(ch == ')'){
                
                int count = 0;
                while(stk.peek() != '(')
                {
                    count++;
                    stk.pop();
                }
                stk.pop(); // opening ( pop
                
                
                if(count == 0){
                    System.out.println(true);
                    return;
                }
                
            } else {
                stk.push(ch);
            }
        }
        
        System.out.println(false);
    }

}

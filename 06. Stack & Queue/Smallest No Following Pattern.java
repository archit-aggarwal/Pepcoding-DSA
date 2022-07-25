import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    
    int maxSofar = 0;
    Stack<Integer> stk = new Stack<>();
    
    for(int i=0; i<str.length(); i++){
        maxSofar++;
        stk.push(maxSofar);
            
        if(str.charAt(i) == 'i'){
            while(!stk.isEmpty()){
                System.out.print(stk.pop());
            }
        }
    }
    
    maxSofar++;
    stk.push(maxSofar);
    while(!stk.isEmpty()){
        System.out.print(stk.pop());
    }
    
 }
}

class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stk = new Stack<>();
        StringBuilder open = new StringBuilder("(");
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == ')'){
                
                StringBuilder str = new StringBuilder("");
                while(stk.peek() != open){
                    StringBuilder top = stk.pop();
                    top.reverse();
                    str.append(top);
                }
                
                stk.pop(); // pop opening
                stk.push(str); 
                
            } else if(ch == '('){
                stk.push(open);
            } else {
                
                if(stk.size() == 0 || stk.peek() == open)
                    stk.push(new StringBuilder(ch + ""));
                
                else stk.peek().append(ch);
            }
        }
        
        StringBuilder res = new StringBuilder("");
        while(stk.size() > 0){
            StringBuilder top = stk.pop();
            top.reverse();
            res.append(top);
        }
        return res.reverse().toString();
    }
}
class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            
            if(s.charAt(i) == '('){
                stk.push(-1);
            } else {
                
                int ans = 0;
                while(stk.peek() != -1){
                    ans += stk.pop();
                }
                
                stk.pop(); // pop opening char (-1) as well
                
                if(ans == 0) stk.push(1); // push () score as 1
                else stk.push(2 * ans);
            }
        }
        
        int ans = 0;
        while(stk.size() > 0){
            ans += stk.pop();
        }
        return ans;
    }
}
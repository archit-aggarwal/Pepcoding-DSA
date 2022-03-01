class Solution {
    HashSet<String> res;
    
    public void helper(String input, String output, int open, int close, int unbalanced){
        if(input.length() == 0){
            if(open == 0 && close == 0 && unbalanced == 0)
                res.add(output);
            return;
        }
        
        char ch = input.charAt(0);
        String remInput = input.substring(1);
        
        if(ch == '('){
            
            if(open > 0)  // Delete the opening braces
                helper(remInput, output, open - 1, close, unbalanced);
            
            // Including the opening braces
            helper(remInput, output + ch, open, close, unbalanced + 1);
            
        } else if(ch == ')'){
            
            if(close > 0) // Delete the closing braces
                helper(remInput, output, open, close - 1, unbalanced);
            
            if(unbalanced > 0) // Including the closing braces
                helper(remInput, output + ch, open, close, unbalanced - 1);
            
        } else {
            helper(remInput, output + ch, open, close, unbalanced);
        }
    }
    
    public List<String> removeInvalidParentheses(String s) {
        int open = 0, close = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '(') open++;
            else if(ch == ')'){
                if(open > 0) open--;
                else close++;
            }
        }
        
        res = new HashSet<>();
        helper(s, "", open, close, 0);
        List<String> ans = new ArrayList<>();
        for(String str: res) ans.add(str);
        return ans;
    }
}
class Solution {
    public String removeOuterParentheses(String s) {
        int open = 0;
        StringBuilder res = new StringBuilder("");
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '('){
                if(open > 0) res.append(ch);
                open++;
            } else {
                open--;
                if(open > 0) res.append(ch);
            }
        }
        
        return res.toString();
    }
}
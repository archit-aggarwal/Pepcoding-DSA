class Solution {
    public int minInsertions(String s) {
        int open = 0, additions = 0;
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '('){
                open++;
            } else if(ch == ')'){
                
                if(open > 0) open--;
                else additions++; // add one opening character
                
                if(i + 1 < s.length() && s.charAt(i + 1) == ')')
                    i++;
                else additions++; // add one closing character
            }
        }
        
        return additions + 2 * open;
    }
}
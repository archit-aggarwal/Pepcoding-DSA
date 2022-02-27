class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder.equals("#") == true) 
            return true;
        
        Stack<Character> stk = new Stack<>();
        String[] tokens = preorder.split(",");
        boolean root = false;
        
        for(String token: tokens){
            if(token.equals("#") == true){
                if(stk.size() == 0) return false;
                else if(stk.peek() == 'l') {
                    stk.pop();
                    stk.push('r');
                } else {
                    stk.pop();
                }
                
            } else {
                if(stk.size() == 0){
                    if(root == false){
                        root = true;
                    } else return false;
                }
                else {
                    if(stk.peek() == 'l'){
                        stk.pop();
                        stk.push('r');
                    } else {
                        stk.pop();
                    }
                }
                
                stk.push('l');
            }
        }
        
        if(stk.size() == 0) return true; 
        return false;
    }
}
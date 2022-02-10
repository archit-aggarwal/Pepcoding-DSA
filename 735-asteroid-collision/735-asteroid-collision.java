class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        
        for(int val: asteroids){
            
            if(val < 0){
                
                boolean destroy = false;
                while(stk.size() > 0 && stk.peek() > 0){
                    if(stk.peek() < -val){
                        stk.pop();
                    } else if(stk.peek() > -val){
                        destroy = true;
                        break;
                    } else {
                        stk.pop();
                        destroy = true;
                        break;
                    }
                }
                
                if(destroy == false)
                    stk.push(val);
            }
            else stk.push(val);
        }
        
        int[] res = new int[stk.size()];
        int idx = res.length - 1;
        while(idx >= 0){
            res[idx--] = stk.pop();
        }
        return res;
    }
}
class Solution {
    long[] nsl(int[] arr){
        long[] res = new long[arr.length];
        Stack<Integer> stk = new Stack<>();
        
        for(int i=0; i<arr.length; i++){
            while(stk.size() > 0 && arr[stk.peek()] > arr[i]){
                stk.pop();
            }
            
            if(stk.size() == 0) res[i] = -1;
            else res[i] = stk.peek();
            
            stk.push(i);
        }
        
        return res;
    }
    
    long[] nsr(int[] arr){
        long[] res = new long[arr.length];
        Stack<Integer> stk = new Stack<>();
        
        for(int i=arr.length - 1; i>=0; i--){
            while(stk.size() > 0 && arr[stk.peek()] >= arr[i]){
                stk.pop();
            }
            
            if(stk.size() == 0) res[i] = arr.length;
            else res[i] = stk.peek();
            
            stk.push(i);
        }
        
        return res;
    }
    
    public int sumSubarrayMins(int[] arr) {
        long[] nsl = nsl(arr);
        long[] nsr = nsr(arr);
        
        long res = 0;
        for(int i=0; i<arr.length; i++){
            res = res + (arr[i] * (nsr[i] - i) * (i - nsl[i]));
        }
        return (int)(res % 1000000007l);
    }
}
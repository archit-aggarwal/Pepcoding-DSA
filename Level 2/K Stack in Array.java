public class NStack {
    int[] arr;
    int[] next;
    int[] top;
    int freeIdx;
    
    public NStack(int K, int N) {
        arr = new int[N];
        next = new int[N];
        for(int i=0; i<N; i++){
            next[i] = i + 1;
        }
        next[N - 1] = -1;
        
        top = new int[K];
        for(int i=0; i<K; i++){
        	top[i] = -1;    
        }
        
        freeIdx = 0;
    }

    public boolean push(int x, int m) {
        if(freeIdx == -1){
            // Stack overflow
            return false;
        }
        
        int currIdx = freeIdx;
        
        // Fill Element in array
        arr[currIdx] = x;
        
        // Update freeIdx to next Freeidx
        freeIdx = next[freeIdx];
        
        // Update Next to previous element's index of mth stack
        next[currIdx] = top[m - 1]; 
        
        // Make current element's index as top of mth stack
        top[m - 1] = currIdx;
        
        return true;
    }

    public int pop(int m) {
        if(top[m - 1] == -1){
            // Stack underflow
            return -1;
        }
        
        int currIdx = top[m - 1];
        
        // Update Top of mth Stack as Previous Element's Index
        top[m - 1] = next[currIdx];
        
        // Update Next of CurrIdx as next Free Slot
        next[currIdx] = freeIdx;
        
        // Make Current Index as Free Index
        freeIdx = currIdx;
        
        return arr[currIdx];
    }
}

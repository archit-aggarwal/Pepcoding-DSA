class Solution {
    public int[] sortArrayByParity(int[] arr) {
        int n = arr.length;
        int start = 0, end = n - 1;
        while(start < end){
            
            // Skip All the evens in left
            while(start < end && arr[start] % 2 == 0)
                start++;
                
            // Skip All the odd in right
            while(start < end && arr[end] % 2 == 1)
                end--;
                
            if(start < end){
                // Bring Even to the left and Odd to the right
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++; end--;
            }
            
        }
        
        return arr;
    }
}
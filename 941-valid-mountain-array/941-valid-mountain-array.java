class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int peaks = 0, valleys = 0, plateau = 0;
        
        for(int i=1; i<n-1; i++){
            if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1]){
                peaks++;
            }
            
            if(arr[i] == arr[i + 1] || arr[i] == arr[i - 1]){
                plateau++;
            }
            
            if(arr[i] < arr[i - 1] && arr[i] < arr[i + 1]){
                valleys++;
            }
        }
        
        if(peaks == 1 && valleys == 0 && plateau == 0) return true;
        return false;
    }
}
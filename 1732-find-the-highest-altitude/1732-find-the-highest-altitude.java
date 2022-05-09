class Solution {
    public int largestAltitude(int[] gain) {
        int height = 0;
        int maxHeight = 0; // It is Starting at altitude 0
        
        for(int i=0; i<gain.length; i++){
            height = height + gain[i];
            
            if(height > maxHeight) {
                maxHeight = height;
            }
        }
        
        return maxHeight;
    }
}
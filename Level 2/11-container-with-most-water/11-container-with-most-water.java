class Solution {
    public int maxArea(int[] arr) {
        int left = 0, right = arr.length - 1;
        int water = 0;
        
        while(left < right){
            int currWater = (right - left) * Math.min(arr[left], arr[right]);
            water = Math.max(water, currWater);
            
            if(arr[left] <= arr[right]) left++;
            else right--;
        }
        
        return water;
    }
}
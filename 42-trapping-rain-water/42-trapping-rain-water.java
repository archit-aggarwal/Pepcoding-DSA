class Solution {
//     int[] leftMax(int[] height){
//         int[] res = new int[height.length];
//         res[0] = height[0];
        
//         for(int i=1; i<height.length; i++){
//             res[i] = Math.max(height[i], res[i - 1]);
//         }
//         return res;
//     }
    
//     int[] rightMax(int[] height){
//         int[] res = new int[height.length];
//         res[height.length - 1] = height[height.length - 1];
        
//         for(int i=height.length-2; i>=0; i--){
//             res[i] = Math.max(height[i], res[i + 1]);
//         }
//         return res;
//     }
    
    public int trap(int[] arr) {
//         int[] leftMax = leftMax(height);
//         int[] rightMax = rightMax(height);
        
//         int water = 0;
//         for(int i=0; i<height.length; i++){
//             water += (Math.min(leftMax[i], rightMax[i]) - height[i]);
//         }
//         return water;
        
        int leftMax = 0, rightMax = 0;
        int left = 0, right = arr.length - 1, water = 0;
        
        while(left <= right){
            
            if(arr[left] <= arr[right]){
                if(arr[left] < leftMax) water += (leftMax - arr[left]);
                else leftMax = arr[left];
                left++;
            } else {
                if(arr[right] < rightMax) water += (rightMax - arr[right]);
                else rightMax = arr[right];
                right--;
            }   
        }
        
        return water;
    }
}
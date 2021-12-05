class Solution {
    public static int lowerBound(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        int ans = arr.length;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(arr[mid] >= target){
                ans = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return ans;
    }
    
    public static int closest(int[] arr, int target){
        int lb = lowerBound(arr, target);
        
        if(lb == arr.length) return arr[arr.length - 1]; // ceil does not exist
        else if(lb == 0) return arr[0]; // floor not exist
        
        else if(Math.abs(target - arr[lb]) < Math.abs(target - arr[lb - 1]))
            return arr[lb];
        
        else return arr[lb - 1];
    }
    
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<houses.length; i++){
            
            int closestHeater = closest(heaters, houses[i]);
            max = Math.max(max, Math.abs(closestHeater - houses[i]));
            
        }
        return max;
    }
}

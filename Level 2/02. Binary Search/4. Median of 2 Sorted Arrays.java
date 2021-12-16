class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int low = 0, high = nums1.length;
        int N = nums1.length + nums2.length;
        int Nby2 = (N + 1) / 2;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            int aleft = (mid - 1 >= 0) 
                        ? nums1[mid - 1] : Integer.MIN_VALUE;
            
            int aright = (mid < nums1.length) 
                        ? nums1[mid] : Integer.MAX_VALUE;
            
            int bleft = (Nby2 - mid - 1 >= 0) 
                        ? nums2[Nby2 - mid - 1] : Integer.MIN_VALUE; 
                
            int bright = (Nby2 - mid < nums2.length)
                        ? nums2[Nby2 - mid] : Integer.MAX_VALUE;
            
            if(aleft <= bright && bleft <= aright){
                // return median
                if(N % 2 == 1){
                    // odd elements
                    return Math.max(aleft, bleft);
                } else{
                    int[] arr = {aleft, bleft, aright, bright};
                    Arrays.sort(arr);
                    return (arr[1] + arr[2]) / 2.0;
                }
                
            }
            else if(aleft > bright){
                high = mid - 1;
            } else {
                // bleft > aright
                low = mid + 1;
            }
        }
        
        return 0.0;
    }
}
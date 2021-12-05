public int firstOcc(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        int ans = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target){
                ans = mid;
                right = mid - 1;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                // nums[mid] > target
                right = mid - 1;
            }
        }
        return ans;
    }
    
    public int lastOcc(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        int ans = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target){
                ans = mid;
                left = mid + 1;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                // nums[mid] > target
                right = mid - 1;
            }
        }
        return ans;
    }
    
    int count(int[] arr, int n, int x) {
        int first = firstOcc(arr, x);
        if(first == -1) return 0;
        int last = lastOcc(arr, x);
        return (last - first + 1);
    }

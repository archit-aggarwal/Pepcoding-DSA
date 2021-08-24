    public int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            
            if(arr[mid] == target)
            {
                // Successfull search
                return mid;
            }
            else if(arr[mid] < target)
            {
                left = mid + 1;
            }
            else // arr[mid] > target
            {
                right = mid - 1;
            }
        }
        // Unsucessfull search
        return -1;
    }

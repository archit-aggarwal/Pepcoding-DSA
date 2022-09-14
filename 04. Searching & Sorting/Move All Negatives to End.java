// Segregate Negatives and Positives by Maintaining Relative Order
// Problem Link: https://practice.geeksforgeeks.org/problems/move-all-negative-elements-to-end1813/1

class Solution {
    
    // Approach 1: O(N) Time - Two Pass Algo, O(N) Extra Space (New Array)
    public void twoPassAlgo(int[] arr){
        int[] res = new int[arr.length];
        
        int idx = 0;
        for(int val: arr){
            if(val >= 0) res[idx++] = val;
        }
        for(int val: arr){
            if(val < 0) res[idx++] = val;
        }
        
        for(idx = 0; idx < arr.length; idx++){
            arr[idx] = res[idx];
        }
    }
    
    // Approach 2: O(N ^ 2) Insertion Sort (TLE), O(1) Constant Space (Inplace)
    public void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >= 0; j--){
                if(arr[j] < 0 && arr[j + 1] >= 0){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } else break;
            }
        }
    }
    
    // Approach 3: O(N ^ 2) Partition Algo with relative order (TLE),
    // O(1) Constant Extra Space (Inplace)
    public void partitionAlgo(int[] arr){
        int left = 0;
        for(int right = 0; right < arr.length; right++){
            if(arr[right] < 0) continue;
            
            int val = arr[right];
            for(int idx = right; idx > left; idx--){
                arr[idx] = arr[idx - 1];
            }
            arr[left] = val;
            left++;
        }
    }
    
    // Approach 4: O(N log N) Merge Sort, O(log N) Recursive Stack Space
    public void reverse(int arr[], int l, int r)
    {
        while(l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++; r--;
        }
    }
    
    public void merge(int[] arr, int l, int r){
        int m = l + (r - l) / 2;
        
        int p1 = l, p2 = m + 1;
        while(p1 <= m && arr[p1] >= 0) p1++;
        while(p2 <= r && arr[p2] >= 0) p2++;
        
        reverse(arr, p1, m);
        reverse(arr, m + 1, p2 - 1);
        reverse(arr, p1, p2 - 1);
    }
    
    public void mergeSort(int[] arr, int l, int r){
        if(l >= r) return;
        int m = l + (r - l) / 2;
        
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, r);
    }
    
    public void segregateElements(int arr[], int n)
    {
        // twoPassAlgo(arr);
        // insertionSort(arr);
        // partitionAlgo(arr);
        mergeSort(arr, 0, n - 1);
    }
}

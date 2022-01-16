class Solution {
    public:
        int getPairsCount(int arr[], int n, int k) {
            Arrays.sort(nums);
            int count = 0;
            int left = 0, right = nums.length - 1;
            while(left < right){
                if(nums[left] + nums[right] == k){
                    count++; left++; right--;
                } else if(nums[left] + nums[right] < k){
                    left++;
                } else {
                    right--;
                }
            }
            return count;
        }
};
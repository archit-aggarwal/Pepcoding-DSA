class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int prefSum = 0;
        freq.put(0, 1);
        
        int res = 0;
        for(int i=0; i<nums.length; i++){
            prefSum += nums[i];
            res += freq.getOrDefault(prefSum - k, 0);
            freq.put(prefSum, freq.getOrDefault(prefSum, 0) + 1);
        }
        
        return res;
    }
}
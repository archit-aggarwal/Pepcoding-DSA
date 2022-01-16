class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0, countOfZeros = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0)
                countOfZeros++;
            while (countOfZeros > k) {
                if (nums[left] == 0)
                    countOfZeros--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
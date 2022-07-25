// LC 152: https://leetcode.com/problems/maximum-product-subarray/

class Solution {
    // Time - O(N), Space - O(1)

    public int maxProduct(int[] nums) {
        int maxProd = 1;
        int minProd = 1;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int newMax = Math.max(nums[i], Math.max(maxProd * nums[i], minProd * nums[i]));
            int newMin = Math.min(nums[i], Math.min(maxProd * nums[i], minProd * nums[i]));

            maxProd = newMax;
            minProd = newMin;
            ans = Math.max(ans, maxProd);
        }

        return ans;
    }
}
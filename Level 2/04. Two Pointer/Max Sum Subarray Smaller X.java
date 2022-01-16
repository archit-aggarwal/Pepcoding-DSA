class Solution {
    long findMaxSubarraySum(long[] arr, int N, int X) {
        int left = 0;
        long maxSum = 0, sum = 0;

        for (int right = 0; right < N; right++) {
            sum += arr[right];

            while (sum > X) {
                // invalid
                sum -= arr[left];
                left++;
            }

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
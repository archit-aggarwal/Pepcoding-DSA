class Solution {
    static int maximumSumSubarray(int win, ArrayList<Integer> arr, int N) {
        int currSum = 0;
        for (int i = 0; i < win; i++) {
            currSum += arr.get(i);
        }

        int maxSum = currSum;
        for (int i = win; i < N; i++) {
            int inc = arr.get(i);
            int exc = arr.get(i - win);
            currSum = currSum + inc - exc;

            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
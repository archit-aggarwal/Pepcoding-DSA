// GfG: https://practice.geeksforgeeks.org/problems/maximum-sum-rectangle2948/1

class Solution {
    public int kadane(int[] arr) {
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            currSum = Math.max(currSum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    // Time - O(N * N * M) => 2D Kadane
    // Space - O(N) for Prefix Sum Array
    int maximumSumRectangle(int R, int C, int mat[][]) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < R; i++) {
            int[] pref = new int[C];
            for (int j = i; j < R; j++) {
                for (int c = 0; c < C; c++) {
                    pref[c] += mat[j][c];
                }
                maxSum = Math.max(maxSum, kadane(pref));
            }

        }

        return maxSum;
    }
}
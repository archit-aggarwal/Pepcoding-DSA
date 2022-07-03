// GfG: https://practice.geeksforgeeks.org/problems/brackets-in-matrix-chain-multiplication1024/1

class Solution {
    // Time - O(N ^ 2) DP + O(N) Backtracking, Space - O(N ^ 2) DP
    static String backtrack(int l, int r, int[] nums, int[][] dp) {
        if (l == r)
            return ("" + (char) ('A' + l));

        for (int k = l; k < r; k++) {
            int cost = dp[l][k] + (nums[l] * nums[k + 1] * nums[r + 1]) + dp[k + 1][r];
            if (cost == dp[l][r]) {
                return '(' + backtrack(l, k, nums, dp) + backtrack(k + 1, r, nums, dp) + ')';
            }
        }

        return "";
    }

    static String matrixChainOrder(int nums[], int N) {
        int[][] dp = new int[N][N];

        for (int gap = 1; gap < N - 1; gap++) {
            for (int l = 0, r = gap; r < N - 1; l++, r++) {

                int minCost = Integer.MAX_VALUE;
                for (int k = l; k < r; k++) {
                    int cost = dp[l][k] + (nums[l] * nums[k + 1] * nums[r + 1]) + dp[k + 1][r];
                    minCost = Math.min(minCost, cost);
                }

                dp[l][r] = minCost;
            }
        }

        return backtrack(0, N - 2, nums, dp);
    }
}
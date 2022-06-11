// GfG:
// https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1

class Recursion {
    // Recursion: Time - Exponential, Space - O(N) Recursion Call Stack Space
    static int helper(int l, int r, int[] nums) {
        if (l == r)
            return 0; // Single Matrix -> Multiplication Cost = 0

        int minCost = Integer.MAX_VALUE;
        // Creating partitions
        for (int k = l; k < r; k++) {
            // Left Matrices -> Multiplication Min Cost
            int left = helper(l, k, nums);
            // Right Matrices -> Multiplication Min Cost
            int right = helper(k + 1, r, nums);
            // Left * Right Multiplication Cost
            int cost = left + (nums[l] * nums[k + 1] * nums[r + 1]) + right;
            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }

    static int matrixMultiplication(int N, int nums[]) {
        return helper(0, N - 2, nums);
    }
}

class Memoization {
    // Time - O(N * N * N) = O(N ^ 3) Cubic, Space - O(N * N) => 2D DP
    static int helper(int l, int r, int[] nums, int[][] dp) {
        if (l == r)
            return 0; // Single Matrix -> Multiplication Cost = 0
        if (dp[l][r] != -1)
            return dp[l][r];

        int minCost = Integer.MAX_VALUE;
        // Creating partitions
        for (int k = l; k < r; k++) {
            // Left Matrices -> Multiplication Min Cost
            int left = helper(l, k, nums, dp);
            // Right Matrices -> Multiplication Min Cost
            int right = helper(k + 1, r, nums, dp);
            // Left * Right Multiplication Cost
            int cost = left + (nums[l] * nums[k + 1] * nums[r + 1]) + right;
            minCost = Math.min(minCost, cost);
        }

        return dp[l][r] = minCost;
    }

    static int matrixMultiplication(int N, int nums[]) {
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++)
            for (int j = 0; j <= N; j++)
                dp[i][j] = -1;

        return helper(0, N - 2, nums, dp);
    }
}
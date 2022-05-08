// GfG Perfect Sum: https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1

class Solution {
    public int memo(int index, int target, int[] arr, int[][] dp) {
        if (target < 0)
            return 0;
        if (index == arr.length) {
            if (target == 0)
                return 1;
            return 0;
        }
        if (dp[index][target] != -1)
            return dp[index][target];

        int no = memo(index + 1, target, arr, dp);
        int yes = memo(index + 1, target - arr[index], arr, dp);
        return dp[index][target] = (no + yes) % 1000000007;
    }

    public int perfectSum(int arr[], int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = -1;
            }
        }
        return memo(0, sum, arr, dp);
    }
}
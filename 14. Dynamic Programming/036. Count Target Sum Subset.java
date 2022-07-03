// Count Target Sum Subset
// GfG Perfect Sum: https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1

class Memoization {
    // Time - O(N * Target), Space - O(N * Target)
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

class Tabulation {
    // Tabulation - O(N * Target) Time, O(N * Target) Space
    public int perfectSum(int arr[], int n, int target) {
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1; // Empty Subset to form 0 Target

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                int no = dp[i - 1][j]; // No Call
                int yes = (j >= arr[i - 1]) ? dp[i - 1][j - arr[i - 1]] : 0;

                dp[i][j] = (no + yes) % 1000000007;
            }
        }

        return dp[n][target];
    }
}

class SpaceOptimization {
    // Time - O(N * Target), Space - O(Target)
    public int perfectSum(int arr[], int n, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // Empty Subset to form 0 Target

        for (int i = 1; i <= n; i++) {
            int[] newdp = new int[target + 1];

            for (int j = 0; j <= target; j++) {
                int no = dp[j]; // No Call
                int yes = (j >= arr[i - 1]) ? dp[j - arr[i - 1]] : 0;

                newdp[j] = (no + yes) % 1000000007;
            }

            dp = newdp;
        }

        return dp[target];
    }
}

// Check Target Sum Subset
// InterviewBit: https://www.interviewbit.com/problems/subset-sum-problem/

class CheckTargetSumSubset {
    // Time - O(N * Target), Space Optimized Tabulation - O(Target)
    public int solve(int[] arr, int target) {
        int n = arr.length;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Empty Subset to form 0 Target

        for (int i = 1; i <= n; i++) {
            boolean[] newdp = new boolean[target + 1];

            for (int j = 0; j <= target; j++) {
                boolean no = dp[j]; // No Call
                boolean yes = (j >= arr[i - 1]) ? dp[j - arr[i - 1]] : false;

                newdp[j] = no || yes;
            }

            dp = newdp;
        }

        return (dp[target] == true) ? 1 : 0;
    }
}

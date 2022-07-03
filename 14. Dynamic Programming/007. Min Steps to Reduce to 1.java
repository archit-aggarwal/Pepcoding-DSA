import java.util.*;

// GfG: https://practice.geeksforgeeks.org/problems/minimum-steps-to-minimize-n-as-per-given-condition0618/1/

class Solution {
    // O(N) Time, O(N) Space
    public int memo(int N, int[] dp) {
        if (N == 1)
            return 0;
        if (dp[N] != -1)
            return dp[N];

        int ans1 = (N % 2 == 0) ? memo(N / 2, dp) : Integer.MAX_VALUE;
        int ans2 = (N % 3 == 0) ? memo(N / 3, dp) : Integer.MAX_VALUE;
        int ans3 = memo(N - 1, dp);

        return dp[N] = Math.min(ans1, Math.min(ans2, ans3)) + 1;
    }

    public int minSteps(int N) {
        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);

        return memo(N, dp);
    }
}
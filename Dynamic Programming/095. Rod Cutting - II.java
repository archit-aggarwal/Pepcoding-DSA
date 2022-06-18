// LC 1547: https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
// Time - O(N ^ 3), Space - O(N ^ 2)

import java.util.*;

class Solution {
    public int minCost(int ss, int se, int[] arr, int l, int r, int[][] dp) {
        if (l > r)
            return 0; // No Partitions
        if (dp[l][r] != -1)
            return dp[l][r];

        int minCost = Integer.MAX_VALUE;
        // Partitions
        for (int k = l; k <= r; k++) {
            int left = minCost(ss, arr[k], arr, l, k - 1, dp);
            int right = minCost(arr[k], se, arr, k + 1, r, dp);
            int cost = left + (se - ss) + right;
            minCost = Math.min(minCost, cost);
        }

        return dp[l][r] = minCost;
    }

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);

        int[][] dp = new int[cuts.length + 1][cuts.length + 1];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;

        return minCost(0, n, cuts, 0, cuts.length - 1, dp);
    }
}
// 115: https://leetcode.com/problems/distinct-subsequences/

// Time - O(N * M), Space - O(N * M) 2D DP
// Tabulation and Space Optimization to 1D Dp is also possible

class Solution {
    public int memo(int i, int j, String s1, String s2, int[][] dp) {
        if (j == s2.length())
            return 1; // Required String (s2) is completely found
        if (i == s1.length())
            return 0; // Required is still left, actual string is empty

        if (dp[i][j] != -1)
            return dp[i][j];

        char actual = s1.charAt(i);
        char required = s2.charAt(j);

        if (actual == required) // both yes and no calls
            return dp[i][j] = (memo(i + 1, j + 1, s1, s2, dp)
                    + memo(i + 1, j, s1, s2, dp));

        // if actual != required, only no call
        return dp[i][j] = memo(i + 1, j, s1, s2, dp);
    }

    public int numDistinct(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;

        return memo(0, 0, s1, s2, dp);
    }
}
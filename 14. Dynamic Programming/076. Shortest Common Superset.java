class Solution {
    // 1092: https://leetcode.com/problems/shortest-common-supersequence/
    // Time - O(N * M + N + M), Space - O(N * M) 2D DP

    String scs = "";

    public void backtrack(int i, int j, String s1, String s2, int[][] dp, String ans) {
        if (i == s1.length() && j == s2.length()) {
            scs = ans;
            return;
        }

        char ch1 = (i < s1.length()) ? s1.charAt(i) : 'A';
        char ch2 = (j < s2.length()) ? s2.charAt(j) : 'B';

        if (ch1 == ch2) {
            // Yes - Diagonal
            backtrack(i + 1, j + 1, s1, s2, dp, ans + ch1);
        } else if (i + 1 <= s1.length() && dp[i][j] == dp[i + 1][j]) {
            // No - Down
            backtrack(i + 1, j, s1, s2, dp, ans + ch1);
        } else {
            // No - Right
            backtrack(i, j + 1, s1, s2, dp, ans + ch2);
        }
    }

    public String shortestCommonSupersequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(j);

                if (ch1 == ch2)
                    dp[i][j] = 1 + dp[i + 1][j + 1];

                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        // If Length of SCS was asked, SCS = N + M - LCS
        backtrack(0, 0, s1, s2, dp, "");
        return scs;
    }
}
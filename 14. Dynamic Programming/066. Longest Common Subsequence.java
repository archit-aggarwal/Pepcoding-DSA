// 1143: https://leetcode.com/problems/longest-common-subsequence/

class Memoization {
    // Time - O(N * M), Space - O(N * M) - 2D DP
    public int LCS(int i, int j, String s1, String s2, int[][] dp) {
        if (i == s1.length() || j == s2.length())
            return 0; // LCS of Empty String with Other String is Empty String only

        if (dp[i][j] != -1)
            return dp[i][j];

        char ch1 = s1.charAt(i);
        char ch2 = s2.charAt(j);

        if (ch1 == ch2) // If characters are same, take the common from both of them
            return dp[i][j] = 1 + LCS(i + 1, j + 1, s1, s2, dp);

        // If character is uncommon, either not take s1[i] or not take s2[j]
        int option1 = LCS(i + 1, j, s1, s2, dp);
        int option2 = LCS(i, j + 1, s1, s2, dp);
        return dp[i][j] = 0 + Math.max(option1, option2);
    }

    public int longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return LCS(0, 0, s1, s2, dp);
    }

}

class Tabulation {
    // Time - O(N * M), Space - O(N * M) 2D DP
    public int longestCommonSubsequence(String s1, String s2) {
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

        return dp[0][0];
    }
}

class SpaceOptimization {
    // Time - O(N * M), Space - O(M) 1D DP
    public int longestCommonSubsequence(String s1, String s2) {
        int[] next = new int[s2.length() + 1];

        for (int i = s1.length() - 1; i >= 0; i--) {
            int[] curr = new int[s2.length() + 1];

            for (int j = s2.length() - 1; j >= 0; j--) {
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(j);

                if (ch1 == ch2)
                    curr[j] = 1 + next[j + 1];

                else
                    curr[j] = Math.max(next[j], curr[j + 1]);
            }

            next = curr;
        }

        return next[0];
    }
}
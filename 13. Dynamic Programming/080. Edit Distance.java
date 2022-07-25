// LC 72: https://leetcode.com/problems/edit-distance/
// Time - O(N * M), Space - O(N * M)

class Solution {
    public int memo(int i, int j, String s1, String s2, int[][] dp) {
        if (i == s1.length() && j == s2.length())
            return 0;
        if (i == s1.length())
            return s2.length() - j; // First String Empty, Insert All to make Second
        if (j == s2.length())
            return s1.length() - i; // Second String Empty, Delete All Char in First

        if (dp[i][j] != -1)
            return dp[i][j];

        char ch1 = s1.charAt(i);
        char ch2 = s2.charAt(j);

        if (ch1 == ch2)
            return dp[i][j] = memo(i + 1, j + 1, s1, s2, dp);
        // no operation, since char is same

        int delete = memo(i + 1, j, s1, s2, dp);
        int insert = memo(i, j + 1, s1, s2, dp);
        int replace = memo(i + 1, j + 1, s1, s2, dp);
        return dp[i][j] = 1 + Math.min(delete, Math.min(insert, replace));
    }

    public int minDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return memo(0, 0, s1, s2, dp);
    }
}
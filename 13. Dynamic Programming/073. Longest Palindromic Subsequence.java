// 516: https://leetcode.com/problems/longest-palindromic-subsequence/

class Solution {

    public int LCS(String s1, String s2) {
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

    // LPS = LCS(string, reversed string)
    // Time - O(N * N), Space - O(N * N)
    public int longestPalindromeSubseq(String s) {
        StringBuilder rev = new StringBuilder(s);
        rev = rev.reverse();
        String s2 = new String(rev);

        return LCS(s, s2);
    }
}
// GfG: https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1

class Solution {
    // Time - O(N * M), Space - O(N * M)
    public int minOperations(String s1, String s2) {
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

        int lcs = dp[0][0];
        int deletions = (s1.length() - lcs);
        int insertions = (s2.length() - lcs);
        return deletions + insertions;
    }
}
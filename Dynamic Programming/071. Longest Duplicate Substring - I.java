// 1044: https://leetcode.com/problems/longest-duplicate-substring/

class Solution {
    // Time - O(N * N), Space - O(N * N)
    // TLE on Leetcode (Required - Rolling Hash)

    public String longestDupSubstring(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];

        int idx = s.length(), len = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = s.length() - 1; j >= 0; j--) {
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(j);

                if (ch1 == ch2 && i != j)
                    dp[i][j] = 1 + dp[i + 1][j + 1];

                if (dp[i][j] > len) {
                    idx = i;
                    len = dp[i][j];
                }

                // else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        return s.substring(idx, idx + len);
    }
}
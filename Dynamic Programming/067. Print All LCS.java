import java.util.*;

// GfG: https://practice.geeksforgeeks.org/problems/print-all-lcs-sequences3413/1/

class Solution {
    TreeSet<String> answers; // Both Ordered (Lexicographical Order), Unique

    public void helper(int i, int j, String s1, String s2, int[][] dp, String lcs) {
        if (i == s1.length() || j == s2.length()) {
            answers.add(lcs);
            return;
        }

        char ch1 = s1.charAt(i);
        char ch2 = s2.charAt(j);

        if (ch1 == ch2) {
            // Character Taken (Same)
            helper(i + 1, j + 1, s1, s2, dp, lcs + ch1);
        } else {
            // Character Not Taken
            if (dp[i][j] == dp[i + 1][j]) {
                helper(i + 1, j, s1, s2, dp, lcs);
            }

            if (dp[i][j] == dp[i][j + 1]) {
                helper(i, j + 1, s1, s2, dp, lcs);
            }
        }
    }

    public List<String> all_longest_common_subsequences(String s1, String s2) {
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

        answers = new TreeSet<>();
        helper(0, 0, s1, s2, dp, "");
        List<String> res = new ArrayList<>();
        for (String str : answers) {
            res.add(str);
        }
        return res;
    }
}
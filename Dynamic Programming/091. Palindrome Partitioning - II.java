// LC 132: https://leetcode.com/problems/palindrome-partitioning-ii/

import java.util.*;

class Solution {
    // Time - O(N ^ 2), Space - O(N) 1D DP
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    public int helper(String s, int i, int[] dp) {
        if (i == s.length())
            return 0;
        if (dp[i] != -1)
            return dp[i];
        if (isPalindrome(s.substring(i)))
            return dp[i] = 0;

        int minCuts = Integer.MAX_VALUE;
        for (int j = i; j < s.length(); j++) {
            String left = s.substring(i, j + 1);
            if (isPalindrome(left) == true) {
                int cuts = helper(s, j + 1, dp);
                minCuts = Math.min(minCuts, cuts + 1);
            }
        }

        return dp[i] = minCuts;
    }

    public int minCut(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return helper(s, 0, dp);
    }
}
// LC: 139: https://leetcode.com/problems/word-break/

import java.util.*;

// Time - O(N ^ 2), Space - O(N) 1D DP + Recursion Call Stack + Hashmap
class Solution {
    HashSet<String> dict;

    public int wordBreak(int i, String s, int[] dp) {
        if (i == s.length())
            return 1;
        if (dp[i] != -1)
            return dp[i];

        for (int j = i; j < s.length(); j++) {
            String prefix = s.substring(i, j + 1);
            if (dict.contains(prefix) == true && wordBreak(j + 1, s, dp) == 1)
                return dp[i] = 1;
        }

        return dp[i] = 0;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>();
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);

        for (String str : wordDict)
            dict.add(str);

        return (wordBreak(0, s, dp) == 1) ? true : false;
    }
}
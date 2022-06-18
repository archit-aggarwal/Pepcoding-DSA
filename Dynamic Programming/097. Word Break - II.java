
// LC 40: https://leetcode.com/problems/word-break-ii/
import java.util.*;

// Time - O(Exponential) - Recursion
// Space - O(N) Recursion Call Stack + Hashmap

class Solution {
    HashSet<String> dict;
    List<String> res;

    public void wordBreak(int i, String s, String curr) {
        if (i == s.length()) {
            res.add(curr.substring(0, curr.length() - 1));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            String prefix = s.substring(i, j + 1);
            if (dict.contains(prefix) == true)
                wordBreak(j + 1, s, curr + prefix + " ");
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>();
        for (String str : wordDict)
            dict.add(str);

        res = new ArrayList<>();
        wordBreak(0, s, "");
        return res;
    }
}
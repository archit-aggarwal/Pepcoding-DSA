// LC 131: https://leetcode.com/problems/palindrome-partitioning/

import java.util.*;

class Solution {
    List<List<String>> res;

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

    public void helper(String s, int i, List<String> partitions) {
        if (i == s.length()) {
            res.add(new ArrayList<>(partitions));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            String left = s.substring(i, j + 1);
            if (isPalindrome(left) == true) {
                partitions.add(left);
                helper(s, j + 1, partitions);
                partitions.remove(partitions.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        List<String> partitions = new ArrayList<>();
        helper(s, 0, partitions);
        System.out.println(partitions.size());
        return res;
    }
}
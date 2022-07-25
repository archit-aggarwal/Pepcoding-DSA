// leetcode 5: https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
    // Time - O(N * N), Space - O(1)
    // Expand Around Center

    public String longestPalindrome(String s) {
        if (s.length() <= 1)
            return s;

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // Odd Length Palindromes
            int left = i - 1, right = i + 1, len = 1;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    len = len + 2;
                    left--;
                    right++;
                } else {
                    break;
                }
            }

            if (len > res.length()) {
                res = s.substring(left + 1, left + 1 + len);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            // Even Length Palindromes
            if (i + 1 == s.length() || s.charAt(i) != s.charAt(i + 1)) {
                continue;
            }

            int left = i - 1, right = i + 2, len = 2;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    len = len + 2;
                    left--;
                    right++;
                } else
                    break;
            }

            if (len > res.length()) {
                res = s.substring(left + 1, left + 1 + len);
            }
        }

        return res;
    }
}
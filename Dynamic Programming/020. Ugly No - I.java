// 263. Ugly No - I: https://leetcode.com/problems/ugly-number/

class Solution {
    // Time - O(Root N) in Worst Case, O(log2 N + log3 N + log4N) in Average Case
    public boolean isUgly(int n) {
        if (n <= 0)
            return false;

        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }

        if (n == 1)
            return true;
        return false;
    }
}
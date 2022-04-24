import java.io.*;
import java.util.*;

// Fibonacci Variation (GFG): https://practice.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1

// Memoization -> O(2*N) = O(N) Time, O(2*N) = O(N) Space
class Memoization {
    int mod = 1000000007;

    long memo(int noOfDigits, int prevDigit, long[][] dp) {
        if (noOfDigits == 0)
            return 1; // Empty String
        if (dp[noOfDigits][prevDigit] != 0)
            return dp[noOfDigits][prevDigit];

        long appending0 = memo(noOfDigits - 1, 0, dp);
        long appending1 = (prevDigit == 0) ? memo(noOfDigits - 1, 1, dp) : 0l;
        return dp[noOfDigits][prevDigit] = (appending0 + appending1) % mod;
    }

    long countStrings(int n) {
        long[][] dp = new long[n + 1][2];
        return memo(n, 0, dp);
    }
}

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // Count Binary Strings - Tabulation
        // O(n) Time, O(n) Space
        int[] endWith0 = new int[n + 1];
        int[] endWith1 = new int[n + 1];
        endWith0[1] = endWith1[1] = 1;

        for (int i = 2; i <= n; i++) {
            endWith0[i] = endWith1[i - 1];
            endWith1[i] = endWith0[i - 1] + endWith1[i - 1];
        }

        System.out.println(endWith0[n] + endWith1[n]);

        // Count Binary Strings - Tabulation (Two Pointer Space Optimization)
        // O(n) Time, O(1) Space
        int prev0 = 1, prev1 = 1;
        for (int i = 2; i <= n; i++) {
            int curr0 = prev1;
            int curr1 = prev0 + prev1;
            prev0 = curr0;
            prev1 = curr1;
        }

        System.out.println(prev0 + prev1);

        // Count Binary Strings - Recursion
        Pair ans = helper(n);
        System.out.println(ans.endWith0 + ans.endWith1);
    }

    static class Pair {
        int endWith0 = 0;
        int endWith1 = 0;

        Pair(int x, int y) {
            endWith0 = x;
            endWith1 = y;
        }
    }

    // Recursion -> O(N) Time (Linear Calls), O(N) Recursion Call Stack Space
    public static Pair helper(int n) {
        if (n == 0)
            return new Pair(0, 0);
        if (n == 1)
            return new Pair(1, 1);

        Pair smallProb = helper(n - 1);
        int prev0 = smallProb.endWith0;
        int prev1 = smallProb.endWith1;

        int curr0 = prev1;
        int curr1 = prev0 + prev1;
        return new Pair(curr0, curr1);
    }
}

// Arrange Building Follow Up:
// https://practice.geeksforgeeks.org/problems/count-possible-ways-to-construct-buildings5007/1

class ArrangeBuildings {
    // O(N) Time, O(1) Space
    public long TotalWays(int n) {
        if (n == 1)
            return 4l;
        if (n == 2)
            return 9l;
        long a = 2l, b = 3l, c = 0l;
        for (int i = 3; i <= n; i++) {
            c = (a + b) % 1000000007l;
            a = b;
            b = c;
        }
        return (c * c) % 1000000007l;
    }
};
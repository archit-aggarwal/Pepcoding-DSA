import java.util.*;

// Leetcode 509 - https://leetcode.com/problems/fibonacci-number/

// Variation - Climb Stairs with 2 Moves - 
// Leetcode 70 - https://leetcode.com/problems/climbing-stairs/

// Recursion
// Time - O(2^N), Space - O(N)
class Fibonacci1 {
    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int prev1 = fib(n - 1);
        int prev2 = fib(n - 2);

        return prev1 + prev2;
    }
}

// Memoization
// Time - O(N), Space - O(N)
class Fibonacci2 {
    public int fib(int n, int[] dp) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        // Already Calculated Value should be returned

        int prev1 = fib(n - 1, dp);
        int prev2 = fib(n - 2, dp);

        dp[n] = prev1 + prev2;
        // Before returning the calculated value, store it somewhere
        return prev1 + prev2;
    }

    public int fib(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return fib(n, dp);
    }
}

// Tabulation
// Time - O(N), Space - O(N)
class Fibonacci3 {
    public int fib(int n) {
        if (n <= 1)
            return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

// Two Pointer Space Optimization
// Time - O(N), Space - O(1)
class Fibonacci4 {
    public int fib(int n) {
        if (n <= 1)
            return n;

        int prev1 = 0, prev2 = 1;

        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }

        return prev2;
    }
}
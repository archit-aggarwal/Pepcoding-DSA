import java.util.*;
// Nth Catalan Number

// - Recursion
class Recursion {
    // Time - O(N ^ N) = Exponential,
    // Space - O(N) 1D DP + Recursion Call Stack
    public int catalan(int n) {
        if (n == 0 || n == 1)
            return 1;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans + catalan(i) * catalan(n - 1 - i);
        }
        return ans;
    }

    public int numTrees(int n) {
        return catalan(n);
    }
}

// - Memoization
class Memoization {
    // Time - O(N * N) = Quadratic,
    // Space - O(N) 1D DP + Recursion Call Stack
    public int catalan(int n, int[] dp) {
        if (n == 0 || n == 1)
            return 1;
        if (dp[n] != -1)
            return dp[n];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans + catalan(i, dp) * catalan(n - 1 - i, dp);
        }

        return dp[n] = ans;
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return catalan(n, dp);
    }
}

// - Tabulation
class Tabulation {
    // Time - O(N * N) = Quadratic,
    // Space - O(N) 1D DP
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j] * dp[i - j - 1];
        return dp[n];
    }
}

// - Binomial Coefficient Formula
// Nth Catalan = 2N(C)N / (n + 1)

class BinomialCoeff {
    // Time - O(N), Space - O(1)
    long ncr(int n, int k) // Function to calculate Ci(n.k)
    {
        long res = 1;
        if (k > n - k)
            k = n - k;
        // Since Ci(n,k) = Ci(n,n-k), property of binomial coefficients

        for (int i = 0; i < k; i++) {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }

    int numTrees(int n) {
        return (int) (ncr(2 * n, n) / (n + 1));
    }
}

// Applications
// https://www.geeksforgeeks.org/applications-of-catalan-numbers/

// 1) Count Unique BST
// Answer(n) = Catalan(n)
// LC 96: https://leetcode.com/problems/unique-binary-search-trees/

// 2) Count Balanced Parentheses
// Answer(n) = Catalan(n)
// NADOS: https://nados.io/question/count-brackets?zen=true

// 3) Count Mountain Ranges
// Answer(n) = Catalan(n)
// NADOS: https://nados.io/question/count-of-valleys-and-mountains?zen=true

// 4) Count Dyk Paths (Paths in Lower Left or Upper Right Triangle)
// Answer(n) = Catalan(n - 1)
// GfG: https://practice.geeksforgeeks.org/problems/dyck-path1028/1

// 5) Count Dyk Words
// Answer(n) = Catalan(n)
// GfG: https://www.geeksforgeeks.org/dyck-words-of-given-length/

// 6) Count Ways of Triangulation
// Answer(n) = Catalan(n - 2)
// NADOS: https://nados.io/question/number-of-ways-of-triangulation?zen=true

// 7) Count Non-Intersecting Chords in Circle
// Answer(n) = Catalan(n / 2)
// InterviewBit:
// https://www.interviewbit.com/problems/intersecting-chords-in-a-circle/

// 8) Count Non-Crossing Handshakes in Circular Table
// Answer(n) = Catalan(n / 2)
// GfG: https://practice.geeksforgeeks.org/problems/handshakes1303/1
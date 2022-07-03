import java.util.*;

// GfG: https://practice.geeksforgeeks.org/problems/friends-pairing-problem5425/1

class Solution {
    public int mod = 1000000007;

    // Time - O(N), Space - O(N) for Recursion Call Stack
    
    public long countFriendsPairing(int n, long[] dp) {
        if (n == 0 || n == 1)
            return 1l;
        if (dp[n] != -1)
            return dp[n];

        long single = countFriendsPairing(n - 1, dp);
        long pair = ((n - 1l) * countFriendsPairing(n - 2, dp)) % mod;

        return dp[n] = (single + pair) % mod;
    }

    public long countFriendsPairings(int n) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        return countFriendsPairing(n, dp);
    }

    // Space Optimization in Tabulation is Possible
    // O(N) Time, O(1) Space - Do It Yourself
}
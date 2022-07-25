import java.util.*;

// 55. https://leetcode.com/problems/jump-game/

class DP {
    // Top Down Dynamic Programming (Memoization)
    // Time = O(N * Jumps) = O(N ^ 2) -> Time Limit Exceeded
    // Space -> O(N)
    public long memo(int src, int[] jumps, long[] dp) {
        if (src == jumps.length - 1)
            return 0; // min moves to go to dest from dest is 0 (empty string)
        if (dp[src] != -1)
            return dp[src];

        long min = Integer.MAX_VALUE;
        for (int jump = 1; jump <= jumps[src]; jump++) {
            if (src + jump < jumps.length) {
                min = Math.min(min, memo(src + jump, jumps, dp) + 1l);
            }
        }

        dp[src] = min;
        return min;
    }

    public boolean canJump(int[] jumps) {
        long[] dp = new long[jumps.length + 1];
        Arrays.fill(dp, -1);

        return ((int) memo(0, jumps, dp) == Integer.MAX_VALUE)
                ? false
                : true;
    }
}

class Greedy {
    // Greedy Solution -> O(N) Time, O(1) Space
    public boolean canJump(int[] jumps) {
        int reach = 0;
        for (int i = 0; i < jumps.length; i++) {
            if (i > reach)
                return false;

            if (i + jumps[i] > reach) {
                reach = i + jumps[i];
            }
        }

        return true;
    }
}
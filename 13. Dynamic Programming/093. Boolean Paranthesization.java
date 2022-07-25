// GfG: https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/0

class Solution {
    // Time - O(N ^ 3), Space - O(N ^ 2) 2D DP

    static int[] eval(int[] l, int[] r, char operator) {
        long[] curr = { 0, 0 };

        if (operator == '&') {
            curr[0] = l[0] * r[0];
            curr[1] = l[0] * r[1] + l[1] * r[0] + l[1] * r[1];
        } else if (operator == '|') {
            curr[0] = l[0] * r[0] + l[0] * r[1] + l[1] * r[0];
            curr[1] = l[1] * r[1];
        } else if (operator == '^') {
            curr[0] = l[0] * r[1] + l[1] * r[0];
            curr[1] = l[0] * r[0] + l[1] * r[1];
        }

        curr[0] = curr[0] % 1003;
        curr[1] = curr[1] % 1003;

        return new int[] { (int) curr[0], (int) curr[1] };
    }

    static int[] helper(int l, int r, String str, int[][][] dp) {
        if (l == r) {
            char operand = str.charAt(l);
            if (operand == 'T')
                return new int[] { 1, 0 };
            return new int[] { 0, 1 };
        }

        if (dp[l][r][0] != -1)
            return dp[l][r];

        int[] res = { 0, 0 };

        // Create Partitions over Operators
        for (int k = l + 1; k < r; k += 2) {

            int[] left = helper(l, k - 1, str, dp);
            int[] right = helper(k + 1, r, str, dp);
            int[] curr = eval(left, right, str.charAt(k));
            res[0] = (res[0] + curr[0]) % 1003;
            res[1] = (res[1] + curr[1]) % 1003;
        }

        return dp[l][r] = res;
    }

    static int countWays(int N, String str) {
        int[][][] dp = new int[N + 1][N + 1][2];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }

        return helper(0, N - 1, str, dp)[0];
    }
}
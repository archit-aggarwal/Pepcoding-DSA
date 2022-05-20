// GfG: https://practice.geeksforgeeks.org/problems/mobile-numeric-keypad5456/1

// Time - O(5 * 10 * N) in Worst Case, Space - O(N * 10) DP Table
class Solution {
    // For Each Key, store the neighbouring keys and the same key itself.
    int[][] adj = { { 0, 8 }, { 1, 2, 4 }, { 1, 2, 3, 5 }, { 2, 3, 6 }, { 1, 4, 5, 7 },
            { 2, 4, 5, 6, 8 }, { 3, 5, 6, 9 }, { 4, 7, 8 }, { 0, 5, 7, 8, 9 }, { 6, 8, 9 } };

    public long DFS(int lastKey, int keys, long[][] dp) {
        if (keys == 0)
            return 1l;
        if (dp[lastKey][keys] != -1l)
            return dp[lastKey][keys];

        long ans = 0;
        for (int nbr : adj[lastKey]) {
            ans = ans + DFS(nbr, keys - 1, dp);
        }

        return dp[lastKey][keys] = ans;
    }

    public long getCount(int N) {
        long[][] dp = new long[10][N];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }

        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans = ans + DFS(i, N - 1, dp);
        }

        return ans;
    }
}
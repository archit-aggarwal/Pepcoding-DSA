import java.util.*;

// GfG: https://practice.geeksforgeeks.org/problems/steps-by-knight5927/1
// Time = O(Rows * Cols * 4) for BFS

class Solution {
    static class pair {
        int x, y, dist;

        public pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int BFS(int i, int j, int n, int m, int adj[][], int size, boolean vis[][]) {
        ArrayDeque<pair> q = new ArrayDeque<>();
        q.add(new pair(i, j, 0));
        vis[i][j] = true;

        while (!q.isEmpty()) {
            pair rem = q.remove();

            if (rem.x == n && rem.y == m)
                return rem.dist;

            for (int it[] : adj) {
                int x = rem.x + it[0];
                int y = rem.y + it[1];

                if ((x >= 1 && y >= 1 && x <= size && y <= size) && (vis[x][y] == false)) {
                    vis[x][y] = true;
                    q.add(new pair(x, y, rem.dist + 1));
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    public static int minStepToReachTarget(int src[], int dstn[], int n) {
        int adj[][] = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 },
                { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };

        boolean vis[][] = new boolean[n + 1][n + 1];
        int ans = BFS(src[0], src[1], dstn[0], dstn[1], adj, n, vis);
        return ans;
    }
}
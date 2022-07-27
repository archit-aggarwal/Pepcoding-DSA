import java.util.*;

// 417: https://leetcode.com/problems/pacific-atlantic-water-flow/

class Solution {
    int[][] dir = { { +1, 0 }, { -1, 0 }, { 0, +1 }, { 0, -1 } };

    // Time - O(N * M) where N = rows, M = columns: DFS
    public void DFS(int r, int c, int[][] heights, boolean[][] vis) {
        if (vis[r][c] == true)
            return;

        vis[r][c] = true;
        for (int d = 0; d < 4; d++) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if (nr < 0 || nc < 0 || nr >= heights.length || nc >= heights[r].length)
                continue;

            if (heights[nr][nc] >= heights[r][c]) {
                DFS(nr, nc, heights, vis);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length, m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        for (int i = 0; i < m; i++)
            DFS(0, i, heights, pacific); // TOP WALL
        for (int i = 0; i < n; i++)
            DFS(i, 0, heights, pacific); // LEFT WALL

        boolean[][] atlantic = new boolean[n][m];
        for (int i = 0; i < m; i++)
            DFS(n - 1, i, heights, atlantic); // BOTTOM WALL
        for (int i = 0; i < n; i++)
            DFS(i, m - 1, heights, atlantic); // RIGHT WALL

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] == true && atlantic[i][j] == true) {
                    List<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);
                    res.add(point);
                }
            }
        }
        return res;
    }
}
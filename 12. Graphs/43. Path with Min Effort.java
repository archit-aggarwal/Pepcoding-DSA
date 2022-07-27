
// Leetcode 1631: https://leetcode.com/problems/path-with-minimum-effort/
import java.util.*;

// Time = O((Rows + Cols) * Log (Rows + Cols)) Dijkstra
class Solution {
    public static class Pair {
        int row, col, val, dist;

        Pair(int row, int col, int val, int dist) {
            this.row = row;
            this.col = col;
            this.val = val;
            this.dist = dist;
        }
    }

    public static class DiffComparator implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return a.dist - b.dist;
            // Path with Minimum Effort -> Min Priority Queue
        }
    }

    public int[][] dir = { { +1, 0 }, { -1, 0 }, { 0, +1 }, { 0, -1 } };

    public int minimumEffortPath(int[][] mat) {
        PriorityQueue<Pair> q = new PriorityQueue<>(new DiffComparator());
        q.add(new Pair(0, 0, mat[0][0], 0));

        while (q.size() > 0) {
            Pair top = q.remove();

            if (top.row == mat.length - 1 && top.col == mat[0].length - 1) {
                return top.dist;
            }

            if (mat[top.row][top.col] == -1)
                continue; // visited

            for (int d = 0; d < 4; d++) {
                int nr = top.row + dir[d][0];
                int nc = top.col + dir[d][1];

                if (nr < 0 || nc < 0 || nr >= mat.length || nc >= mat[0].length)
                    continue;

                int nd = Math.max(top.dist, Math.abs(mat[top.row][top.col] - mat[nr][nc]));
                q.add(new Pair(nr, nc, mat[nr][nc], nd));
            }

            mat[top.row][top.col] = -1;
        }

        return 0;
    }
}
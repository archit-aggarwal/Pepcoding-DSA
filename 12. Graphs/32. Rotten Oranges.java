import java.util.*;
// 994: https://leetcode.com/problems/rotting-oranges/

class Pair {
    int row, col, dist;

    Pair(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

// Time = O(N + E) = O(Rows * Cols) Multisource BFS

class Solution {
    int[][] calls = { { +1, 0 }, { -1, 0 }, { 0, +1 }, { 0, -1 } };

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        int min = 0;
        while (q.size() > 0) {
            Pair front = q.remove();

            if (grid[front.row][front.col] == 3)
                continue; // Already Visited
            grid[front.row][front.col] = 3; // Visited Mark
            min = Math.max(min, front.dist);

            for (int i = 0; i < 4; i++) {
                int nr = front.row + calls[i][0];
                int nc = front.col + calls[i][1];

                // Out of Matrix
                if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length)
                    continue;

                // Empty Cell or Already Rotten
                if (grid[nr][nc] == 0 || grid[nr][nc] == 3)
                    continue;

                q.add(new Pair(nr, nc, front.dist + 1));
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return -1; // Not Possible to rot all oranges
            }
        }

        return min;
    }
}
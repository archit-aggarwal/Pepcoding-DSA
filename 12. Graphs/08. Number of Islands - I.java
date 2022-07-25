// Leetcode 200: https://leetcode.com/problems/number-of-islands/

// Time - O(N ^ 2) DFS in Matrix, Space - O(N ^ 2) Recursion Call Stack
class Solution {
    int[][] directions = { { +1, 0 }, { -1, 0 }, { 0, +1 }, { 0, -1 } };
    // down, up, right, left

    public void DFS(int r, int c, char[][] grid) {
        // Out of Matrix, Water Cell, Visited Land
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length
                || grid[r][c] == '0' || grid[r][c] == 'N')
            return;

        grid[r][c] = 'N'; // Visited Land
        for (int[] direction : directions) {
            DFS(r + direction[0], c + direction[1], grid);
        }
    }

    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // Unvisited Land
                if (grid[i][j] == '1') {
                    DFS(i, j, grid);
                    islands++;
                }
            }
        }
        return islands;
    }
}
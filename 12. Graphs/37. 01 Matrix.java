import java.util.*;

// Leetcode 542: https://leetcode.com/problems/01-matrix/

// Time = O(ROWS * COLS) for BFS
class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;
        int[][] arr = new int[m][n];

        Queue<List<Integer>> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    arr[i][j] = 0;
                    queue.offer(Arrays.asList(i, j));
                } else {
                    arr[i][j] = -1;
                }
            }
        }

        // BFS
        int[][] dirs = new int[][] { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

        while (!queue.isEmpty()) {

            List<Integer> curCell = queue.poll();
            assert curCell != null;
            int r = curCell.get(0);
            int c = curCell.get(1);

            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];

                if (isValidAdjacentCell(arr, nr, nc)) {

                    queue.offer(Arrays.asList(nr, nc));
                    arr[nr][nc] = arr[r][c] + 1;

                }
            }
        }

        return arr;
    }

    public boolean isValidAdjacentCell(int[][] arr, int i, int j) {
        return (i >= 0 && i < arr.length && j >= 0 && j < arr[0].length && arr[i][j] == -1);
    }
}
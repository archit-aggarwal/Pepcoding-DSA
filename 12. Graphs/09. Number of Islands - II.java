// 1020: https://leetcode.com/problems/number-of-enclaves/

class Solution {
    // Time: DFS: O(N + E)
    public int numEnclaves(int[][] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (i == 0 || j == 0 || i == A.length - 1 || j == A[i].length - 1)
                    dfs(A, i, j);
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1)
                    result++;
            }
        }

        return result;
    }

    public void dfs(int a[][], int i, int j) {
        if (i >= 0 && i <= a.length - 1 && j >= 0 && j <= a[i].length - 1 && a[i][j] == 1) {
            a[i][j] = 0;
            dfs(a, i + 1, j);
            dfs(a, i - 1, j);
            dfs(a, i, j + 1);
            dfs(a, i, j - 1);
        }
    }
}
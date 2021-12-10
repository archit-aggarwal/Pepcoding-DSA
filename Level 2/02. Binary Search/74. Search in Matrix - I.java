class Solution {
    // O(log2(N * M))
    public boolean searchMatrix1(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int left = 0, right = n * m - 1;

        while (left <= right) {
            int midCell = left + (right - left) / 2;

            int rowIdx = midCell / m;
            int colIdx = midCell % m;

            if (matrix[rowIdx][colIdx] == target) {
                return true;
            }

            if (matrix[rowIdx][colIdx] < target) {
                left = midCell + 1;
            }

            else
                right = midCell - 1;
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix1(matrix, target);
    }
}
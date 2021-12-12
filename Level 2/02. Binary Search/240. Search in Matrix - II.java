// Staircase Search -> O(N + M)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Staircase Search -> O(N + M) in Worst Case
        int row = 0, col = matrix[0].length - 1; // top right corner

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target)
                return true;

            if (target < matrix[row][col])
                col--;
            else
                row++;
        }

        return false;
    }
}
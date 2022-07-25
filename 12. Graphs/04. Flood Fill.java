// Leetcode 733: https://leetcode.com/problems/flood-fill/

class Solution {
    // Time - O(N^2) in Worst Case, Space - O(N) Recursion Call Stack Space
    public void DFS(int[][] image, int sr, int sc, int newColor, int startColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length)
            return;

        if (image[sr][sc] != startColor)
            return;

        image[sr][sc] = newColor;
        DFS(image, sr + 1, sc, newColor, startColor);
        DFS(image, sr - 1, sc, newColor, startColor);
        DFS(image, sr, sc + 1, newColor, startColor);
        DFS(image, sr, sc - 1, newColor, startColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image;
        DFS(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
}
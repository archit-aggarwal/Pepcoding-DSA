// GfG: https://practice.geeksforgeeks.org/problems/champagne-overflow2636/1

class Solution {
    // Time - O(R * C), Space - O(R * C)
    static double waterOverflow(int K, int R, int C) {
        double[][] pascal = new double[501][501];
        pascal[0][0] = K;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j <= i; j++) {
                if (pascal[i][j] > 1.0) {
                    pascal[i + 1][j] += (pascal[i][j] - 1.0) / 2.0;
                    pascal[i + 1][j + 1] += (pascal[i][j] - 1.0) / 2.0;
                    pascal[i][j] = 1.0;
                }
            }
        }

        return pascal[R - 1][C - 1];
    }
}
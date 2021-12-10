class GfG {
    // Similar to Stepcase Search - O(N + M)
    int countZeros(int A[][], int N) {
        int i = N - 1, ans = 0;
        for (int j = 0; i > 0 && j < N; j++) {
            while (i >= 0 && A[i][j] == 1) {
                i--;
            }
            ans += (i + 1);
        }
        return ans;
    }
}
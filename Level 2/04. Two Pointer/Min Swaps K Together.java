class Complete {
    public static int minSwap(int arr[], int n, int k) {
        int window = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) {
                window++;
            }
        }

        int moreThank = 0;
        for (int i = 0; i < window; i++) {
            if (arr[i] > k) {
                moreThank++;
            }
        }

        int minSwaps = moreThank;
        for (int i = window; i < n; i++) {
            if (arr[i] > k)
                moreThank++;
            if (arr[i - window] > k)
                moreThank--;

            minSwaps = Math.min(minSwaps, moreThank);
        }
        return minSwaps;
    }
}
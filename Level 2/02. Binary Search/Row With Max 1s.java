class Solution {

    int transitionPoint(int arr[], int left, int right) {
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == 0) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }

        return ans;
    }

    int rowWithMax1s(int arr[][], int n, int m) {
        int right = m - 1;
        int ans = -1, noOfOnes = 0;
        for (int i = 0; i < n; i++) {
            int transitionPt = transitionPoint(arr[i], 0, right);
            if (transitionPt != -1 && m - transitionPt > noOfOnes) {
                ans = i;
                noOfOnes = m - transitionPt;
                right = transitionPt - 1;
            }
        }
        return ans;
    }
}
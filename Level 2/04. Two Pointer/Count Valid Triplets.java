class Solution {
    int twoSum(int[] arr, int left, int right, int target) {
        int count = 0;
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                count++;
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    int countTriplet(int arr[], int n) {
        Arrays.sort(arr);
        int count = 0;
        for (int c = n - 1; c > 1; c--) {
            count += twoSum(arr, 0, c - 1, arr[c]);
        }
        return count;
    }
}
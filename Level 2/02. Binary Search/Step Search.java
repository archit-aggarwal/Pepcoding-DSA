class Complete {
    public static int search(int arr[], int n, int target, int k) {
        int idx = 0;
        while (idx < n) {

            if (arr[idx] == target)
                return idx;

            int minJump = (Math.abs(target - arr[idx])) / k;
            if (minJump == 0)
                minJump = 1;

            idx = idx + minJump;
        }
        return -1;
    }

}
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solve(num, k));
    }

    public static int solve(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int lval = (mid - 1 >= 0) ? arr[mid - 1] : Integer.MIN_VALUE;
            int rval = (mid + 1 < arr.length) ? arr[mid + 1] : Integer.MAX_VALUE;

            if (target == arr[mid])
                return mid;
            if (target == lval)
                return mid - 1;
            if (target == rval)
                return mid + 1;

            if (target < arr[mid])
                high = mid - 2;
            else
                low = mid + 2;
        }

        return -1;
    }
}
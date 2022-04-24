import java.io.*;
import java.util.*;

// Problem Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb-stairs-with-variable-jumps-official/ojquestion

class Main {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        System.out.println(csvm(0, n, arr));

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(csvmMem(0, n, arr, dp));

        System.out.println(csvmTab(n, arr));
    }

    // Recursion -> O(Jumps^N + Jumps*N) Time, O(N) Space
    public static int csvm(int src, int dest, int[] arr) {
        if (src > dest)
            return 0;
        if (src == dest)
            return 1;

        int totalPaths = 0;
        for (int jumps = 1; jumps <= arr[src]; jumps++) {
            int xi = csvm(src + jumps, dest, arr);
            totalPaths += xi;
        }

        return totalPaths;
    }

    // Memoization -> O(Jumps*N) Time, O(N) Space
    public static int csvmMem(int src, int dest, int[] arr, int[] dp) {
        if (src > dest)
            return 0;
        if (src == dest)
            return 1;

        if (dp[src] != -1) {
            return dp[src];
        }

        int totalPaths = 0;
        for (int jumps = 1; jumps <= arr[src]; jumps++) {
            int xi = csvmMem(src + jumps, dest, arr, dp);
            totalPaths += xi;
        }

        dp[src] = totalPaths;
        return dp[src];
    }

    // Tabulation -> O(N*Jumps) Time, O(N) Space
    public static int csvmTab(int dest, int[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        dp[dest] = 1;
        for (int i = n - 1; i >= 0; i--) {

            int totalPaths = 0;
            for (int jumps = 1; jumps <= arr[i]; jumps++) {
                if (i + jumps < dp.length) {
                    totalPaths += dp[i + jumps];
                }
            }

            dp[i] = totalPaths;
        }

        return dp[0];
    }

    // Space Optimization is Not Possible due to non-limited previous states.
}
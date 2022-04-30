import java.util.*;
import java.io.*;

// Link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb-stairs-official/ojquestion

// This problem is nothing but Tribonacci Series
// 1137. https://leetcode.com/problems/n-th-tribonacci-number/

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        System.out.println(csRec(0, n));

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(csMem(0, n, dp));

        System.out.println(csTab(n));
    }

    // O(3^N) Time, O(N) Space
    public static int csRec(int src, int dest) {
        if (src > dest)
            return 0;
        // -ve base case

        if (src == dest)
            return 1;
        // +ve base case

        int x = csRec(src + 1, dest);
        int y = csRec(src + 2, dest);
        int z = csRec(src + 3, dest);

        int totalPaths = x + y + z;
        return totalPaths;
    }

    // O(N) Time, O(N) Space
    public static int csMem(int src, int dest, int[] dp) {
        if (src > dest)
            return 0;
        if (src == dest)
            return 1;

        if (dp[src] != -1) {
            return dp[src];
        }

        int x = csMem(src + 1, dest, dp);
        int y = csMem(src + 2, dest, dp);
        int z = csMem(src + 3, dest, dp);

        dp[src] = x + y + z;
        return dp[src];
    }

    // O(N) Time, O(N) Space
    public static int csTab(int dest) {
        int[] dp = new int[dest + 1];
        dp[dest] = 1;
        for (int i = dest - 1; i >= 0; i--) {

            dp[i] = dp[i + 1];
            if (i + 2 < dp.length) {
                dp[i] += dp[i + 2];
            }

            if (i + 3 < dp.length) {
                dp[i] += dp[i + 3];
            }
        }

        return dp[0];
    }
}

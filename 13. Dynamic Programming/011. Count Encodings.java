import java.io.*;
import java.util.*;

// 91. https://leetcode.com/problems/decode-ways/

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        int[] dp = new int[str.length()];
        Arrays.fill(dp, -1);
        System.out.println(countEncodingsMemo(str, 0, dp));

        System.out.println(countEncodingsTab(str));
    }

    // Memoization -> O(n) Time, O(n) Space
    public static int countEncodingsMemo(String str, int idx, int[] dp) {
        if (idx == str.length()) {
            return 1;
        }

        if (dp[idx] != -1)
            return dp[idx];

        int ans = 0;

        int ch1 = (str.charAt(idx) - '0');
        if (ch1 >= 1 && ch1 <= 9) {
            ans += countEncodingsMemo(str, idx + 1, dp);
        }

        if (idx + 1 < str.length()) {
            int ch12 = (str.charAt(idx) - '0') * 10 + (str.charAt(idx + 1) - '0');
            if (ch12 >= 10 && ch12 <= 26)
                ans += countEncodingsMemo(str, idx + 2, dp);
        }

        dp[idx] = ans;
        return ans;
    }

    // Tabulation -> O(n) Time, O(n) Space
    public static int countEncodingsTab(String str) {
        int[] dp = new int[str.length() + 1];
        dp[str.length()] = 1;

        for (int i = str.length() - 1; i >= 0; i--) {
            int ch1 = (str.charAt(i) - '0');
            if (ch1 >= 1 && ch1 <= 9) {
                dp[i] += dp[i + 1];
            }

            if (i + 1 < str.length()) {
                int ch12 = (str.charAt(i) - '0') * 10 + (str.charAt(i + 1) - '0');
                if (ch12 >= 10 && ch12 <= 26)
                    dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }

    // Space Optimization (Two Pointer Technique) is Also Possible
    // Since there are limited previous states -> Do It Yourself
    // Time - O(N), Space - O(1)
}
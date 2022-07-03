// InterviewBit: Minimize Difference Subsets:
// https://www.interviewbit.com/problems/minimum-difference-subsets/

class Solution {
    public int solve(int[] arr) {
        int n = arr.length;

        int total = 0;
        for (int val : arr)
            total += val;

        // Check Target Sum Subset with Space Optimization:
        // Time - O(N * Target), Space - O(Target)

        boolean[] dp = new boolean[total + 1];
        dp[0] = true; // Empty Subset to form 0 total

        for (int i = 1; i <= n; i++) {
            boolean[] newdp = new boolean[total + 1];

            for (int j = 0; j <= total; j++) {
                boolean no = dp[j]; // No Call
                boolean yes = (j >= arr[i - 1]) ? dp[j - arr[i - 1]] : false;

                newdp[j] = no || yes;
            }

            dp = newdp;
        }

        // Extra Work for this Variation - O(Total) Time, O(1) Space
        int half = (total + 1) / 2;
        for (int s1 = half; s1 <= total; s1++) {
            if (dp[s1] == true) {
                return (s1 - (total - s1));
            }
        }

        return total;
    }
}

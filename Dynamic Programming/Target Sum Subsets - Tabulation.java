public class Solution {
    public int solve(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        for(int i=0; i<=n; i++){
            dp[i][0] = true;
        }

        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=target; j++)
            {
                boolean no = dp[i - 1][j];
                boolean yes = (j - arr[i-1] < 0) ? false : dp[i - 1][j - arr[i - 1]];

                dp[i][j] = no || yes;
            }
        }
        return (dp[n][target] == true) ? 1 : 0;
    }
}

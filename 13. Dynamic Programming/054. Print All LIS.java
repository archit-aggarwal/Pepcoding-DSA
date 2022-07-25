import java.util.*;
// NADOS: https://nados.io/question/print-all-longest-increasing-subsequences?zen=true

class Main {

    public static void DFS(int curr, int[] nums, int[] dp, String psf) {
        if (dp[curr] == 1) {
            System.out.println(psf);
            return;
        }

        for (int prev = curr - 1; prev >= 0; prev--) {
            if (nums[prev] < nums[curr] && dp[curr] == dp[prev] + 1) {
                DFS(prev, nums, dp, nums[prev] + " -> " + psf);
            }
        }
    }

    public static void solution(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        int maxLIS = 0;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1; // Length

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            if (dp[i] > maxLIS) {
                maxLIS = dp[i];
            }
        }

        System.out.println(maxLIS);

        for (int i = n - 1; i >= 0; i--) {
            // Start DFS from each node at which Increasing Subset is of
            // Longest Length

            if (dp[i] == maxLIS) {
                DFS(i, nums, dp, "" + nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        solution(arr);

        scn.close();
    }
}
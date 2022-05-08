import java.io.*;
import java.util.*;

// Problem Link: NADOS: https://nados.io/question/print-all-results-in-0-1-knapsack?zen=true

class Main {
    public static class Pair {
        int row;
        int col;
        String psf;

        Pair(int row, int col, String psf) {
            this.row = row;
            this.col = col;
            this.psf = psf;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] cost = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wt = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wt[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int caps = Integer.parseInt(br.readLine());

        int[][] dp = new int[caps + 1][cost.length + 1];

        for (int item = 1; item <= cost.length; item++) {
            for (int cap = 1; cap <= caps; cap++) {

                int no = dp[cap][item - 1];
                int yes = (cap >= wt[item - 1])
                        ? cost[item - 1] + dp[cap - wt[item - 1]][item - 1]
                        : -1;

                dp[cap][item] = Math.max(yes, no);
            }
        }

        System.out.println(dp[caps][cost.length]);

        // Time - O(Exponential) in Worst Case (All Paths)
        // but O(Capacity) in Average Case (1 Path)

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(caps, cost.length, ""));

        while (q.size() > 0) {
            Pair top = q.remove();
            int row = top.row;
            int col = top.col;
            String psf = top.psf;

            if (top.col == 0) {
                System.out.println(top.psf);
                continue;
            }

            // If Item Can be Included and It gives Maximum Profit, then explore this edge
            if (row >= wt[col - 1] &&
                    dp[row][col] == cost[col - 1] + dp[row - wt[col - 1]][col - 1]) {
                q.add(new Pair(row - wt[col - 1], col - 1, (col - 1) + " " + psf));
            }

            // If no call gives maximum profit, then only explore this edge
            if (dp[row][col] == dp[row][col - 1]) {
                q.add(new Pair(row, col - 1, psf));
            }
        }
    }
}
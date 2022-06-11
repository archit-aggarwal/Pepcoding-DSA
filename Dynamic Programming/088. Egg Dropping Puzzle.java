// Egg Drop Variations

// 1. N Floors, 1 Egg - Trivial Case - Linear Search:
// Answer: N Floors is the answer

// 2. N Floors, 2 Egg
// LC: 1884. Egg Drop With 2 Eggs and N Floors
// https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/

// Greedy or Mathematics Solution
// Time - O(1) (Assuming Sqrt is computed in constant time)
// Space - O(1) (No Extra Space)

class NFloor2Eggs {
    public int twoEggDrop(int n) {
        // Equation: x^2 + x = 2 * n
        // => x = (-1 + root(1 + 8 * n)) / 2.0;

        double ans = (-1.0 + Math.sqrt(1.0 + 8.0 * n)) / 2.0;
        System.out.println(ans);
        if (ans == (int) ans)
            return (int) ans;
        return (int) ans + 1;
    }
}

// 3. N Floors, Infinite Supply of Eggs - Binary Search
// Answer: Ceil(log2 N) where N = Number of Floors

// 4. Infinite Floors, Infinite Supply of Eggs - Binary Search on Infinite Array
// Answer: Apply above logic by doubling search space concept (Infinitely Sorted
// Array)

// 5. N Floors, K Eggs - Recursion + Memoization or Dynamic Programming
// GfG:
// https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1

// Time - O(Floors * Floors * Eggs)
// Space - O(Floors * Eggs) 2D DP

class Solution {
    static int eggDrop(int floors, int eggs, int[][] dp) {
        if (floors == 0)
            return 0;
        if (eggs == 1)
            return floors;
        if (dp[floors][eggs] != -1)
            return dp[floors][eggs];

        int min = floors;
        for (int i = 1; i <= floors; i++) {
            int eggBreak = eggDrop(i - 1, eggs - 1, dp);
            int eggSurvive = eggDrop(floors - i, eggs, dp);

            min = Math.min(min, 1 + Math.max(eggBreak, eggSurvive));
        }

        return dp[floors][eggs] = min;
    }

    static int eggDrop(int eggs, int floors) {
        int[][] dp = new int[floors + 1][eggs + 1];
        for (int i = 0; i <= floors; i++) {
            for (int j = 0; j <= eggs; j++) {
                dp[i][j] = -1;
            }
        }

        return eggDrop(floors, eggs, dp);
    }
}
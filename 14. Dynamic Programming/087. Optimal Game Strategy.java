// LC: 486: Predict the Winner:
// https://leetcode.com/problems/predict-the-winner/

// Approach 1: One Player Perspective: Recursion
// Time - Exponential, Space - O(N) RCS
class Solution1 {
    public int helper(int left, int right, int[] nums) {
        if (left > right)
            return 0;
        if (left == right)
            return nums[left];

        int c1 = helper(left + 2, right, nums);
        int c2 = helper(left + 1, right - 1, nums);
        int c3 = helper(left, right - 2, nums);

        return Math.max(nums[left] + Math.min(c1, c2), nums[right] + Math.min(c2, c3));
    }

    public boolean PredictTheWinner(int[] nums) {
        int ascore = helper(0, nums.length - 1, nums);

        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total = total + nums[i];
        }

        int bscore = total - ascore;

        if (ascore >= bscore)
            return true;
        return false;
    }
}

// Approach 2: One Player Perspective: Memoization
// Time - O(N ^ 2), Space - O(N ^ 2) 2D DP
class Solution2 {
    public int helper(int left, int right, int[] nums, int[][] dp) {
        if (left > right)
            return 0;
        if (left == right)
            return nums[left];
        if (dp[left][right] != -1)
            return dp[left][right];

        int c1 = helper(left + 2, right, nums, dp);
        int c2 = helper(left + 1, right - 1, nums, dp);
        int c3 = helper(left, right - 2, nums, dp);

        return dp[left][right] = Math.max(nums[left] + Math.min(c1, c2),
                nums[right] + Math.min(c2, c3));
    }

    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;

        int ascore = helper(0, nums.length - 1, nums, dp);

        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total = total + nums[i];
        }

        int bscore = total - ascore;

        if (ascore >= bscore)
            return true;
        return false;
    }
}

// Approach 2: Two Players Perspective: Difference of Scores
// Memoization: O(N ^ 2) Time, O(N ^ 2) Space - 2D DP
class Solution3 {
    public int helper(int left, int right, int[] nums, int[][] dp) {
        if (left > right)
            return 0;
        if (left == right)
            return nums[left];
        if (dp[left][right] != -1)
            return dp[left][right];

        return dp[left][right] = Math.max(nums[left] - helper(left + 1, right, nums, dp),
                nums[right] - helper(left, right - 1, nums, dp));
    }

    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;

        int diff = helper(0, nums.length - 1, nums, dp);
        if (diff >= 0)
            return true;
        return false;
    }
}

// Follow Up: Even Size Array: LC 877: Stone Game
// https://leetcode.com/problems/stone-game/
// Constant Time - O(1), Constant Space - O(1)

class FollowUp {
    public boolean stoneGame(int[] piles) {
        return true;
    }
}
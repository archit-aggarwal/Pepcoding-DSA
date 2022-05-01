import java.util.*;

// GfG: https://practice.geeksforgeeks.org/problems/-minimum-number-of-coins4426/1/

class Solution {
    // Time - O(N), Space - O(1) Extra Space, O(N) Output Space
    static List<Integer> minPartition(int target) {
        List<Integer> res = new ArrayList<>();
        int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };

        for (int i = coins.length - 1; i >= 0; i--) {

            while (target - coins[i] >= 0) {
                res.add(coins[i]);
                target -= coins[i];
            }

            if (target == 0)
                break;
        }

        return res;
    }

    // For Just Counting the Minimum Coins, Time will be O(Coins) = O(10) = O(1)
    static int minCoins(int target) {
        int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        int count = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            count = count + (target * (target / coins[i]));
            target -= (target / coins[i]);
            if (target == 0)
                break;
        }

        return count;
    }
}
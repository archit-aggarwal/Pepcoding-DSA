import java.util.*;

class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> AB = new HashMap<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                AB.put(product, AB.getOrDefault(product, 0) + 1);
            }
        }

        int count = 0;
        for (Integer key : AB.keySet()) {
            int val = AB.get(key);
            count = count + (val * (val - 1)) / 2;
        }

        return 8 * count;
    }
}
class Solution {
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        int count = 0;
        for (Integer key : freq.keySet()) {
            int freq1 = freq.get(key);

            if (k == 0) {
                count = count + (k * (k - 1)) / 2;
            } else {
                int freq2 = freq.getOrDefault(k + key, 0);
                count = count + freq1 * freq2;
            }
        }

        return count;
    }
}
class Solution {
    public int subarraysWithAtmostK(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int count = 0, left = 0;

        for (int right = 0; right < nums.length; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            while (freq.size() > k) {
                freq.put(nums[left], freq.getOrDefault(nums[left], 0) - 1);

                if (freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]);
                }
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithAtmostK(nums, k)
                - subarraysWithAtmostK(nums, k - 1);
    }
}
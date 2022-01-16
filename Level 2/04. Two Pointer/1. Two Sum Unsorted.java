class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> comp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (comp.containsKey(target - nums[i]) == true) {
                return new int[] { comp.get(target - nums[i]), i };
            }
            comp.put(nums[i], i);
        }

        return null;
    }
}
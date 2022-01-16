class Solution {
    public List<List<Integer>> twoSum(int[] nums, int left, int right, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int start = left;

        while (left < right) {
            if (left > start && nums[left - 1] == nums[left]) {
                left++;
                continue;
            }

            int sum = nums[left] + nums[right];

            if (sum == target) {
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[left]);
                pair.add(nums[right]);
                ans.add(pair);

                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first - 1] == nums[first]) {
                continue;
            }

            List<List<Integer>> pairs = twoSum(nums, first + 1, nums.length - 1, -nums[first]);
            for (List<Integer> triplet : pairs) {
                triplet.add(0, nums[first]);
                ans.add(triplet);
            }
        }
        return ans;
    }
}
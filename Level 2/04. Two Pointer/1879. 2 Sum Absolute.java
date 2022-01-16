public class Solution {
    /**
     * @param nums:   the input array
     * @param target: the target number
     * @return: return the target pair
     */

    public int getNext(int[] nums, int index) {
        // negative -> right to left

        if (index == nums.length || nums[index] < 0) {
            index--;
            if (index == nums.length)
                return index;
            while (index >= 0 && nums[index] >= 0) {
                index--;
            }
            if (index >= 0)
                return index;
        }

        // positive -> left to right
        if (index < 0)
            index = 0;
        else
            index++;

        while (index < nums.length && nums[index] < 0) {
            index++;
        }

        return index;
    }

    public int getPrev(int[] nums, int index) {
        // positive -> right to left

        if (index == nums.length || nums[index] >= 0) {
            index--;

            if (index == nums.length)
                return index;

            while (index >= 0 && nums[index] < 0) {
                index--;
            }

            if (index >= 0)
                return index;
        }

        // negative -> left to right
        if (index < 0)
            index = 0;
        else
            index++;

        while (index < nums.length && nums[index] >= 0) {
            index++;
        }

        return index;
    }

    public List<List<Integer>> twoSumVII(int[] nums, int target) {
        int left = getNext(nums, nums.length);
        int right = getPrev(nums, nums.length);

        List<List<Integer>> res = new ArrayList<>();
        while (left < nums.length && right < nums.length && nums[left] < nums[right]) {
            System.out.println(left + " " + right);
            int sum = nums[left] + nums[right];

            if (sum == target) {
                int idx1 = Math.min(left, right);
                int idx2 = Math.max(left, right);

                List<Integer> ans = new ArrayList<>();
                ans.add(idx1);
                ans.add(idx2);
                res.add(ans);

                left = getNext(nums, left);
                right = getPrev(nums, right);
            } else if (sum < target) {
                left = getNext(nums, left);
            } else {
                right = getPrev(nums, right);
            }
        }
        return res;
    }
}

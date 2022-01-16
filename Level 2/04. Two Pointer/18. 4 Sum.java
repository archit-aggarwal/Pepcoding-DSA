import java.util.*;

// This solution uses Recursion K Sum
class Solution {
    public List<List<Integer>> twoSum(int[] nums, int left, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int start = left;
        int right = nums.length - 1;

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

    public List<List<Integer>> kSum(int[] nums, int start, int target, int k) {
        if (k == 2) {
            return twoSum(nums, start, target);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = start; i <= nums.length - k; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            List<List<Integer>> subRes = kSum(nums, i + 1, target - nums[i], k - 1);
            for (List<Integer> sub : subRes) {
                sub.add(0, nums[i]);
                res.add(sub);
            }
        }

        return res;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, target, 4);
    }
}

// This solution using Hashmap is giving TLE
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashMap<Integer, List<List<Integer>>> AB = new HashMap<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                List<Integer> pair = new ArrayList<>();
                pair.add(i);
                pair.add(j);

                if (AB.containsKey(sum) == false) {
                    List<List<Integer>> temp = new ArrayList<>();
                    AB.put(sum, temp);
                }
                AB.get(sum).add(pair);
            }
        }

        HashSet<List<Integer>> unique = new HashSet<>();

        for (int p = 0; p < n; p++) {
            for (int q = p + 1; q < n; q++) {
                int remTarget = target - nums[p] - nums[q];

                if (AB.containsKey(remTarget) == false) {
                    continue;
                }

                for (List<Integer> pair : AB.get(remTarget)) {
                    if (p != pair.get(0) && p != pair.get(1) && q != pair.get(0) && q != pair.get(1)) {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[p]);
                        quad.add(nums[q]);
                        quad.add(nums[pair.get(0)]);
                        quad.add(nums[pair.get(1)]);
                        Collections.sort(quad);
                        unique.add(quad);
                    }
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> quad : unique) {
            res.add(quad);
        }
        return res;
    }
}
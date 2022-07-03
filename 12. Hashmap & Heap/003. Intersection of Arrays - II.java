import java.util.*;
// LC 350: https://leetcode.com/problems/intersection-of-two-arrays-ii/
// Time - O(N1 + N2), Space - O(N1) Extra Space for hashmap

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums1.length; i++)
            freq.put(nums1[i], freq.getOrDefault(nums1[i], 0) + 1);

        ArrayList<Integer> intersection = new ArrayList<>();

        for (int j = 0; j < nums2.length; j++) {
            if (freq.containsKey(nums2[j]) == true) {
                intersection.add(nums2[j]);
                freq.put(nums2[j], freq.getOrDefault(nums2[j], 0) - 1);
                if (freq.get(nums2[j]) == 0)
                    freq.remove(nums2[j]);
            }
        }

        int[] res = new int[intersection.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = intersection.get(i);
        return res;
    }
}
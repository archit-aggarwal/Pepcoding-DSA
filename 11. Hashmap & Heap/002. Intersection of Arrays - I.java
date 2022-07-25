import java.util.*;
// LC 349: https://leetcode.com/problems/intersection-of-two-arrays/
// Time - O(N1 + N2), Space - O(N1) Extra Space for hashmap

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            // if(freq.containsKey(nums1[i]) == true){
            // freq.put(nums1[i], freq.get(nums1[i] + 1);
            // } else {
            // freq.put(nums1[i], 1);
            // }

            freq.put(nums1[i], freq.getOrDefault(nums1[i], 0) + 1);
        }

        ArrayList<Integer> intersection = new ArrayList<>();

        for (int j = 0; j < nums2.length; j++) {
            if (freq.containsKey(nums2[j]) == true) {
                intersection.add(nums2[j]);
                freq.remove(nums2[j]);
            }
        }

        int[] res = new int[intersection.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = intersection.get(i);
        return res;
    }
}
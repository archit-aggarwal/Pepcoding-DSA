import java.util.*;
// LC 451: https://leetcode.com/problems/sort-characters-by-frequency/
// Time - O(N + 52 + N) = O(N), Space - O(N + 52) for Two Hashmaps

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        HashMap<Integer, ArrayList<Character>> rev = new HashMap<>();
        for (Character ch : freq.keySet()) {
            int f = freq.get(ch);
            if (rev.containsKey(f) == false)
                rev.put(f, new ArrayList<>());
            rev.get(f).add(ch);
        }

        StringBuilder res = new StringBuilder("");
        for (int f = s.length(); f >= 1; f--) {
            if (rev.containsKey(f) == true) {
                for (Character ch : rev.get(f)) {
                    for (int i = 0; i < f; i++)
                        res.append(ch);
                }
            }
        }

        return res.toString();
    }
}
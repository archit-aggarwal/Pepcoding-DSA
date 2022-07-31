import java.util.*;
// leetcode 1202: https://leetcode.com/problems/smallest-string-with-swaps/

class DSU {
    int[] parent;

    DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a <= b)
            parent[b] = a;
        else
            parent[a] = b;
    }

    public int find(int a) {
        if (parent[a] == a)
            return a;
        return parent[a] = find(parent[a]);
    }
}

class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        DSU sets = new DSU(s.length());
        for (List<Integer> pair : pairs)
            sets.union(pair.get(0), pair.get(1));

        HashMap<Integer, List<Integer>> idx = new HashMap<>();
        HashMap<Integer, List<Character>> ch = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            idx.put(i, new ArrayList<>());
            idx.get(sets.find(i)).add(i);

            ch.put(i, new ArrayList<>());
            ch.get(sets.find(i)).add(s.charAt(i));
        }

        StringBuilder res = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            Collections.sort(ch.get(i));
            for (int j = 0; j < idx.get(i).size(); j++)
                res.setCharAt(idx.get(i).get(j), ch.get(i).get(j));
        }
        return res.toString();
    }
}
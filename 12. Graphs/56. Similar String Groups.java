import java.util.*;
// Leetcode 839: https://leetcode.com/problems/similar-string-groups/

// Time = O(N^2 * L) Where N = Number of Strings, L = Length of String

class Solution {
    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            Arrays.fill(parent, -1);

            rank = new int[n];
            Arrays.fill(rank, 1);
        }

        public void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb)
                return;

            if (rank[pa] > rank[pb]) {
                parent[pb] = pa;
                rank[pa] += rank[pb];
            } else {
                parent[pa] = pb;
                rank[pb] += rank[pa];
            }
        }

        public int find(int a) {
            if (parent[a] == -1)
                return a;
            return parent[a] = find(parent[a]);
        }
    }

    public boolean isSimilar(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                count++;
        }
        if (count <= 2)
            return true;
        return false;
    }

    public int numSimilarGroups(String[] strs) {
        DSU sets = new DSU(strs.length);

        for (int i = 0; i < strs.length; i++)
            for (int j = i + 1; j < strs.length; j++)
                if (isSimilar(strs[i], strs[j]) == true)
                    sets.union(i, j);

        int groups = 0;
        for (int i = 0; i < strs.length; i++) {
            if (sets.find(i) == i)
                groups++;
        }

        return groups;
    }
}
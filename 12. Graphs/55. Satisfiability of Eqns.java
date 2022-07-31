import java.util.*;
// Leetcode 990:
// https://leetcode.com/problems/satisfiability-of-equality-equations/

// Time = O(N) Where N = Number of Equations

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

    public boolean equationsPossible(String[] equations) {
        DSU sets = new DSU(26);
        for (String eqn : equations) {
            int left = eqn.charAt(0) - 'a';
            int right = eqn.charAt(3) - 'a';

            if (eqn.charAt(1) == '=')
                sets.union(left, right);
        }

        for (String eqn : equations) {
            int left = eqn.charAt(0) - 'a';
            int right = eqn.charAt(3) - 'a';

            if (eqn.charAt(1) == '!' && sets.find(left) == sets.find(right))
                return false;
        }

        return true;
    }

}
import java.util.*;
// GfG:
// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

// Time = O(N + E) DSU

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

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        DSU sets = new DSU(V + 1);

        for (int a = 0; a < adj.size(); a++) {
            for (Integer b : adj.get(a)) {
                if (a > b)
                    continue;
                // If there is an edge a-b: It will appear two times in adjacency list
                // If a -> b is an edge, then dont union again for b -> a

                if (sets.find(a) == sets.find(b))
                    return true;
                sets.union(a, b);
            }
        }

        return false;
    }

}
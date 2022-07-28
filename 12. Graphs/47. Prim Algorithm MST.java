import java.util.*;

// GfG: https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1
// Time: O((N + E) * Log N) 

class Solution {
    public static class Pair implements Comparable<Pair> {
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int compareTo(Pair other) {
            return (this.weight - other.weight);
            // Min Priority Queue -> Negative for this < other
        }
    }

    @SuppressWarnings("unchecked")
    static int spanningTree(int n, ArrayList<ArrayList<ArrayList<Integer>>> g) {
        ArrayList<Pair>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            for (ArrayList<Integer> pairs : g.get(i)) {
                adj[i].add(new Pair(pairs.get(0), pairs.get(1)));
            }
        }

        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(0, 0));
        boolean[] vis = new boolean[n];
        int cost = 0;

        while (q.size() > 0) {
            Pair top = q.remove();
            if (vis[top.node] == true)
                continue; // CYCLE

            vis[top.node] = true;
            cost = cost + top.weight;

            for (Pair nbr : adj[top.node]) {
                q.add(new Pair(nbr.node, nbr.weight));
            }
        }

        return cost;
    }
}
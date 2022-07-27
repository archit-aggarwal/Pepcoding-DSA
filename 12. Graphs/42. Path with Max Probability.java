import java.util.*;

// Leetcode 1514: https://leetcode.com/problems/path-with-maximum-probability/
// Time = O(N + E * Log N) Dijkstra's Algorithm

class Solution {
    public static class Pair implements Comparable<Pair> {
        int node;
        double weight;

        public Pair(int node, double weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair other) {
            if (other.weight > this.weight)
                return +1;
            if (other.weight == this.weight)
                return 0;
            return -1;
            // Max Priority Queue
        }
    }

    @SuppressWarnings("unchecked")
    public double maxProbability(int n, int[][] edges, double[] prob, int start, int end) {
        ArrayList<Pair>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        int i = 0;
        for (int[] edge : edges) {
            // edge[0] -> source, edge[1] -> destination, edge[2] -> cost
            adj[edge[0]].add(new Pair(edge[1], prob[i])); // Directed
            adj[edge[1]].add(new Pair(edge[0], prob[i++])); // Undirected
        }

        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(start, 1.0));
        double[] vis = new double[n];
        Arrays.fill(vis, -1); // Unvisited Node -> +Inf

        while (q.size() > 0) {
            Pair top = q.remove();
            if (vis[top.node] != -1)
                continue;
            vis[top.node] = top.weight;

            for (Pair nbr : adj[top.node]) {
                q.add(new Pair(nbr.node, top.weight * nbr.weight));
            }
        }

        return (vis[end] == -1) ? 0 : vis[end];
    }
}
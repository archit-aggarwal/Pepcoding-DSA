import java.util.*;

// Leetcode 2316: https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/

class Graph {
    public ArrayList<Integer>[] adj;

    Graph(int n) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adj[src].add(dest);
        adj[dest].add(src);
    }

    public void DFS(int src, boolean[] vis, List<Integer> component) {
        if (vis[src] == true)
            return;

        vis[src] = true;
        component.add(src);

        for (Integer nbr : adj[src]) {
            DFS(nbr, vis, component);
        }
    }
}

class Solution {
    // Time - O(N + E) DFS,
    // Space - O(N) Visited Array, Component Array, Recurion Call Stack
    public long countPairs(int n, int[][] edges) {
        Graph g = new Graph(n);
        for (int[] edge : edges) {
            g.addEdge(edge[0], edge[1]);
        }

        boolean[] vis = new boolean[n];

        long pairs = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                List<Integer> component = new ArrayList<>();
                g.DFS(i, vis, component);
                pairs = pairs + ((component.size()) * ((n * 1l) - component.size()));
            }
        }

        return pairs / 2l;
    }
}
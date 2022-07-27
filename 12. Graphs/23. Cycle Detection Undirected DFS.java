import java.util.*;

// GfG: https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
// Time = O(N + E) DFS with Parent 

class Solution {
    public boolean DFS(int src, int par, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        if (vis[src] == true)
            return true;

        vis[src] = true;
        for (Integer nbr : adj.get(src)) {
            if (nbr != par && DFS(nbr, src, adj, vis) == true)
                return true;
        }

        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == false && DFS(i, -1, adj, vis) == true) {
                return true;
            }
        }

        return false;
    }
}
import java.util.*;

// GfG: https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
// Time = O(N + E) DFS with Graph Coloring

class Solution {
    // -1 -> unvisited
    // 0 -> Same Path Visited (Preorder)
    // 1 -> Diff Path Visited (Postorder)

    public boolean DFS(int src, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        if (vis[src] == 0)
            return true; // Node is visited twice in same paths
        if (vis[src] == 1)
            return false; // Node is visited twice in diff paths

        vis[src] = 0; // Preorder Visit (Same Path)
        for (Integer nbr : adj.get(src)) {
            if (DFS(nbr, adj, vis) == true)
                return true;
        }
        vis[src] = 1; // Postorder Visit (Diff Path)
        return false;
    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        Arrays.fill(vis, -1);

        for (int i = 0; i < V; i++) {
            if (DFS(i, adj, vis) == true)
                return true;
        }
        return false;
    }
}
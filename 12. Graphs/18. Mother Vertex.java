import java.util.*;
// GfG: https://practice.geeksforgeeks.org/problems/mother-vertex/1

// Time - O(N + E) Topological Sort + DFS
class Solution {
    int[] topo;
    int idx;

    void DFS(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        if (visited[src] == true)
            return;
        visited[src] = true;

        for (Integer nbr : adj.get(src))
            DFS(nbr, adj, visited);

        topo[idx--] = src;
    }

    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        topo = new int[V];
        idx = V - 1;
        for (int i = 0; i < V; i++)
            DFS(i, adj, vis);

        Arrays.fill(vis, false);
        idx = V - 1;

        DFS(topo[0], adj, vis);
        for (int i = 0; i < V; i++) {
            if (vis[i] == false)
                return -1;
        }

        return topo[0];
    }
}
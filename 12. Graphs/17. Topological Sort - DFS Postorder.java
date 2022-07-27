import java.util.*;

// GfG: https://practice.geeksforgeeks.org/problems/topological-sort/1
// Time - O(N + E) DFS
class Solution {
    static int[] topo;
    static int idx;

    static void DFS(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        if (vis[src] == true)
            return;
        vis[src] = true;

        for (Integer nbr : adj.get(src)) {
            DFS(nbr, adj, vis);
        }

        topo[idx--] = src;
    }

    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int n, ArrayList<ArrayList<Integer>> adj) {
        idx = n - 1;
        topo = new int[n];
        boolean[] vis = new boolean[n];

        // Multisource DFS
        for (int i = 0; i < n; i++)
            DFS(i, adj, vis);

        return topo;
    }
}

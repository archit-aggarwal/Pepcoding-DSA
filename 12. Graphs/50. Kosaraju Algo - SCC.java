import java.util.*;

// GfG: https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1

// Time = O(V + E) 3 Times

class Solution {
    static int topo[];
    static int idx;

    void topoSort(int src, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        if (vis[src] == true)
            return;
        vis[src] = true;
        // System.out.print(src + " ");

        for (Integer nbr : adj.get(src))
            topoSort(nbr, vis, adj);

        topo[idx--] = src;
    }

    void DFS(int src, boolean[] vis, ArrayList<Integer>[] rev) {
        if (vis[src] == true)
            return;
        vis[src] = true;

        for (Integer nbr : rev[src])
            DFS(nbr, vis, rev);
    }

    @SuppressWarnings("unchecked")
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        topo = new int[V];
        idx = V - 1;

        for (int i = 0; i < V; i++)
            topoSort(i, vis, adj);

        ArrayList<Integer>[] rev = new ArrayList[V];
        for (int i = 0; i < V; i++)
            rev[i] = new ArrayList<>();

        for (int src = 0; src < adj.size(); src++)
            for (Integer nbr : adj.get(src))
                rev[nbr].add(src);

        Arrays.fill(vis, false);
        int scc = 0;
        for (int i = 0; i < V; i++) {
            if (vis[topo[i]] == false) {
                scc++;
                DFS(topo[i], vis, rev);
                // System.out.println();
            }
        }
        return scc;
    }
}
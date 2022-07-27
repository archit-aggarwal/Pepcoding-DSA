import java.util.*;

// GfG: https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
// Time = O(N + E) BFS with Parent

class Solution {
    public static class Pair {
        int src;
        int par;

        Pair(int src, int par) {
            this.src = src;
            this.par = par;
        }
    }

    public boolean BFS(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));

        while (q.size() > 0) {
            Pair front = q.remove();
            src = front.src;
            int par = front.par;

            if (vis[src] == true)
                return true; // Cycle Detected
            vis[src] = true;

            for (Integer nbr : adj.get(src)) {
                if (nbr != par)
                    q.add(new Pair(nbr, src));
            }
        }

        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == false && BFS(i, adj, vis) == true)
                return true;
        }

        return false;
    }
}
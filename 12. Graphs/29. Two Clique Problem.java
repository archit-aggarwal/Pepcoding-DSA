import java.util.*;
// CodeStudio (Coding Ninjas):
// https://www.codingninjas.com/codestudio/problems/two-cliques_1214524

// Time = O(N + E) for Transpose Graph + O(N + E) Bipartite Algorithm (DFS)

class Solution {
    public static boolean DFS(int src, int level, boolean[][] adj, int[] vis) {
        if (vis[src] != -1) {
            if (vis[src] != level)
                return false;
            return true;
        }

        vis[src] = level;
        for (int nbr = 0; nbr < adj.length; nbr++) {
            if (src != nbr && adj[src][nbr] == false && DFS(nbr, 1 - level, adj, vis) == false)
                return false;
        }

        return true;
    }

    public static boolean twoCliques(int n, ArrayList<ArrayList<Integer>> edgeList) {
        boolean[][] adj = new boolean[n][n];
        for (ArrayList<Integer> edge : edgeList) {
            adj[edge.get(0)][edge.get(1)] = true;
            adj[edge.get(1)][edge.get(0)] = true;
        }

        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        for (int i = 0; i < n; i++) {
            if (vis[i] == -1 && DFS(i, 0, adj, vis) == false)
                return false;
        }

        return true;
    }
}
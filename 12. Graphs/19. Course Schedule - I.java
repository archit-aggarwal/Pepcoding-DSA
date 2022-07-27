import java.util.*;

// Leetcode 207: https://leetcode.com/problems/course-schedule/
// Time - O(N + E) Cycle Detection using Kahn's Algorithm

class Solution {
    public boolean DFS(int src, ArrayList<Integer>[] adj, int[] vis) {
        if (vis[src] == 0)
            return true;
        if (vis[src] == 1)
            return false;

        vis[src] = 0;
        for (Integer nbr : adj[src]) {
            if (DFS(nbr, adj, vis) == true)
                return true;
        }

        vis[src] = 1;
        return false;
    }

    @SuppressWarnings("unchecked")
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for (int[] edge : prerequisites)
            adj[edge[0]].add(edge[1]);

        int[] vis = new int[n];
        Arrays.fill(vis, -1);

        for (int i = 0; i < n; i++) {
            if (vis[i] == -1 && DFS(i, adj, vis) == true) {
                return false; // CYCLIC Graph -> Topological Sort is Not Possible
            }
        }

        return true; // ACYLIC Graph -> Topological Sort is Possible
    }
}
import java.util.*;

// 1971: https://leetcode.com/problems/find-if-path-exists-in-graph/

// Undirected + Unweighted
class Graph {
    public ArrayList<Integer>[] adj;

    @SuppressWarnings("unchecked")
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

    public boolean DFS(int src, int dest, boolean[] vis) {
        if (src == dest)
            return true;
        if (vis[src] == true)
            return false;
        vis[src] = true;

        // Looping on Adjacency List at Index = Src
        for (int nbr : adj[src]) {
            if (DFS(nbr, dest, vis) == true)
                return true;
        }

        return false;
    }

    public boolean DFS(int src, int dest) {
        boolean[] vis = new boolean[adj.length];
        return DFS(src, dest, vis);
    }

    // Time : O(N + E) Same as DFS
    public boolean BFS(int src, int dest) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[adj.length];
        q.add(src);

        while (q.size() > 0) {
            int front = q.remove();
            if (vis[front] == true)
                continue;
            if (front == dest)
                return true;
            vis[front] = true;

            for (Integer nbr : adj[front]) {
                if (vis[nbr] == false) {
                    q.add(nbr);
                }
            }
        }

        return false;
    }
}

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Graph g = new Graph(n);
        for (int i = 0; i < edges.length; i++) {
            g.addEdge(edges[i][0], edges[i][1]);
        }

        return g.BFS(source, destination);
    }
}
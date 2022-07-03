import java.util.*;

// leetcode 547: https://leetcode.com/problems/number-of-provinces/

// Time - O(N^2) Conversion from Adjacency Matrix to Adjacency List
// + O(N + E) for DFS - Get Connected Components

// Space - O(N + E) for Adjacency List + O(N) for Recursion Call Stack 

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

    public void DFS(int src, boolean[] vis) {
        if (vis[src] == true)
            return;

        vis[src] = true;

        for (Integer nbr : adj[src]) {
            DFS(nbr, vis);
        }
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Graph g = new Graph(n);

        // Convert Adjacency Matrix to Adjacency List
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    g.addEdge(i, j);
                }
            }
        }

        boolean[] vis = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                g.DFS(i, vis);
                count++;
            }
        }

        return count;
    }
}
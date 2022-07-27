import java.util.*;

// CodeStudio (Coding Ninjas):
// https://www.codingninjas.com/codestudio/problems/shortest-path-in-an-unweighted-graph_981297

// Time = O(N + E) BFS

class Solution {
    public static class Pair {
        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    @SuppressWarnings("unchecked")
    public static LinkedList<Integer> shortestPath(int[][] edges, int n, int m, int source, int dest) {
        // Adjacency List From Edge List
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        // Shortest Path in Unweighted Graph -> Single Source Single Destination
        // Breadth First Traversal

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(source, -1));
        boolean[] vis = new boolean[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        while (q.size() > 0) {
            Pair front = q.remove();

            if (vis[front.node] != false)
                continue;

            vis[front.node] = true;
            parent[front.node] = front.parent;

            for (Integer nbr : adj[front.node]) {
                q.add(new Pair(nbr, front.node));
            }
        }

        LinkedList<Integer> path = new LinkedList<>();
        while (dest != -1) {
            path.addFirst(dest);
            dest = parent[dest];
        }
        return path;
    }

}
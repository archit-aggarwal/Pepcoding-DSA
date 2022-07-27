import java.util.*;

// Leetcode 210: https://leetcode.com/problems/course-schedule-ii/

// Time - O(N + E) : Cycle Detection + Topological Sort using Kahn's

class Solution {
    int[] BFS(int n, ArrayList<Integer>[] adj) {
        int[] incoming = new int[n];
        for (int src = 0; src < n; src++) {
            for (Integer nbr : adj[src]) {
                incoming[nbr]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        // Multisource Breadth First Traversal
        for (int i = 0; i < n; i++) {
            if (incoming[i] == 0) {
                q.add(i);
            }
        }

        int[] topo = new int[n];
        int idx = 0;
        int visited = 0;

        while (q.size() > 0) {
            int src = q.remove();
            topo[idx++] = src;
            visited++;

            for (Integer nbr : adj[src]) {
                incoming[nbr]--;
                if (incoming[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }

        if (visited == n)
            return topo; // Directed Acyclic Graph
        return new int[0];
        // Cycle Present (incoming > 0):
        // if topological sort is not possible (all visited are not visited)
    }

    @SuppressWarnings("unchecked")
    public int[] findOrder(int n, int[][] prerequisites) {
        // Topological Sort is Valid -> Return Any of Them
        // If not is not possible, then empty return array

        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] edge : prerequisites) {
            adj[edge[1]].add(edge[0]);
            // edge[1] is a pre-requisite of edge[0]
        }

        return BFS(n, adj);
    }
}
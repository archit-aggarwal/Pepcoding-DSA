import java.util.*;

// GfG: https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
// Time = O(N + E) BFS Kahn's Algorithm (Topological Sort)

class Solution {
    public boolean BFS(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] incoming = new int[n];
        for (int src = 0; src < adj.size(); src++) {
            for (Integer nbr : adj.get(src)) {
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

        int visited = 0;

        while (q.size() > 0) {
            int src = q.remove();
            visited++;

            for (Integer nbr : adj.get(src)) {
                incoming[nbr]--;
                if (incoming[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }

        if (visited == n)
            return false;
        // If all nodes are part of topo sort, hence graph is directed acyclic.

        return true; // Cycle is found because some nodes were not visited
    }

    public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> adj) {
        return BFS(n, adj);
    }
}
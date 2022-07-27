import java.util.*;

// GfG: https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1

// Time = O(N * E)
// Input : Edge List
// Output : Distance Visited Array 
// for Single Source All Destinations Shortest Path Algorithm with Negative Weights
// in Directed Weighted Graph

class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int source) {
        int[] dist = new int[V];
        Arrays.fill(dist, 100000000); // 1e8 is taken as Infinity
        dist[source] = 0; // No Relaxations: Shortest Path from Source to Source

        // Edge List to Relax All Edges (V - 1) times
        for (int i = 1; i < V; i++) {
            for (ArrayList<Integer> edge : edges) {
                int outgoing = edge.get(0); // Source of Edge
                int incoming = edge.get(1); // Destination of Edge
                int weight = edge.get(2);

                if (dist[outgoing] == 100000000)
                    continue;
                dist[incoming] = Math.min(dist[incoming], dist[outgoing] + weight);
            }
        }

        return dist;
    }
}

// Follow Up:
// Shortest Path in Directed Acyclic Graph (DAG):
// 1. Edge List in Topological Sorting of Nodes
// 2. Apply Relaxation of All Edges Only Once
// Time = O(N + E) Topological Sort + O(E) for Relaxations
// GfG Article Link:
// https://www.geeksforgeeks.org/shortest-path-for-directed-acyclic-graphs/
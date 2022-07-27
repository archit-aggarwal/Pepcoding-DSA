// https://practice.geeksforgeeks.org/problems/negative-weight-cycle3504/1

import java.util.*;

// Time = O(N * E) Using Bellmon Ford Algorithm

class Solution {
    public int isNegativeWeightCycle(int V, int[][] edges) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // No Relaxations: Shortest Path from Source to Source

        // Edge List to Relax All Edges (V - 1) times
        for (int i = 1; i < V; i++) {
            for (int[] edge : edges) {
                int outgoing = edge[0]; // Source of Edge
                int incoming = edge[1]; // Destination of Edge
                int weight = edge[2];

                if (dist[outgoing] == Integer.MAX_VALUE)
                    continue;
                dist[incoming] = Math.min(dist[incoming], dist[outgoing] + weight);
            }
        }

        // Nth Relaxation
        for (int[] edge : edges) {
            int outgoing = edge[0]; // Source of Edge
            int incoming = edge[1]; // Destination of Edge
            int weight = edge[2];

            if (dist[outgoing] == Integer.MAX_VALUE)
                continue;
            if (dist[outgoing] + weight < dist[incoming])
                return 1;
            // Negative Weight Cycle -> Relaxation is happening in Nth Iteration
        }

        return 0; // No Negative weight cycle
    }
}
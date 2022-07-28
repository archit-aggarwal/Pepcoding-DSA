import java.util.*;

// CodeStudio (Coding Ninjas): 
// https://www.codingninjas.com/codestudio/problems/water-supply-in-a-village_1380956

// Time = O((N + E) * Log N)

class Solution {
    public static class Pair implements Comparable<Pair> {
        int idx;
        int weight;

        Pair(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        public int compareTo(Pair other) {
            return this.weight - other.weight;
        }
    }

    @SuppressWarnings("unchecked")
    public static int supplyWater(int n, int k, int[] wells, int[][] pipes) {
        ArrayList<Pair>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            adj[i] = new ArrayList<>();

        // Original EdgeList (Pipes) into Adjacency List
        for (int[] pipe : pipes) {
            adj[pipe[0]].add(new Pair(pipe[1], pipe[2]));
            adj[pipe[1]].add(new Pair(pipe[0], pipe[2]));
        }

        // Imaginary Node for Well
        for (int i = 0; i < n; i++) {
            adj[0].add(new Pair(i + 1, wells[i]));
            adj[i + 1].add(new Pair(0, wells[i]));
        }

        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(0, 0));
        boolean[] visited = new boolean[n + 1];
        int cost = 0;

        while (q.size() > 0) {
            Pair top = q.remove();

            if (visited[top.idx] == true)
                continue;
            visited[top.idx] = true;
            cost += top.weight;

            for (Pair nbr : adj[top.idx]) {
                q.add(new Pair(nbr.idx, nbr.weight));
            }
        }

        return cost;
    }
}
import java.util.*;
// Leetcode 797: https://leetcode.com/problems/all-paths-from-source-to-target/

class Solution {
    public void DFS(int src, int dest, boolean[] vis, int[][] graph,
            List<Integer> path, List<List<Integer>> paths) {
        if (vis[src] == true)
            return;

        vis[src] = true;
        path.add(src);

        if (src == dest) {
            paths.add(new ArrayList<>(path)); // DEEP COPY
        }

        for (int nbr : graph[src]) {
            DFS(nbr, dest, vis, graph, path, paths);
        }

        // BACKTRACK
        vis[src] = false;
        path.remove(path.size() - 1);
    }

    // Time Complexity - O(Exponential)
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> paths = new ArrayList<>();
        boolean[] vis = new boolean[graph.length];

        DFS(0, graph.length - 1, vis, graph, path, paths);
        return paths;
    }
}
import java.util.*;

// 1319: https://leetcode.com/problems/number-of-operations-to-make-network-connected/

// Time - O(N + E) DFS
class Solution {
    @SuppressWarnings("unchecked")
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1)
            return -1; // To connect all nodes need at least n-1 edges
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (int[] c : connections) {
            graph[c[0]].add(c[1]);
            graph[c[1]].add(c[0]);
        }

        int components = 0;
        boolean[] visited = new boolean[n];
        for (int v = 0; v < n; v++)
            components += dfs(v, graph, visited);
        return components - 1; // Need (components-1) cables to connect components together
    }

    int dfs(int u, List<Integer>[] graph, boolean[] visited) {
        if (visited[u])
            return 0;
        visited[u] = true;
        for (int v : graph[u])
            dfs(v, graph, visited);
        return 1;
    }
}
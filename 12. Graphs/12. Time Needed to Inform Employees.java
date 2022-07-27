import java.util.*;

// 1376: https://leetcode.com/problems/time-needed-to-inform-all-employees/

class Pair {
    int nbr;
    int wt;

    Pair(int nbr, int wt) {
        this.nbr = nbr;
        this.wt = wt;
    }
}

class Graph {
    ArrayList<Pair>[] adj;

    @SuppressWarnings("unchecked")
    Graph(int n) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int src, int nbr, int wt) {
        // Directed And Weighted
        adj[src].add(new Pair(nbr, wt));
    }
}

// Time - O(N + E) DFS
class Solution {
    public int DFS(int src, int time, Graph g) {
        int maxTime = time;
        for (Pair p : g.adj[src]) {
            maxTime = Math.max(maxTime, DFS(p.nbr, time + p.wt, g));
        }
        return maxTime;
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Graph g = new Graph(n);

        int time = 0;

        for (int i = 0; i < n; i++) {
            if (manager[i] == -1) {
                time = informTime[i];
            } else {
                // manager[i] -> parent, i -> Child
                g.addEdge(manager[i], i, informTime[i]);
            }

        }

        return DFS(headID, time, g);
    }
}
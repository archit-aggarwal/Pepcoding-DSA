import java.util.*;

// CodeStudio (CN): https://www.codingninjas.com/codestudio/problems/parallel-courses_1376444

// Time = O(N + E) Topological Sort using Kahn's

class Solution {
    static int BFS(int n, ArrayList<Integer>[] adj) {
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

        int visited = 0;
        int level = 0;

        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int src = q.remove();
                visited++;
                for (Integer nbr : adj[src]) {
                    incoming[nbr]--;
                    if (incoming[nbr] == 0) {
                        q.add(nbr);
                    }
                }
            }
            level++;
        }

        if (visited == n)
            return level;
        return -1;
    }

    @SuppressWarnings("unchecked")
    public static int parallelCourses(int n, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] edge : prerequisites) {
            adj[edge[1] - 1].add(edge[0] - 1);
            // edge[1] is a pre-requisite of edge[0]
        }

        return BFS(n, adj);
    }
}
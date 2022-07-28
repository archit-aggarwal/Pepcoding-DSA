import java.util.*;

// 1584: https://leetcode.com/problems/min-cost-to-connect-all-points/
// Time = O((N + E)* Log N) where E = O(N^2) (Complete Graph)

class Solution {
    public static class Pair implements Comparable<Pair> {
        int idx;
        int weight;

        public Pair(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        public int compareTo(Pair other) {
            return (this.weight - other.weight);
            // Min Priority Queue -> Negative for this < other
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        boolean[] vis = new boolean[n];
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(0, 0));

        int cost = 0, count = 0;
        while (q.size() > 0 && count < n) {
            Pair top = q.remove();
            if (vis[top.idx] == true)
                continue; // CYCLE

            vis[top.idx] = true;
            cost = cost + top.weight;
            count++;

            for (int i = 0; i < n; i++) {
                if (top.idx == i)
                    continue; // Ignore Self Loop

                int dist = Math.abs(points[top.idx][0] - points[i][0])
                        + Math.abs(points[top.idx][1] - points[i][1]);
                q.add(new Pair(i, dist));
            }
        }

        return cost;
    }
}
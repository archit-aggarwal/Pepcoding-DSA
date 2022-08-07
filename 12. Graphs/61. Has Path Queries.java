import java.util.*;
// leetcode 1697:
// https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/

class Solution {
    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            Arrays.fill(parent, -1);

            rank = new int[n];
            Arrays.fill(rank, 1);
        }

        public void union(int a, int b) {
            a = find(a);
            b = find(b);

            if (a == b)
                return;
            if (rank[a] >= rank[b]) {
                rank[a] += rank[b];
                parent[b] = a;
            } else {
                rank[b] += rank[a];
                parent[a] = b;
            }
        }

        public int find(int a) {
            if (parent[a] == -1)
                return a;
            return parent[a] = find(parent[a]);
        }
    }

    static class Query implements Comparable<Query> {
        int idx, src, nbr, limit;

        Query(int idx, int src, int nbr, int limit) {
            this.idx = idx;
            this.src = src;
            this.nbr = nbr;
            this.limit = limit;
        }

        public int compareTo(Query other) {
            return this.limit - other.limit;
        }
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edges, int[][] queries) {
        List<Query> sortedQ = new ArrayList<>();
        for (int i = 0; i < queries.length; i++)
            sortedQ.add(new Query(i, queries[i][0], queries[i][1], queries[i][2]));
        Collections.sort(sortedQ);

        Arrays.sort(edges, (e1, e2) -> e1[2] - e2[2]);
        int e = 0;
        boolean[] ans = new boolean[queries.length];
        DSU dsu = new DSU(n);

        for (Query q : sortedQ) {
            while (e < edges.length && edges[e][2] < q.limit) {
                dsu.union(edges[e][0], edges[e][1]);
                e++;
            }

            if (dsu.find(q.src) == dsu.find(q.nbr))
                ans[q.idx] = true;
        }
        return ans;
    }
}
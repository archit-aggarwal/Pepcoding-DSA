import java.util.*;
// leetcode 1627:
// https://leetcode.com/problems/graph-connectivity-with-threshold/

class DSU {
    int[] parent;
    int[] rank;

    DSU(int n) {
        parent = new int[n + 1];
        Arrays.fill(parent, -1);

        rank = new int[n + 1];
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

class Solution {
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        DSU sets = new DSU(n);
        for (int i = threshold + 1; i <= n; i++) {
            for (int j = 2 * i; j <= n; j += i)
                sets.union(i, j);
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            if (sets.find(query[0]) == sets.find(query[1])) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
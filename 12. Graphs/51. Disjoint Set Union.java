import java.util.*;

class TestClass {
    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            Arrays.fill(parent, -1);
            rank = new int[n];
        }

        public void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb)
                return;

            if (rank[pa] > rank[pb]) {
                parent[pb] = pa;
                rank[pa] += rank[pb];
            } else {
                parent[pa] = pb;
                rank[pb] += rank[pa];
            }
        }

        public int find(int a) {
            if (parent[a] == -1)
                return a;
            return parent[a] = find(parent[a]);
        }
    }

    public static void main(String args[]) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        DSU sets = new DSU(n + 1);

        int e = scn.nextInt();
        while (e-- > 0) {
            int a = scn.nextInt();
            int b = scn.nextInt();
            sets.union(a, b);
        }

        int components = 0;
        for (int i = 1; i <= n; i++) {
            if (sets.find(i) == i)
                components++;
        }
        System.out.println(components);
        scn.close();
    }
}

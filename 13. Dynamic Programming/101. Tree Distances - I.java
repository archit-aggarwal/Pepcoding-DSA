
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main {
    @SuppressWarnings("unchecked")
    public static void dfs(int src, int par, ArrayList<Integer>[] adj, int depth, int[] height) {
        height[src] = depth;
        for (Integer nbr : adj[src]) {
            if (par == nbr)
                continue;
            dfs(nbr, src, adj, depth + 1, height);
        }
    }

    @SuppressWarnings("unchecked")
    public static int[] solve(ArrayList<Integer>[] adj) {
        int n = adj.length;

        int[] height = new int[n];
        dfs(0, -1, adj, 0, height);

        int da = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] > height[da])
                da = i;
        }

        int[] d1 = new int[n];
        dfs(da, -1, adj, 0, d1);

        int db = 0;
        for (int i = 0; i < n; i++) {
            if (d1[i] > d1[db])
                db = i;
        }

        int[] d2 = new int[n];
        dfs(db, -1, adj, 0, d2);

        for (int i = 0; i < n; i++) {
            height[i] = Math.max(d1[i], d2[i]);
        }

        return height;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int a = scn.nextInt();
            int b = scn.nextInt();

            adj[a - 1].add(b - 1);
            adj[b - 1].add(a - 1);
        }

        int[] ans = solve(adj);
        for (int val : ans)
            System.out.print(val + " ");
    }
}

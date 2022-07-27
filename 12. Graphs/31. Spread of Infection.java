import java.io.*;
import java.util.*;

// NADOS: https://nados.io/question/spread-of-infection?zen=true
// Time = O(N + E) BFS

class Main {
    static class Pair {
        int src;
        int dist;

        Pair(int src, int dist) {
            this.src = src;
            this.dist = dist;
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        int src = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));

        int infected = 0;
        boolean[] vis = new boolean[n];

        while (q.size() > 0) {
            Pair front = q.remove();

            if (vis[front.src] == true)
                continue;
            vis[front.src] = true;

            if (front.dist < t)
                infected++;
            else
                break;

            for (Integer nbr : graph[front.src]) {
                q.add(new Pair(nbr, front.dist + 1));
            }
        }

        System.out.println(infected);
    }
}
import java.io.*;
import java.util.*;

// NADOS: https://nados.io/question/get-connected-components-of-a-graph?zen=true

class Main {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void DFS(int src, ArrayList<Edge>[] graph,
            boolean[] vis, List<Integer> component) {
        if (vis[src] == true)
            return;

        vis[src] = true;
        component.add(src);

        for (Edge e : graph[src]) {
            DFS(e.nbr, graph, vis, component);
        }
    }

    // Time - O(N + E) Same as DFS, Space - O(N) Visited Array - Extra Space
    // O(N) Components Arraylist - Output Space, O(N) Recursion Call Stack Space
    public static void connectedComponents(ArrayList<Edge>[] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];

        List<List<Integer>> components = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                List<Integer> component = new ArrayList<>();
                DFS(i, graph, vis, component);
                components.add(component);
            }
        }

        System.out.println(components);
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        connectedComponents(graph);
    }
}
import java.io.*;
import java.util.*;

// NADOS: https://nados.io/question/hamiltonian-path-and-cycle?zen=true

class Main {

    public static boolean isEdge(int src, int dest, ArrayList<Integer>[] graph) {
        for (Integer nbr : graph[src]) {
            if (nbr == dest)
                return true;
        }
        return false;
    }

    // Time - O(Exponential) All Paths from Source to Destination
    public static void DFS(int src, boolean[] vis, ArrayList<Integer>[] graph, int visCount, String path) {
        if (vis[src] == true)
            return;

        vis[src] = true;
        visCount++;

        // All Nodes are Visited
        if (visCount == graph.length) {
            System.out.print(path);

            int a = path.charAt(0) - '0';
            if (isEdge(a, src, graph) == true) {
                System.out.println('*'); // Hamiltonian Cycle
            } else {
                System.out.println('.'); // Hamiltonian Path
            }

        }

        for (Integer nbr : graph[src]) {
            DFS(nbr, vis, graph, visCount, path + nbr);
        }

        vis[src] = false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
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

        boolean[] vis = new boolean[vtces];
        DFS(src, vis, graph, 0, "" + src);
    }

}
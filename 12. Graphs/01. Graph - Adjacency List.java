import java.util.*;

class Pair {
    int nbr, weight;

    // Unweighted
    Pair(int nbr) {
        this(nbr, 1);
    }

    // Weighted
    Pair(int nbr, int weight) {
        this.nbr = nbr;
        this.weight = weight;
    }
}

class Graph {
    ArrayList<Pair>[] adj;

    Graph(int n) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    // Unweighted Graph
    public void addEdge(int src, int dest, boolean isDirected) {
        adj[src].add(new Pair(dest));
        if (isDirected == false)
            adj[dest].add(new Pair(src));
    }

    // Weighted Graph
    public void addEdge(int src, int dest, int weight, boolean isDirected) {
        adj[src].add(new Pair(dest, weight));
        if (isDirected == false)
            adj[dest].add(new Pair(src, weight));
    }

    public void printAdjList() {
        for (int i = 0; i < adj.length; i++) {
            // Loop on Neighbours present in adj[i]
            for (int j = 0; j < adj[i].size(); j++) {
                System.out.println(i + " -> "
                        + adj[i].get(j).nbr + " " + adj[i].get(j).weight);
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int vtces = scn.nextInt();
        Graph g = new Graph(vtces);

        int edges = scn.nextInt();
        for (int i = 0; i < edges; i++) {
            int src = scn.nextInt();
            int dest = scn.nextInt();
            int weight = scn.nextInt();
            g.addEdge(src, dest, weight, false);
        }

        g.printAdjList();
    }
}
class Solution {
    public boolean DFS(ArrayList<Integer> adj[], boolean[] vis, int src, int dest){
        if(src == dest) return true;
        if(vis[src] == true) return false;
        
        vis[src] = true;
        for(int nbr: adj[src]){
            if(DFS(adj, vis, nbr, dest) == true) return true;
        }
        return false;
    }
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] vis = new boolean[n];
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] e: edges){
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        return DFS(adj, vis, source, destination);
    }
}
import java.io.*;
import java.util.*;

public class Main {
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
   
   public static boolean isEdgePresent(ArrayList<Edge>[] graph, int src, int dest){
        for(Edge e: graph[src]){
            if(e.nbr == dest){
                return true;
            }
        }
        return false;
   }
   
   public static void dfs(ArrayList<Edge>[] graph, int node, int visCount, boolean[] vis, String pathSofar){
        
        if(visCount == graph.length - 1)
        { 
            // hamiltonian path or cycle
            if(isEdgePresent(graph, pathSofar.charAt(0) - '0', node)){
                // cycle check -> is there a edge between src and 0
                System.out.println(pathSofar + "*"); 
            } else {
                System.out.println(pathSofar + ".");
            }
            return;
        }    
        
        visCount++;
        vis[node] = true;
        
        for(Edge e: graph[node]){
            if(vis[e.nbr] == false){ 
                dfs(graph, e.nbr, visCount, vis, pathSofar + e.nbr);
            }
        }
        
        vis[node] = false;
   }
   
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

      int src = Integer.parseInt(br.readLine());
      boolean[] vis = new boolean[vtces];
      
      dfs(graph, src, 0, vis, "" + src);
   }


}

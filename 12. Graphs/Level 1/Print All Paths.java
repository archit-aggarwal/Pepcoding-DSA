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
   
   // Print All Paths from Source to Destination -> Backtracking -> O(N^N) or O(N!) -> Exponential
   public static void dfs(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis, String pathSofar){
        if(src == dest){
            System.out.println(pathSofar);
            return;
        }    
        
        vis[src] = true;
        
        for(Edge e: graph[src]){
            if(vis[e.nbr] == false){ // already visited
                dfs(graph, e.nbr, dest, vis, pathSofar + e.nbr);
            }
        }
        
        vis[src] = false; // unmarking node to visit it again using other paths
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
      int dest = Integer.parseInt(br.readLine());
        
      boolean vis[] = new boolean[vtces];
      
      // write all your codes here
      dfs(graph, src, dest, vis, "" + src);
   }


}

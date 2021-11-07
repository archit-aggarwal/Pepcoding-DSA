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
   
   public static void dfs(ArrayList<Edge>[] graph, int[] count, int src, boolean[] vis){
        vis[src] = true;
        count[0]++;
        
        for(Edge e: graph[src]){
            if(vis[e.nbr] == false){ 
                dfs(graph, count, e.nbr, vis);
            }
        }
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
         graph[v1].add(new Edge(v1, v2, -1));
         graph[v2].add(new Edge(v2, v1, -1));
      }

      ArrayList<Integer> comps = new ArrayList<>();
      boolean[] vis = new boolean[vtces];
      
      for(int i=0; i<vtces; i++){
          if(vis[i] == false){
              int[] count = new int[1];
              dfs(graph, count, i,vis);
              comps.add(count[0]);
          }
      }
      
    //   int countWays = 0;
    //   for(int c1 = 0; c1 < comps.size(); c1++){
    //       for(int c2 = c1 + 1; c2 < comps.size(); c2++){
    //           countWays = countWays + comps.get(c1) * comps.get(c2);
    //       }
    //   }
    
      int countWays = 0;
      int remVtces = vtces;
      
      for(int size: comps){
          remVtces -= size;
          countWays += remVtces * size;
      }
      System.out.println(countWays);
   }
}

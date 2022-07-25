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

   public static boolean DFS(ArrayList<Edge>[] graph, int src, int level, boolean[] vis, HashSet<Integer> odd, HashSet<Integer> even){
       vis[src] = true;
       if(level % 2 == 0){
           even.add(src);
       } else {
           odd.add(src);
       }
       
       
       for(Edge e: graph[src]){
           
           if(vis[e.nbr] == false){
               
               boolean res = DFS(graph, e.nbr, level + 1, vis, odd, even);
               if(res == false) return false;
               
           } else {
               
               // Src par khade hoke nbr ka decision le rahe hai -> level + 1
               if(odd.contains(e.nbr) == true && (level + 1) % 2 == 0){
                   // previously odd set & currently even set
                   return false;
               }
               
               if(even.contains(e.nbr) == true && (level + 1) % 2 == 1){
                   return false;
               }
           }
           
       }
       
       return true;
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

      // write your code here
      HashSet<Integer> odd = new HashSet<>();
      HashSet<Integer> even = new HashSet<>();
      boolean[] vis = new boolean[vtces];
      
      
      for(int i=0; i<vtces; i++){
          
          if(vis[i] == false){
              
              boolean isBipartite = DFS(graph, i, 0, vis, odd, even);
              
              if(isBipartite == false){
                  System.out.println(false);
                  return;
              }
          }
          
      }
      System.out.println(true);
   }
}

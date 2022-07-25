import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }

   static class Pair{
       int node;
       String pathSofar;
       
       Pair(int node, String pathSofar){
           this.node = node;
           this.pathSofar = pathSofar;
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }
      
      int src = Integer.parseInt(br.readLine());
      // write your code here  
      
      Queue<Pair> q = new LinkedList<>();
      boolean[] vis = new boolean[vtces];
      
      q.add(new Pair(src, "" + src));
      
      while(q.size() > 0){
          // remove
          Pair curr = q.remove();
          
          if(vis[curr.node] == true) continue;
          
          // mark*
          vis[curr.node] = true;
          
          // work
          System.out.println(curr.node + "@" + curr.pathSofar);
          
          // add*
          for(Edge e: graph[curr.node]){
              if(vis[e.nbr] == false){
                  q.add(new Pair(e.nbr, curr.pathSofar + e.nbr));
              }
          }
      }
   }
}

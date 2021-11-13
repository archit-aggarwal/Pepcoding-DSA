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
       int time;
       
       Pair(int node, int time){
           this.node = node;
           this.time = time;
       }
   }
   
   static int totalTime;
   public static void DFS(ArrayList<Edge>[] graph, int src, int time, int[] vis, HashSet<Integer> infected){
        if(time > totalTime) return;
        
        vis[src] = time;
        infected.add(src);
        
        for(Edge e: graph[src]){
            if(vis[e.nbr] == -1){
                DFS(graph, e.nbr, time + 1, vis, infected);
            } else {
                // Time Complexity will be poor (Exponential in worst case)
                if(time + 1 < vis[e.nbr]){
                    DFS(graph, e.nbr, time + 1, vis, infected);
                }
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      
      totalTime = t;
      int[] vis = new int[vtces];
      Arrays.fill(vis, -1);
      HashSet<Integer> infected = new HashSet<>();
      DFS(graph, src, 1, vis, infected);
      System.out.println(infected.size());
      
    //   Queue<Pair> q = new LinkedList<>();
    //   boolean[] vis = new boolean[vtces];
      
    //   q.add(new Pair(src, 1));
    //   int count = 0;
      
    //   while(q.size() > 0){
    //       // remove
    //       Pair curr = q.remove();
           
          
    //       if(vis[curr.node] == true) continue;
    //       vis[curr.node] = true;
          
    //       // work
    //       if(curr.time > t) break;
          
    //       count++;    
          
    //       // add*
    //       for(Edge e: graph[curr.node]){
    //           if(vis[e.nbr] == false){
    //               q.add(new Pair(e.nbr, curr.time + 1));
    //           }
    //       }
    //   }
      
    //   System.out.println(count);
   }

}

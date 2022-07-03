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

   static String smallestPath = "";
   static int smallestPathWt = Integer.MAX_VALUE;
   
   static String largestPath = "";
   static int largestPathWt = Integer.MIN_VALUE;
   
   static String floorPath = "";
   static int floorWt = Integer.MIN_VALUE;
   
   static String ceilPath = "";
   static int ceilWt = Integer.MAX_VALUE;
   
   static class Pair implements Comparable<Pair>{
       String pathSofar;
       int weightSofar;
       
       Pair(String psf, int wsf){
           pathSofar = psf;
           weightSofar = wsf;
       }
       
       public int compareTo(Pair other){
           return this.weightSofar - other.weightSofar;
       }
   }
   
   static int val = 0;
   static int k = 0;
   static PriorityQueue<Pair> q = new PriorityQueue<>();
   
   public static void dfs(ArrayList<Edge>[] graph, int src, int dest, 
            boolean[] vis, String pathSofar, int weightSofar){
        if(src == dest){
            // Smallest path
            if(weightSofar < smallestPathWt){
                smallestPath = pathSofar;
                smallestPathWt = weightSofar;
            }
            
            // largest path
            if(weightSofar > largestPathWt){
                largestPath = pathSofar;
                largestPathWt = weightSofar;
            }
            
            // floor 
            if(weightSofar < val && weightSofar > floorWt){
                floorPath = pathSofar;
                floorWt = weightSofar;
            }
            
            // ceil
            if(weightSofar > val && weightSofar < ceilWt){
                ceilPath = pathSofar;
                ceilWt = weightSofar;
            }
            
            // kth largest
            if(q.size() < k){
                q.add(new Pair(pathSofar, weightSofar));
            } else if(weightSofar > q.peek().weightSofar){
                q.remove();
                q.add(new Pair(pathSofar, weightSofar));
            }
                
            return;
        }    
        
        vis[src] = true;
        
        for(Edge e: graph[src]){
            if(vis[e.nbr] == false){
                dfs(graph, e.nbr, dest, vis, pathSofar + e.nbr, weightSofar + e.wt);
            }
        }
        
        vis[src] = false;
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
      val = Integer.parseInt(br.readLine());
      k = Integer.parseInt(br.readLine());
      
      boolean vis[] = new boolean[vtces];
      
      // write all your codes here
      dfs(graph, src, dest, vis, "" + src, 0);
      
      System.out.println("Smallest Path = " + smallestPath + "@" + smallestPathWt);
      System.out.println("Largest Path = " + largestPath + "@" + largestPathWt);
      System.out.println("Just Larger Path than " + val + " = " + ceilPath + "@" + ceilWt);
      System.out.println("Just Smaller Path than " + val + " = " + floorPath + "@" + floorWt);
      System.out.println(k + "th largest path = " + q.peek().pathSofar + "@" + q.peek().weightSofar);
   }


}

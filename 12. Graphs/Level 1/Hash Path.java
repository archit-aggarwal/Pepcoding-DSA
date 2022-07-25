import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;
      Edge(int src, int nbr){
        // for unweighted graph
        this.src = src;
        this.nbr = nbr;
      }
      Edge(int src, int nbr, int wt){
         // for weighted graph
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   
   public static void display(ArrayList<Edge>[] graph){
        int vts = graph.length;
        
        for(int i=0; i<vts; i++){
            
            System.out.print(i + ": ");
            
            // Adjacency List of Vertex i
            for(Edge e: graph[i]){
                System.out.print("{ " + e.src + ", " + e.nbr + " @ " + e.wt + "}, ");    
            }
            
            System.out.println();
        }
   }
   
   // Check if Source to Destination Path exists or not - O(N + E) where N = total vertices, E = total edges
  
   public static boolean dfs(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis){
        if(src == dest){
            return true;
        }    
        
        vis[src] = true;
        
        for(Edge e: graph[src]){
            if(vis[e.nbr] == false){ // already visited
                boolean res = dfs(graph, e.nbr, dest, vis);
                if(res == true) return true;
            }
        }
        
        return false;
   }
   
   public static void main(String[] args) throws Exception {
       Scanner scn = new Scanner(System.in);
       int vts = scn.nextInt();
       
       ArrayList<Edge>[] graph = new ArrayList[vts];
       for(int i=0; i<vts; i++){
           graph[i] = new ArrayList<>();
       }
       
       int edges = scn.nextInt();
       
       for(int i=0; i<edges; i++){
           int v1 = scn.nextInt();
           int v2 = scn.nextInt();
           int wt = scn.nextInt();
           
           graph[v1].add(new Edge(v1, v2, wt));
           graph[v2].add(new Edge(v2, v1, wt));
       }
       
       int src = scn.nextInt();
       int dest = scn.nextInt();
        
       boolean[] vis = new boolean[vts];
       System.out.println(dfs(graph, src, dest, vis));
    }

}

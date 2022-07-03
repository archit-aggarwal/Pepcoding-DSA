import java.io.*;
import java.util.*;

public class Main {
    
   public static class Pair implements Comparable<Pair> {
       int data;
       int listIdx; // to know that which arraylist element belongs to
       int dataIdx; // to know index of next element to be inserted from that arraylist
       
       Pair() {}
       
       Pair(int data, int listIdx, int dataIdx){
           this.data = data;
           this.listIdx = listIdx;
           this.dataIdx = dataIdx;
       }
       
       public int compareTo(Pair other){
           // compare Pair on basis of data, smaller data -> higher priority
           return this.data - other.data;
       }
   }  
   
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      PriorityQueue<Pair> q = new PriorityQueue<>();
      ArrayList<Integer> res = new ArrayList<>();
      
      // Insert 0th index element of each arraylist 
      // O(k log k)
      for(int i=0; i<lists.size(); i++){
        q.add(new Pair(lists.get(i).get(0), i, 0));    
      }
      
      // O(Nt * logk) 
      while(q.size() > 0){
          // Pop one pair
          Pair top = q.remove();
          res.add(top.data);
          
          if(top.dataIdx + 1 < lists.get(top.listIdx).size()){
              // insert next pair
              q.add(new Pair(lists.get(top.listIdx).get(top.dataIdx + 1), top.listIdx, top.dataIdx + 1));
          }
      }
      
      // O(Nt * logk + k * logk) where Nt = n1 + n2 + n3 + ... nk
      return res;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}
